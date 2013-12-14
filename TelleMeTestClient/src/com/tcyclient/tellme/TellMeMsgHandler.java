package com.tcyclient.tellme;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.tellme.common.entity.TellMeMsg;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

public class TellMeMsgHandler extends SimpleChannelInboundHandler<TellMeMsg> {
	private static final Logger logger = Logger.getLogger(TellMeMsgHandler.class);
	private  static final HashedWheelTimer reconnTimer = new HashedWheelTimer();
	public TellMeClient client;
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
        TellMeMsg mg=new TellMeMsg();
        mg.setCmd(TellMeMsg.CMD_LOGIN);
        ctx.writeAndFlush(mg);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
		logger.info(" close--"+ctx.name());
		logger.warn("Sleeping for: " + TellMeClient.RECONNECT_DELAY + "s");
		  reconnTimer.newTimeout(new TimerTask() {
	            public void run(Timeout timeout) throws Exception {
	            	logger.info("Reconnecting to: " + client.getHost());
	                client.connect();;
	            }
	        }, TellMeClient.RECONNECT_DELAY, TimeUnit.SECONDS);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelReadComplete(ctx);
		final ChannelHandlerContext cx=ctx;
        final Timer timer = new HashedWheelTimer();
          timer.newTimeout(new TimerTask() {
              public void run(Timeout timeout) throws Exception {
            	  logger.info("heart");
            	  sendHeart(cx);
              }
          }, client.getHeartdely(), TimeUnit.SECONDS);
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
		super.exceptionCaught(ctx, cause);
		logger.info("exception"+ctx.name());
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
	protected void channelRead0(ChannelHandlerContext arg0, TellMeMsg arg1)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("TellMeMsg --"+arg1);		
	}
	public static void sendHeart(ChannelHandlerContext ctx) {
		TellMeMsg msg=new TellMeMsg(TellMeMsg.CMD_HEART);
		ctx.writeAndFlush(msg);
		
	}
	public TellMeMsgHandler(TellMeClient client)
	{
		this.client=client;
	}

}
