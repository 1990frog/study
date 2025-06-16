package old.decorator.demo1;

public abstract class Decorator implements Resume{
    /**
     * 接口
     */
    private Resume resume;

    /**
     * 构造函数
     */
    public Decorator(Resume resume) {
        this.resume = resume;
    }

    @Override
    public void selfIntroduce() {
        //调用传入Resume实现类的方法
        resume.selfIntroduce();
    }
}
