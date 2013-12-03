package com.server.tellme.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

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
	public String getBindphone() {
		return bindphone;
	}
	public void setBindphone(String bindphone) {
		this.bindphone = bindphone;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1996729894538778495L;
	public String name;
	public String passwd;
	public String email;
	public String bindphone;
	public long registertime;
	public UserLocation userloction;
	public Map<String,Object> setinfo;
	public List<UserService> userservice;

}
