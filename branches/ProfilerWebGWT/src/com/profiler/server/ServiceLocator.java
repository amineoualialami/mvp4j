package com.profiler.server;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;



public class ServiceLocator {

	private static Object remoteInterface;

	public static Object getRemoteInterface(String jndiName) {
		try {
			Properties properties = new Properties();
			properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
			properties.put("java.naming.provider.url","127.0.0.1:1099");
			InitialContext initialContext = new InitialContext(properties);
			
			remoteInterface = initialContext.lookup(jndiName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return remoteInterface;
	}
	
	
	

}
