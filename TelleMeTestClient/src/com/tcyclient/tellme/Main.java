package com.tcyclient.tellme;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcyclient.tellme.util.SystemUtil;
import com.tellme.common.dao.MongoDao;
import com.tellme.common.entity.Gps;
import com.tellme.common.entity.User;
import com.tellme.common.entity.UserLocation;

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
