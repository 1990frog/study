package chain.demo2;

public class ArticleApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if(course.getArticle()!=null && !"".equals(course.getArticle())){
             System.out.println(course.getArticle()+"含有手记，批准");
             if(approver != null){
                 approver.deploy(course);
             }
        }else {
            System.out.println(course.getName()+"不含有手记，不批准，流程结束");
            return;
        }
    }
}
