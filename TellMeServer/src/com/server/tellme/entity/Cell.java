package com.server.tellme.entity;

import java.io.Serializable;

public class Cell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2739042268798181283L;
	public int mcc;
	public int mnc;
	public int cid;
	public int lac;
	public double acc;
	public boolean isvalid=false;

}
