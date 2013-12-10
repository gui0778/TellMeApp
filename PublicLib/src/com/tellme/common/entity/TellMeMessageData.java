package com.tellme.common.entity;

import java.io.Serializable;
import java.util.List;

import com.tellme.common.entity.MsgContent;
import com.tellme.common.entity.MsgGoal;
import com.tellme.common.entity.User;


public class TellMeMessageData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533616181382634730L;
	public String id;
	public User organziner;//msg creator
	public List<MsgContent> msgcontent;
	public List<MsgGoal> msggoal;
	public long showtime;
	public long sendtime;
	public int showmouth;
	public int showday;
	public int showhour;
	public int showminu;
	public int showsecond;
	public int regutype=0x0001;//定期类型
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getOrganziner() {
		return organziner;
	}
	public void setOrganziner(User organziner) {
		this.organziner = organziner;
	}
	public long getSendtime() {
		return sendtime;
	}
	public void setSendtime(long sendtime) {
		this.sendtime = sendtime;
	}
	public int getShowmouth() {
		return showmouth;
	}
	public void setShowmouth(int showmouth) {
		this.showmouth = showmouth;
	}
	public int getShowday() {
		return showday;
	}
	public void setShowday(int showday) {
		this.showday = showday;
	}
	public int getShowhour() {
		return showhour;
	}
	public void setShowhour(int showhour) {
		this.showhour = showhour;
	}
	public int getShowminu() {
		return showminu;
	}
	public void setShowminu(int showminu) {
		this.showminu = showminu;
	}
	public int getShowsecond() {
		return showsecond;
	}
	public void setShowsecond(int showsecond) {
		this.showsecond = showsecond;
	}


}
