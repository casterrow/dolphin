package com.github.dolphin.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/9
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {



    //初始化一个无限阻塞队列,每次接受请求,都将信息放入队列里
    private final LinkedBlockingQueue<String> queue;


    public NettyClientHandler() {
        queue = new LinkedBlockingQueue<>();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String message) throws Exception {
        queue.add(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    //如果服务端不发送请求,会一直阻塞
    public String getMessage() {
        String message = null;
        try {
            message = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
