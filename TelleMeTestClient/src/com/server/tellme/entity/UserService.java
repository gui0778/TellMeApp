package com.server.tellme.entity;

import java.io.Serializable;

public class UserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4715978699999028549L;
	public String id;
	public String name;
	public String desc;
	public long ontime;
	public long endtime;
	public int onmouth;
	public double unitprice;
	public boolean isvalid=false;
	public double nowunitprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getOntime() {
		return ontime;
	}
	public void setOntime(long ontime) {
		this.ontime = ontime;
	}
	public long getEndtime() {
		return endtime;
	}
	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOnmouth() {
		return onmouth;
	}
	public void setOnmouth(int onmouth) {
		this.onmouth = onmouth;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public double getNowunitprice() {
		return nowunitprice;
	}
	public void setNowunitprice(double nowunitprice) {
		this.nowunitprice = nowunitprice;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean valid=false;

}
