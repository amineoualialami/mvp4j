package com.atos.profilerclient.ui.model;

import org.mvp4j.Converter;

public class MyConverter implements Converter {

	@Override
	public Object convertToType(Class<?> type, Object value) {
		System.out.println("----------------------MyConverter------------------");
		if (value instanceof String) {
			if (type == Integer.class)
				return new Integer((String) value);
			else if(type==int.class)
				return new Integer((String) value);
			else if(type==float.class)
				return new Float((String) value);
			else if (type == Float.class)
				return new Float((String) value);
			else if (type == String.class)
				return value.toString();
			else if(type==double.class)
				return new Double((String) value);
			else if (type == Double.class)
				return new Double((String) value);
			
			
			throw new IllegalArgumentException();
		}
		else if (value instanceof Object)
			return value;
		else {
			throw new IllegalArgumentException();
		}
		
	}

}
