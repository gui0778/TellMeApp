package com.tellme.weixin.entity;

import java.io.Serializable;

public class WexinPicMsg extends BaseWeixinMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2569325567304830338L;
	public String Location_X;
	public String Location_Y;
	public String Scale;
	public String Label;
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}

}
