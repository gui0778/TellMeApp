package com.tellme.weixin.service;

import java.io.InputStream;

import com.tellme.weixin.entity.BaseWeixinMsg;

public interface WeixinRecv {
	public void tranhandle(BaseWeixinMsg basewx);

}
