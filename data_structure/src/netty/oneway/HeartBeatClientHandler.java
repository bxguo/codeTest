package netty.oneway;

import cn.hutool.core.util.RandomUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.Date;
import java.util.Random;

/**
 * @author 郭炳侠
 * @date 2021/10/20
 */
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {
    private int lossConnectCount = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("客户端循环心跳监测发送: " + new Date());
        if (evt instanceof IdleStateEvent) {
            RandomUtil.randomInt(10);
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                Random random = new Random(System.currentTimeMillis());
                int millis = random.nextInt(20000);
                System.out.println("客户端处理时间" + millis / 1000);
                Thread.sleep(millis);
                ctx.writeAndFlush("biubiu");
            }
        }
    }
}
