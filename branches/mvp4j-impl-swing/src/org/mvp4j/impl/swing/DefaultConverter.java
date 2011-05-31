package org.mvp4j.impl.swing;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class DefaultConverter implements Converter {

	private Logger logger = LoggerUtils.getLogger();
	

	@Override
	public Object convertComponentToModel(Object type, Object value) {
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
			
			logger.error("The type : " + type.toString()
					+ " is not supported with the value of type String");
			throw new IllegalArgumentException();
		}
		else if (value instanceof Object)
			return value;
		else {
			logger.error("Unable to convert value " + value
					+ " to any supported type");
			throw new IllegalArgumentException();
		}
	}


	@Override
	public Object convertModelToComponent(Object value) {
		if(value instanceof Collection){
			
			return value;
		}
		return value.toString();
	}
	
}
