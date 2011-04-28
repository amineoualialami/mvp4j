package org.mvp4j.impl.swing.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class JtableUtils {

	private static Logger logger = LoggerUtils.getLogger();
	static List<Field> fields;

	public static List<Object> getColumns(Object initListObject,
			Map<Integer, String> customizedColumns) {

		List<Object> columns = new ArrayList();

		if (customizedColumns.size() == 0) {
			initFields(initListObject, customizedColumns);
			for (Field field : getFields()) {
				field.setAccessible(true);
				columns.add(field.getName());
			}
			return columns;

		} else {
			
			for (Object object : customizedColumns.values().toArray()) {
				columns.add(object.toString());
			}
			initFields(initListObject, customizedColumns);
			return columns;
		}

	}

	public static List getRow(Object object) {
		List row = new ArrayList();
		for (Field field : fields) {

			field.setAccessible(true);
			try {
				row.add(field.get(object));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return row;
	}

	public static List<Field> getFields() {
		return fields;
	}

	public static void initFields(Object initListObject,
			Map<Integer, String> customizedColumns) {

		fields = new ArrayList<Field>();
		List objectList = (List) initListObject;
		if (objectList.isEmpty()) {
			logger.info("The init property is not initialized correctly");
			throw new IllegalArgumentException();
		}
		Object object = objectList.get(0);
		Class objectClass = object.getClass();
		
		
		if (customizedColumns.size() == 0) {

			Field[] allFields = objectClass.getDeclaredFields();
			for (Field field : allFields) {
				fields.add(field);
			}
		} else {
			Field[] allFields = objectClass.getDeclaredFields();
			for (int i=0;i<allFields.length;i++) {
				if(customizedColumns.containsKey(i)){
					fields.add(allFields[i]);
				}
			}
		}
	}

}
