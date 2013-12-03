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
	public User user;
	public List<MsgContent> msgcontent;
	public List<MsgGoal> msggoal;

}
