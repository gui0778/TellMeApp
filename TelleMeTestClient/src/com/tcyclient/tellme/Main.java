package com.tcyclient.tellme;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.server.tellme.entity.Gps;
import com.server.tellme.entity.User;
import com.server.tellme.entity.UserLocation;
import com.tcyclient.tellme.mongo.MongoDao;
import com.tcyclient.tellme.util.SystemUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TellMeClient tclient=new TellMeClient();
		//tclient.start();
		ApplicationContext context;
		context = new ClassPathXmlApplicationContext(new String[] {"tellmeservermvc.xml"});
		MongoDao mongdao=(MongoDao)context.getBean("mongDaoImpl");
		User user=new User();
		user.setName("name");
		UserLocation loc=new UserLocation();
		loc.setSendtime(new Date().getTime());
		Gps gps=new Gps();
		gps.setLat(11.111);
		loc.setGps(gps);
		user.setUserloction(loc);
		mongdao.save(user, User.CollectionName);

	}

}
