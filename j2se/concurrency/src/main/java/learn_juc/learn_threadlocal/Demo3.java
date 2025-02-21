package learn_juc.learn_threadlocal;


/**
 * <p>
 * 全局共享变量
 * </p>
 *
 * @author caijingquan
 * @since 5/31/24
 */
public class Demo3 {

    public static void main(String[] args) {
        new Service1().process("");
    }
}

class Service1 {

    public void process(String name) {
        UserInfo.User user = new UserInfo.User("lilei");
        UserInfo.holder.set(user);
        new Service2().process();
    }
}

class Service2 {

    public void process() {
        UserInfo.User user = UserInfo.holder.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
    }
}

class Service3 {

    public void process() {
        UserInfo.User user = UserInfo.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserInfo.holder.remove();
    }
}

class UserInfo {

    public static ThreadLocal<User> holder = new ThreadLocal<>();

    static class User {

        String name;

        public User(String name) {
            this.name = name;
        }
    }

}

