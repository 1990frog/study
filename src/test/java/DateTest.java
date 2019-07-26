import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {


    public static String dateFormat(Date date) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(date);
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(dateFormat(date));
    }
}
