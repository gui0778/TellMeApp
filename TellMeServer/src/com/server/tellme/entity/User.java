package com.server.tellme.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1996729894538778495L;
	private static int maxCollection=1000;
	public static String CollectionName="user";
	public String id;
	public String name;
	public String passwd;
	public String email;
	public long registertime=new Date().getTime();
	@DBRef
	public UserLocation userloction;
	public Map<String,Object> setinfo=new HashMap<String,Object>();;
	public List<UserService> userservice=new LinkedList<UserService>();//open which service
	public List<BindAccount> userbind=new LinkedList<BindAccount>();
	public Map<String,Object> linehandler=new HashMap<String,Object>();
	public Map<String,Object> friendset=new HashMap<String,Object>();//other one use 
	public String def_prefix="";
	public static int getMaxCollection() {
		return maxCollection;
	}
	public static void setMaxCollection(int maxCollection) {
		User.maxCollection = maxCollection;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<BindAccount> getUserbind() {
		return userbind;
	}
	public void setUserbind(List<BindAccount> userbind) {
		this.userbind = userbind;
	}
	public Map<String, Object> getLinehandler() {
		return linehandler;
	}
	public void setLinehandler(Map<String, Object> linehandler) {
		this.linehandler = linehandler;
	}
	public Map<String, Object> getFriendset() {
		return friendset;
	}
	public void setFriendset(Map<String, Object> friendset) {
		this.friendset = friendset;
	}
	public String getDef_prefix() {
		return getUserPrefix(name);
	}
	public void setDef_prefix(String def_prefix) {
		this.def_prefix = def_prefix;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getRegistertime() {
		return registertime;
	}
	public void setRegistertime(long registertime) {
		this.registertime = registertime;
	}
	public UserLocation getUserloction() {
		return userloction;
	}
	public void setUserloction(UserLocation userloction) {
		this.userloction = userloction;
	}
	public Map<String, Object> getSetinfo() {
		return setinfo;
	}
	public void setSetinfo(Map<String, Object> setinfo) {
		this.setinfo = setinfo;
	}
	public List<UserService> getUserservice() {
		return userservice;
	}
	public void setUserservice(List<UserService> userservice) {
		this.userservice = userservice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getUserPrefix(String name)
	{
		int hash = Math.abs(name.hashCode()) % maxCollection;
		return String.valueOf(hash);
		
	}


}
