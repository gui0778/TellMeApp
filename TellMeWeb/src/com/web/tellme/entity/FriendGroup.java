package com.web.tellme.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FriendGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8307106822414358396L;
	public String id;
	public String name;
	public User user;
	public Map<String,Object> groupsetinfo=new HashMap<String,Object>();
	public List<User> friendlist=new LinkedList<User>();
	public FriendGroup parentgroup;
	public List<User> parentgplist=new LinkedList<User>(); 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, Object> getGroupsetinfo() {
		return groupsetinfo;
	}
	public void setGroupsetinfo(Map<String, Object> groupsetinfo) {
		this.groupsetinfo = groupsetinfo;
	}
	public List<User> getFriendlist() {
		return friendlist;
	}
	public void setFriendlist(List<User> friendlist) {
		this.friendlist = friendlist;
	}
	public FriendGroup getParentgroup() {
		return parentgroup;
	}
	public void setParentgroup(FriendGroup parentgroup) {
		this.parentgroup = parentgroup;
	}
	public List<User> getParentgplist() {
		return parentgplist;
	}
	public void setParentgplist(List<User> parentgplist) {
		this.parentgplist = parentgplist;
	}


}
