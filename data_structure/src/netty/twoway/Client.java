package netty.twoway;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.Random;

/**
 * @author 郭炳侠
 * @date 2021/10/20
 */
public class Client {
    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup(4);
        Random random = new Random(System.currentTimeMillis());
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    .group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new IdleStateHandler(0, 0, 5));
                            p.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, -4, 0));
                            p.addLast(new ClientHandler());
                        }
                    });

            Channel ch = bootstrap.remoteAddress("127.0.0.1", 12345).connect().sync().channel();
            for (int i = 0; i < 10; i++) {
                String content = "client msg " + i;
                ByteBuf buf = ch.alloc().buffer();
                buf.writeInt(5 + content.getBytes().length);
                buf.writeByte(CustomHeartbeatHandler.CUSTOM_MSG);
                buf.writeBytes(content.getBytes());
                ch.writeAndFlush(buf);

                int millis = random.nextInt(20000);
                System.out.println("客户端处理时间" + millis / 1000);
                Thread.sleep(millis);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
