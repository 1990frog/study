package simplefactory;

public class HumanFactory implements AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建失败");
        }
        return (T) human;
    }
}
