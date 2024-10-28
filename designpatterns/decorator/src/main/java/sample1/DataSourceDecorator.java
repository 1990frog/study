package sample1;

/**
 * 抽象基础装饰
 */
public abstract class DataSourceDecorator implements DataSource {
    private DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}