package com.tellme.weixin.entity;

import java.io.Serializable;

public class WeixinEventMsg extends BaseWeixinMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2569325567304830338L;
	public String Event;
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}

}
