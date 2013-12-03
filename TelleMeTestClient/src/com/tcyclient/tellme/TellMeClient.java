package com.tcyclient.tellme;

import org.apache.log4j.Logger;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

public class TellMeClient {
	public String host="localhost";
	public int port=9407;
	private int num=0;
	public int timeout;
	public static int MAXLEN=0xffff;
	public Channel ctx;
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
	private static final Logger logger = Logger.getLogger(TellMeClient.class);
	protected static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors()*2;	//默认
	/** 业务出现线程大小*/
	protected static final int BIZTHREADSIZE = 4;
	final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
	final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);
	public void start()
	{
		EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup);
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TellMeMsgHandler());
                }
            });
            
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)

            // Wait until the connection is closed.
            ctx=f.channel();
            //f.channel().closeFuture().sync();
        }catch(InterruptedException e) 
        {
        	logger.info("connect error");
        }
        finally {
           // workerGroup.shutdownGracefully();
        }
		logger.info("tellmeserver start succ ip:"+host+"|port:"+port);
		new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub	
				while(true)
				{

					try {
						Thread.sleep(5000);
						if(num<3)
						{
							ByteBuf buf=Unpooled.buffer();
							long time=System.currentTimeMillis();
							String tstr=String.valueOf(time);
							buf.writeBytes(tstr.getBytes());
							ctx.writeAndFlush(buf).sync();
						}
						num++;
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
				
			}
			
		}).start();
	}
	public Channel getCtx() {
		return ctx;
	}
	public void setCtx(Channel ctx) {
		this.ctx = ctx;
	}
	public TellMeClient()
	{
		
	}
	public TellMeClient(String host,int port,int timeout)
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
