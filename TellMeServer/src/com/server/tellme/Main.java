package com.server.tellme;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.server.tellme.server.TellMeServer;
import com.tellme.common.dao.MongoDao;
import com.tellme.common.entity.User;
import com.tellme.common.service.UserService;

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
		/*
		UserService userService=(UserService)context.getBean("userService");
		MongoDao mongdao=(MongoDao)context.getBean("mongoDao");
		//MongoTemplate usermong=(MongoTemplate)context.getBean("usermsgMongoTemplate");
		User user=new User();
		user.setName("tancyu");
		userService.save(user, User.CollectionName);
		System.out.println("ok");
		*/
		tellmeserver=(TellMeServer)context.getBean("tellmeserver");
		tellmeserver.start();

	}

}
