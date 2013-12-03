package com.server.tellme.server;

import org.apache.log4j.Logger;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ChannelFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class TellMeServer {
	public String host;
	public int port;
	public int timeout;
	public static int MAXLEN=10;
	public int maxthread=100;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	private static final Logger logger = Logger.getLogger(TellMeServer.class);
	protected static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors()*2;	//默认
	/** 业务出现线程大小*/
	protected static final int BIZTHREADSIZE = 4;
	final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
	final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);
	EventExecutorGroup eventgroup=new DefaultEventExecutorGroup(maxthread);
	public void start()
	{

		ServerBootstrap serverbootstrap=new ServerBootstrap();
		serverbootstrap.group(bossGroup, workerGroup);
		serverbootstrap.channel(NioServerSocketChannel.class);
		serverbootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			public void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pipeline = ch.pipeline();
				//pipeline.addLast("frame",new LengthFieldBasedFrameDecoder(MAXLEN, 0, 2));
				//pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
				pipeline.addLast("decoder", new TellMeDecoderHandler());
				pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
			    pipeline.addLast("idleStateHandler",
						new IdleStateHandler(getTimeout(), 0, 0));
			    pipeline.addLast("tiemoutHandler",new TellMeTimeOutHandler());
				pipeline.addLast(eventgroup,"clienthandler",new TellMeMsgHandler());
			}
		});

		try {
			serverbootstrap.bind(host, port).sync().channel();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//serverbootstrap.group().shutdownGracefully();
		}
		logger.info("tellmeserver start succ ip:"+host+"|port:"+port);
	}
	public TellMeServer()
	{
		
	}
	public TellMeServer(String host,int port,int timeout)
	{
		this.host = host;
		this.port=port;
		this.timeout=timeout;
		
	}
	public void cleanserver()
	{
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		
	}

}
