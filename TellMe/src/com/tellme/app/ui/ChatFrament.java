package com.tellme.app.ui;

import com.baidu.mapapi.map.MapView;
import com.tellme.app.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChatFrament extends Fragment {
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
    	Context cotenxt=this.getActivity().getApplication().getApplicationContext();
    	MapView map=new MapView(cotenxt);
        return inflater.inflate(R.layout.chatfragment, container, false);  
    }  

}
