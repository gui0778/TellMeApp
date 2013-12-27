package com.tcy.weixin;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tellme.common.util.WeiXinUtil;
/***
 * weixin entrance
 * @author cydev
 *
 */
@RequestMapping("/tweixin")
public class WeixinEntrance {
	public WeiXinUtil getWxutil() {
		return wxutil;
	}
	public void setWxutil(WeiXinUtil wxutil) {
		this.wxutil = wxutil;
	}
	@Autowired
	public WeiXinUtil wxutil; 
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody  String CheckTokenValid(HttpServletRequest request) {
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		if(wxutil.validtoken(signature, timestamp, nonce))
		{
			return echostr;
		}
		return null;
		
	}
	//recevice message from user
	public void RecvMsgPost(HttpServletRequest request,HttpServletResponse response)
	{
		
	}

}
