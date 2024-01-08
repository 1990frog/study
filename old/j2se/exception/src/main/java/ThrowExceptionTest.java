/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/3/25
 */
public class ThrowExceptionTest {

    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("test");
        } finally {
            System.out.println("finally");
        }
    }
}
