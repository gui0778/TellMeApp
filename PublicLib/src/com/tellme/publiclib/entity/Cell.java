package com.tellme.publiclib.entity;

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
	public int getMcc() {
		return mcc;
	}
	public void setMcc(int mcc) {
		this.mcc = mcc;
	}
	public int getMnc() {
		return mnc;
	}
	public void setMnc(int mnc) {
		this.mnc = mnc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getLac() {
		return lac;
	}
	public void setLac(int lac) {
		this.lac = lac;
	}
	public double getAcc() {
		return acc;
	}
	public void setAcc(double acc) {
		this.acc = acc;
	}
	public boolean isIsvalid() {
		return isvalid;
	}
	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

}
