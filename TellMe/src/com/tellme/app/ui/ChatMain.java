package com.tellme.app.ui;

import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.tellme.app.AppContext;
import com.tellme.app.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class ChatMain extends Activity{

	private MapView mMapView;
	private MapController mMapController;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	      setContentView(R.layout.chatmain);
	      mMapView=(MapView)findViewById(R.id.chatmap);
	      initMapView();
	}
	public void initMapView()
	{
		mMapView.setBuiltInZoomControls(true);
		//设置启用内置的缩放控件
		mMapController=mMapView.getController();
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));
		//用给定的经纬度构造一个GeoPoint，单位是微度 (度 * 1E6)
		mMapController.setCenter(point);//设置地图中心点
		mMapController.setZoom(12);//设置地图zoom级别
	}
	public AppContext getApp()
	{
		return (AppContext)getApplication();
	}
	@Override
	protected void onDestroy(){
	        mMapView.destroy();
	        if(getApp().getmBMapMan()!=null){
	        	getApp().getmBMapMan().destroy();
	        }
	        super.onDestroy();
	}
	@Override
	protected void onPause(){
	        mMapView.onPause();
	        if(getApp().getmBMapMan()!=null){
	        	getApp().getmBMapMan().stop();
	        }
	        super.onPause();
	}
	@Override
	protected void onResume(){
	        mMapView.onResume();
	        if(getApp().getmBMapMan()!=null){
	        	getApp().getmBMapMan().start();
	        }
        super.onResume();
	}

	

}
