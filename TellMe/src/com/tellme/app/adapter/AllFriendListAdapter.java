package com.tellme.app.adapter;

import java.util.HashMap;
import java.util.Map;

import com.tellme.entity.User;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AllFriendListAdapter extends BaseAdapter {

	public Map<String,User> usersmap=new HashMap<String, User>();
	public long curposition=0;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return usersmap.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return usersmap.values().toArray()[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return curposition=arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, User> getUsersmap() {
		return usersmap;
	}

	public void setUsersmap(Map<String, User> usersmap) {
		this.usersmap = usersmap;
	}

	public AllFriendListAdapter(Map<String,User> users) {
		// TODO Auto-generated constructor stub
		this.usersmap=users;
	}

}
