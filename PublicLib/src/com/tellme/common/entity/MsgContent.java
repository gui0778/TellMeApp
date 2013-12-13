package com.tellme.common.entity;

import java.io.Serializable;

public class MsgContent implements Serializable {

	public msgtype getMsgty() {
		return msgty;
	}
	public void setMsgty(msgtype msgty) {
		this.msgty = msgty;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getServerfileid() {
		return serverfileid;
	}
	public void setServerfileid(String serverfileid) {
		this.serverfileid = serverfileid;
	}
	public String getDesci() {
		return desci;
	}
	public void setDesci(String desci) {
		this.desci = desci;
	}
	public String getMsgbody() {
		return msgbody;
	}
	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}
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
