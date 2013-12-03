package com.server.tellme;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.server.tellme.server.TellMeServer;

public class Main {

	/**
	 * @param args
	 */
	public static TellMeServer tellmeserver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		ApplicationContext context;
		context = new ClassPathXmlApplicationContext(new String[] {"tellmeservermvc.xml"});
		tellmeserver=(TellMeServer)context.getBean("tellmeserver");
		tellmeserver.start();

	}

}
