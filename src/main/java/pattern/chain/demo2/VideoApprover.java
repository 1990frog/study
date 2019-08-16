package pattern.chain.demo2;

import org.apache.commons.lang3.StringUtils;

public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if(!StringUtils.isEmpty(course.getArticle())){
             System.out.println(course.getVideo()+"含有视频，批准");
             if(approver != null){
                 approver.deploy(course);
             }
        }else {
            System.out.println(course.getName()+"不含有视频，不批准，流程结束");
            return;
        }
    }
}
