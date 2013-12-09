package com.server.tellme.server;

import java.io.Serializable;
import java.util.List;

import com.server.tellme.entity.MsgContent;
import com.server.tellme.entity.MsgGoal;
import com.server.tellme.entity.User;

public class TellMeMessageData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533616181382634730L;
	public User organziner;//msg creator
	public List<MsgContent> msgcontent;
	public List<MsgGoal> msggoal;
	public long showtime;
	public int regutype=0x0001;//定期类型
	public User getUser() {
		return organziner;
	}
	public void setUser(User organziner) {
		this.organziner = organziner;
	}
	public List<MsgContent> getMsgcontent() {
		return msgcontent;
	}
	public void setMsgcontent(List<MsgContent> msgcontent) {
		this.msgcontent = msgcontent;
	}
	public List<MsgGoal> getMsggoal() {
		return msggoal;
	}
	public void setMsggoal(List<MsgGoal> msggoal) {
		this.msggoal = msggoal;
	}
	public long getShowtime() {
		return showtime;
	}
	public void setShowtime(long showtime) {
		this.showtime = showtime;
	}
	public int getRegutype() {
		return regutype;
	}
	public void setRegutype(int regutype) {
		this.regutype = regutype;
	}
	public int getMouth() {
		return mouth;
	}
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinu() {
		return minu;
	}
	public void setMinu(int minu) {
		this.minu = minu;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int mouth;
	public int day;
	public int hour;
	public int minu;
	public int second;

}
