package com.tellme.app.adapter;

import java.util.HashMap;
import java.util.Map;

import com.tellme.app.R;
import com.tellme.app.adapter.ListViewNewsAdapter.ListItemView;
import com.tellme.entity.User;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class AllFriendListAdapter extends BaseAdapter {

	public Map<String,User> usersmap=new HashMap<String, User>();
	public long curposition=0;
	private LayoutInflater 				listContainer;//视图容器
	private Context context;
	public static class FriendListItem{
		private ImageView faceimg;
		private TextView onlinety;
		
	}
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
	public View getView(int arg0, View contentview, ViewGroup arg2) {
		// TODO Auto-generated method stub
		FriendListItem  listItemView = null;
		if(contentview==null)
		{
			contentview=listContainer.inflate(R.layout.friend_listitem, null);
			listItemView=new FriendListItem();
			listItemView.faceimg=(ImageView)contentview.findViewById(R.id.friend_listitem_userface);
			contentview.setTag(listItemView);
		}else
		{
			listItemView=(FriendListItem)contentview.getTag();
		}
		Drawable db=context.getResources().getDrawable(R.drawable._back);
		listItemView.faceimg.setBackground(db);
		return contentview;
	}
	public Map<String, User> getUsersmap() {
		return usersmap;
	}

	public void setUsersmap(Map<String, User> usersmap) {
		this.usersmap = usersmap;
	}

	public AllFriendListAdapter(Map<String,User> users,Context context) {
		// TODO Auto-generated constructor stub
		this.usersmap=users;
		this.context=context;
		this.listContainer = LayoutInflater.from(context);	//创建视图容器并设置上下文
	}

}
