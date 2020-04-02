package pattern.decorator.demo1;

public class OtherDecorator extends Decorator {
    /**
     * 构造函数
     *
     * @param resume
     */
    public OtherDecorator(Resume resume) {
        super(resume);
    }

    @Override
    public void selfIntroduce() {
        super.selfIntroduce();
        //添加其他信息，比如github、个人博客
        addOther();
    }

    public void addOther() {
        System.out.println("博客：https://jianshu");
        System.out.println("github：https://github");
    }
}

