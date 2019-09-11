package builder.demo2;

/**
 * Director----指导者
 */
public class RobustDirector {

    private RobustBuilder robustBuilder;

    public RobustDirector(RobustBuilder robustBuilder){
        this.robustBuilder = robustBuilder;
    }

    public Robust buildRobust(String head, String body){
        robustBuilder.init();
        robustBuilder.buildHead(head);
        robustBuilder.buildBody(body);
        return robustBuilder.getRobust();
    }

}

