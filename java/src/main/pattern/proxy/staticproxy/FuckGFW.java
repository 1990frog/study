package pattern.proxy.staticproxy;

import org.junit.Test;

public class FuckGFW {

    interface Internet {
        void access();
    }

    class ChinaInternet implements Internet{
        @Override
        public void access() {
            System.out.println("Youtube 404");
        }
    }

    class Shadowsocks implements Internet{

        private Internet internet;

        public Shadowsocks(Internet internet){
            this.internet=internet;
        }

        @Override
        public void access() {
            internet.access();
            System.out.println("use ss");
            System.out.println("fuck gfw");
            System.out.println("Youtube 200");
        }
    }

    @Test
    public void test(){
        new Shadowsocks(new ChinaInternet()).access();
    }

}
