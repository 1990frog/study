package builder.demo2;

/**
 * Product----相当于建造者模式中的产品
 */
public class Robust {

    private String head;

    private String body;

    public String getHead() {

        return head;

    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Robust{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}

