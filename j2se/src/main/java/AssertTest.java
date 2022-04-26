import org.junit.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AssertTest {

    public static void main(String[] args) {
//        try{
//            Object obj = null;
//            Assert.assertNull(obj);
//            System.out.println("断言通过");
//            obj = new Object();
//            Assert.assertNull(obj);
//            System.out.println("断言通过");
//        }catch (Exception e){
//            System.out.println("error");
//        }

        LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(1);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(startTime);
        System.out.println(endTime);
    }
}
