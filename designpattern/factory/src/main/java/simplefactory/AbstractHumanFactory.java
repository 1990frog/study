package simplefactory;

public interface AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
