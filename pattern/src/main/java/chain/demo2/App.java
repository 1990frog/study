package chain.demo2;

public class App {
    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("课程");
        course.setArticle("手记");
        course.setVideo("视频");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
