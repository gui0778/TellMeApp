package com.web.tellme.entity;

import java.io.Serializable;

public class Gps implements Serializable {

	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public boolean isIsvalid() {
		return isvalid;
	}
	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}
	public double getAcc() {
		return acc;
	}
	public void setAcc(double acc) {
		this.acc = acc;
	}
	public double getEleva() {
		return eleva;
	}
	public void setEleva(double eleva) {
		this.eleva = eleva;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 2602849680933441299L;
	public double lat;
	public double lng;
	public boolean isvalid=false;
	public double acc;
	public double eleva;

}
