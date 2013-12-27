package com.tellme.weixin.entity;

import java.io.Serializable;

public class BaseWeixinMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1196994979801044190L;
	public String ToUserName;
	public String FromUserName;
	public String CreateTime;
	public String MsgType;
	public String MsgId;
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public String getTooUserName() {
		return ToUserName;
	}
	public void setTooUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
