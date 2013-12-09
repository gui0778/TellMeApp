package com.tellme.publiclib.entity;

import java.io.Serializable;

public class MsgGoal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7408201027751802221L;
	public String goaltype;
	public String goalname;
	public String getGoaltype() {
		return goaltype;
	}
	public void setGoaltype(String goaltype) {
		this.goaltype = goaltype;
	}
	public String getGoalname() {
		return goalname;
	}
	public void setGoalname(String goalname) {
		this.goalname = goalname;
	} 

}
