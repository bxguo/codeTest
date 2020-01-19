package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;

import java.nio.charset.StandardCharsets;

/**
 * @author: bxguo
 * @time: 2020/1/16 10:37
 */
public class HttpServer {

    public void openServer(){
        //netty 启动器
        ServerBootstrap bootstrap = new ServerBootstrap();

        //制定boss线程池和work线程池
        bootstrap.channel(NioServerSocketChannel.class);
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(8);
        bootstrap.group(boss, work);

        //handler, 编码和解码 以及各种业务处理
        bootstrap.childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast("http-decode", new HttpRequestDecoder());
                channel.pipeline().addLast("http-encode", new HttpResponseEncoder());
                channel.pipeline().addLast("http-server-handler", new HttpServerHandler());
            }
        });

        try {
            ChannelFuture future = bootstrap.bind(8080).sync();
            System.out.println("8080 启动了----------");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
    public class HttpServerHandler extends SimpleChannelInboundHandler{

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
            //请求行
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

            //请求头
            response.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json; charset=utf-8");

            //请求体
            response.content().writeBytes("hello 啊".getBytes(StandardCharsets.UTF_8));
            ChannelFuture channelFuture = ctx.writeAndFlush(response);
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.openServer();
    }
}
