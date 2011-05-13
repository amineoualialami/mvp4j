package com.atos.profilerclient.ui.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.SimpleFormatter;

import org.mvp4j.Converter;

public class MyConverter implements Converter {

	@Override
	public Object convertComponentToModel(Class<?> type, Object value) {
		
		DateFormat formater=new SimpleDateFormat("yyyy/mm/dd");
		Date dateformat = null;
		try {
			 dateformat=formater.parse(""+value);
			 dateformat=formater.parse(formater.format(dateformat));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
		return dateformat ;
	}

	@Override
	public Object convertModelToComponent(Object value) {
		
		DateFormat formater=new SimpleDateFormat("dd-mm-yyyy") ;
		return formater.format(value);
	}


}
