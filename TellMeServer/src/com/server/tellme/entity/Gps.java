package com.server.tellme.entity;

import java.io.Serializable;

public class Gps implements Serializable {

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
