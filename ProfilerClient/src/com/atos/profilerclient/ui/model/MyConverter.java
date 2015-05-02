package com.atos.profilerclient.ui.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.mvp4j.Converter;

public class MyConverter implements Converter {

	@Override
	public Object convertComponentToModel(Object type, Object value) {
		
		DateFormat formater=new SimpleDateFormat("dd-mm-yyyy");
		Date dateformat = null;
		try {
			 dateformat=formater.parse(""+value);
			 dateformat=formater.parse(formater.format(dateformat));
		} catch (ParseException e) {
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
