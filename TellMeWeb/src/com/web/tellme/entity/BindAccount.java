package com.web.tellme.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BindAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6537977525038180822L;
	public static enum THREEPARTYNAME{QQ,SINA,WEIXIN,MOBILPHONE}
	public String id;
	public THREEPARTYNAME partyname;
	public long bindtime;
	public boolean isvalid;
	public String bindname;
	public Map<String,Object> threepartyinfo=new HashMap<String,Object>();
	public User user;

}
