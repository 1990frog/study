package pattern.proxy.dynamicproxy.demo1;

class RealObject implements DoSomething {

    @Override
    public void doSomething() {
        System.out.println("realObject doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("realObject doSomethingElse " + arg);
    }

}