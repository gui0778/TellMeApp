package com.server.tellme.server;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tellme.common.entity.TellMeMessageData;
import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.entity.User;
import com.tellme.common.service.UserService;
import com.tellme.common.util.SpringContext;
import com.tellme.common.util.StringUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TellMeMsgHandler extends SimpleChannelInboundHandler<TellMeMsg> {
	private static final Logger logger = Logger.getLogger(TellMeMsgHandler.class);
	@Autowired
	public SpringContext springappcontext;
	UserService userService=(UserService)springappcontext.getBean("userService");
	public User user;
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
		logger.info("client connect--"+ctx.name());
		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
		logger.info("client close--");
		if(user!=null)
		{
		 logger.error("client close--"+user.getName());
		 
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelUnregistered(ctx);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		logger.error("client error,had close");
		logger.info("client exception"+ctx.name());
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.handlerAdded(ctx);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.handlerRemoved(ctx);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext chx, TellMeMsg msg)
			throws Exception {
		// TODO Auto-generated method stub
		if(msg==null)
		{
			logger.info("msg is null");
			return;
		}
		logger.info("TellMeMsg --"+msg.toString());
		int cmd=msg.getCmd();
		switch(cmd)
		{
			case TellMeMsg.CMD_LOGIN:
				userLogin(chx,msg);
				break;
			default:
				logger.info("no case"+msg.toString());
				break;
		
		}
	}
	private void userLogin(ChannelHandlerContext chx, TellMeMsg msg)
	{
		logger.info("user login"+msg.toString());
		User user=msg.getTellmedata().getOrganziner();
		if(user==null)
		{
			return;			
		}
		user.getLinehandler().put("chl", chx);
		userService.setUserOnline(user);
		User olduser=userService.getUserOnline(user);
		ChannelHandlerContext oldchx=(ChannelHandlerContext)olduser.getLinehandler().get("oldchl");
		if(oldchx!=null)
		{
			logger.info("user had login"+user.getName());

			TellMeMsg tellmemsg=new TellMeMsg(TellMeMsg.CMD_OFFLINE, TellMeMsg.RESCMD_REPEAT_LOGIN);
			oldchx.writeAndFlush(tellmemsg);
		}
		ChannelHandlerContext newchx=(ChannelHandlerContext)olduser.getLinehandler().get("chl");
		TellMeMsg tellmemsg=new TellMeMsg(TellMeMsg.CMD_OFFLINE, TellMeMsg.RESCMD_LOGIN_NORMAL);
		newchx.writeAndFlush(tellmemsg);
		

	}

}
