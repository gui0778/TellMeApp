package com.tcyclient.tellme;

import java.net.SocketAddress;

import org.apache.log4j.Logger;

import com.tellme.common.entity.TellMeMessageData;
import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.entity.User;



import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class TellMeTimeOutHandler extends ChannelDuplexHandler{
	private long startTime = -1;
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
        if (startTime < 0) {
            startTime = System.currentTimeMillis();
        }
        println("Connected to: " + ctx.channel().remoteAddress());
        TellMeMsg mg=new TellMeMsg();
        TellMeMessageData msg=new TellMeMessageData();
        msg.setOrganziner(new User("tancyu"));
        mg.setCmd(TellMeMsg.CMD_LOGIN);
        mg.setTellmedata(msg);
        ctx.writeAndFlush(mg);
	}

	private static final Logger logger = Logger.getLogger(TellMeTimeOutHandler.class);
	@Override
	public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
			SocketAddress localAddress, ChannelPromise future) throws Exception {
		// TODO Auto-generated method stub
		super.connect(ctx, remoteAddress, localAddress, future);
	}

	@Override
	public void disconnect(ChannelHandlerContext ctx, ChannelPromise future)
			throws Exception {
		// TODO Auto-generated method stub
		super.disconnect(ctx, future);
	}

	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise future)
			throws Exception {
		// TODO Auto-generated method stub
		super.close(ctx, future);
	}

	@Override
	public void read(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.read(ctx);
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg,
			ChannelPromise promise) throws Exception {
		// TODO Auto-generated method stub
		super.write(ctx, msg, promise);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		//super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
            	logger.info("read timeout");
                ctx.close();
            } else if (e.state() == IdleState.WRITER_IDLE) {
                //ctx.writeAndFlush(new PingMessage());
            	logger.info("write timeout");
            }
        }
	}
    void println(String msg) {
        if (startTime < 0) {
            System.err.format("[SERVER IS DOWN] %s%n", msg);
        } else {
            System.err.format("[UPTIME: %5ds] %s%n", (System.currentTimeMillis() - startTime) / 1000, msg);
        }
    }


}
