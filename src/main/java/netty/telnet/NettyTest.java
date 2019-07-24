package netty.telnet;

import org.junit.Test;

/**
 * The type Netty test.
 */
public class NettyTest {

    /**
     * Test.
     */
    @Test
    public void test() {
        NettyTelnetServer nettyTelnetServer = new NettyTelnetServer();
        try {
            nettyTelnetServer.open();
        } catch (InterruptedException e) {
            nettyTelnetServer.close();
        }
    }
}
