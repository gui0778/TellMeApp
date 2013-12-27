package com.tellme.weixin.entity;

import java.io.Serializable;

public class WexinTextMsg extends BaseWeixinMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2569325567304830338L;
	public String Content;
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
