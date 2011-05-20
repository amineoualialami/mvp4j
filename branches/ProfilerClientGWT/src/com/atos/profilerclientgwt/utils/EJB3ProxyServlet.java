package com.atos.profilerclientgwt.utils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EJB3ProxyServlet extends RemoteServiceServlet {

	@Override
	public String processCall(String payload) throws SerializationException {
		try {
			Object obj = null;
			InitialContext ctx;
			RPCRequest rpcRequest = null;
			try {

				Hashtable env = new Hashtable();
				env.put(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");
				env.put(Context.PROVIDER_URL, "localhost");
				env.put(Context.URL_PKG_PREFIXES,
						"org.jboss.naming:org.jnp.interfaces");
				ctx = new InitialContext(env);
				// Récupère le nom de l'EJB à partir de l'URL du service RPC
				String[] path = getThreadLocalRequest().getServletPath().split(
						"/");
				// Il préférable de faire des appels locaux EJB en mode GWT RPC
				obj = ctx.lookup("EAR Name" + path[path.length - 1] + "/local");
				HttpServletRequest mod = this.getThreadLocalRequest();
				rpcRequest = RPC.decodeRequest(payload, obj.getClass());

				// Cherche la méthode en question dans le proxy EJB
				for (Method m : obj.getClass().getMethods()) {
					if (equalsMethod(rpcRequest.getMethod(), m)) {
						// > GWT 1.4
						return RPC.invokeAndEncodeResponse(obj, m,
								rpcRequest.getParameters(),
								rpcRequest.getSerializationPolicy());
					}
				}
			} catch (NamingException e) {
				// Gestion d'erreur minimaliste
			}

			throw new InvocationException("Method not found");

		} catch (InvocationException ex) {
			return RPC.encodeResponseForFailure(null, ex);
		}
	}
	
	
	
	
	
	public boolean equalsMethod(Method m1, Method m2) {
		// test the method name
		if (!m1.getName().equals(m2.getName())) {
			return false;
		}

		if (!m1.getReturnType().equals(m2.getReturnType()))
			return false;

		Class[] params1 = m1.getParameterTypes();
		Class[] params2 = m2.getParameterTypes();
		if (params1.length == params2.length) {
			for (int i = 0; i < params1.length; i++) {
				if (params1[i] != params2[i])
					return false;
			}
			return true;
		}
		return false;
	}



}
