package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

/**
 * @author 郭炳侠
 * @date 2021/8/10
 */
public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty !", StandardCharsets.UTF_8);
        System.out.println((char)byteBuf.getByte(0));
        System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
        System.out.println(byteBuf.capacity());

        while (byteBuf.isReadable()) {
            System.out.println((char)byteBuf.readByte());
        }


    }
}
