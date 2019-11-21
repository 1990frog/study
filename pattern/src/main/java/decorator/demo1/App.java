package decorator.demo1;

public class App {

    public static void main(String[] args) {
        Resume resume = new MyResume();
        /**
         * 1.添加工作经历
         * 2.添加github、博客
         */
        resume = new OtherDecorator(new WorkExperienceDecorator(resume));
        resume.selfIntroduce();

    }

}
