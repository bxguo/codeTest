package netty.oneway;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author 郭炳侠
 * @date 2021/10/20
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {
    private int lossConnectCount = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent stateEvent = (IdleStateEvent) evt;
            if (stateEvent.state() == IdleState.READER_IDLE) {
                lossConnectCount++;
                if (lossConnectCount > 2) {
                    String host = ctx.channel().remoteAddress().toString();
                    System.out.println("关闭这个不活跃通道！" + host);
                    ctx.channel().close();
                }
            } else {
                super.userEventTriggered(ctx, evt);
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        lossConnectCount = 0;
        System.out.println("client says: " + msg.toString());
    }
}
