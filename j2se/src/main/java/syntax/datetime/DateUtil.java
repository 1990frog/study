package syntax.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/2/24
 */
public class DateUtil {

    public static List<LocalDate> getMonths(LocalDate start, LocalDate end) {
        List<LocalDate> ret = new ArrayList<>();
        if (!Optional.ofNullable(end).isPresent()) {
            end = start;
        }
        int months = Period.between(start, end).getMonths();
        for (int i = 0; i <= months; i++) {
            ret.add(LocalDate.of(start.getYear(), start.getMonth().plus(i), 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2022, 1, 1);
        LocalDate end = LocalDate.of(2022, 12, 1);
        System.out.println(getMonths(start, end));
    }
}
