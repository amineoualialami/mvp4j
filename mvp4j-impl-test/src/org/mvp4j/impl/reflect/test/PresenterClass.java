package org.mvp4j.impl.reflect.test;

import net.sf.classmock.ClassMock;

public class PresenterClass  extends ClassMock{

	


	public PresenterClass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void addUser(){
		System.out.println("AddUser action is invoked");
	}
}
