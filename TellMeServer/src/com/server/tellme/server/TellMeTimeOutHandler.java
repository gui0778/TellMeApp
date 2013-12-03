package com.server.tellme.server;

import java.net.SocketAddress;

import org.apache.log4j.Logger;



import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class TellMeTimeOutHandler extends ChannelDuplexHandler{
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


}
