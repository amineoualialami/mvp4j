package org.mvp4j.impl.gwt;

import java.util.Collection;

import org.mvp4j.Converter;

import com.google.gwt.core.client.GWT;
import com.gwtent.reflection.client.TypeOracle;

public class DefaultConverter implements Converter {

	@Override
	public Object convertComponentToModel(Object type, Object value) {
		if (value instanceof String) {
			if (type == TypeOracle.Instance.getClassType(Integer.class))
				return new Integer((String) value);
			else if (type == TypeOracle.Instance.getClassType(int.class))
				return new Integer((String) value);
			else if (type == TypeOracle.Instance.getClassType(float.class))
				return new Float((String) value);
			else if (type == TypeOracle.Instance.getClassType(Float.class))
				return new Float((String) value);
			else if (type == TypeOracle.Instance.getClassType(String.class))
				return value.toString();
			else if (type == TypeOracle.Instance.getClassType(double.class))
				return new Double((String) value);
			else if (type == TypeOracle.Instance.getClassType(Double.class))
				return new Double((String) value);

//			logger.error("The type : " + type.getName()
//					+ " is not supported with the value of type String");
			GWT.log("The type : " + type.toString()
					+ " is not supported with the value of type String");
			throw new IllegalArgumentException();
		} else if (value instanceof Object)
			return value;
		else {
//			logger.error("Unable to convert value " + value
//					+ " to any supported type");
			GWT.log("Unable to convert value " + value
					+ " to any supported type");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Object convertModelToComponent(Object value) {
		if (value instanceof Collection) {

			return value;
		}
		return value.toString();
	}

}
