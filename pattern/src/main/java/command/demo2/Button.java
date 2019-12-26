package command.demo2;

/**
 * 假设我们正在开发一个办公软件，
 * 为了给用户更好的体验，
 * 打算为这个办公软件加一个人性化的设计，
 * 提供一组按钮，
 * 每个按钮提供三个功能给用户选择，
 * 用户选择其中一个功能与按钮绑定，
 * 绑定后用户只要点击按钮就能实现想要的功能。
 *
 * public class Button1 {
 *     private SkinPeelerHandler handler;
 *
 *     public void onClick() {
 *         handler = new SkinPeelerHandler();
 *         handler.skinPeeler();// 换肤
 *     }
 * }
 * 上面这段代码，Button1是invoker（请求发起者），SkinPeelerHandler是Receiver（请求接收者），它们是直接强耦合在一起的，如果想要将Button1同“放大”绑定起来，似乎只能更改Button1的源码了，这明显破坏了“开闭原则”，对用户来说，完全不具备可操作性，不灵活不实用。
 *
 * 也行有人会说，可以给“关闭”，“换肤”，“放大”功能设计一个公共抽象层，然后Button1可以通过与抽象层来打交道，这样就灵活了。是可以的，但如果是一组毫无关联的接受者呢？它们根本无法抽象出一个共同的抽象层来，这种情况怎么办呢？
 *
 */
public class Button {
    private Command command;

    public Button() {
    }

    public void call() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

