import org.junit.Assert;

public class AssertTest {

    public static void main(String[] args) {
        try{
            Object obj = null;
            Assert.assertNull(obj);
            System.out.println("断言通过");
            obj = new Object();
            Assert.assertNull(obj);
            System.out.println("断言通过");
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
