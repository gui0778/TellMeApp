package com.web.tellme.entity;

import java.io.Serializable;

public class MsgContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7762566254385589276L;
	public enum msgtype{text,image,file,zipfile}
	public msgtype msgty;
	public String filename;
	public String serverfileid;
	public String desci;
	public String msgbody;

}
