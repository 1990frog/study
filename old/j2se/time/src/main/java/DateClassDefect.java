import java.util.Date;

final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}

/**
 * <p>
 * 保护性拷贝
 * </p>
 *
 * @author cai
 * @since 2022/8/30
 */
final class DefensiveCopyPeriod {
    private final Date start;
    private final Date end;

    public DefensiveCopyPeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException();
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}

public class DateClassDefect {

//    final class Period {
//        private final Date start;
//        private final Date end;
//
//        public Period(Date start, Date end) {
//            if (start.compareTo(end) > 0)
//                throw new IllegalArgumentException();
//            this.start = start;
//            this.end = end;
//        }
//
//        public Date start() {
//            return start;
//        }
//
//        public Date end() {
//            return end;
//        }
//    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        System.out.println(period.end());
//        end = new Date();
//        System.out.println(period.end());
        // date 本身是可变的
        end.setYear(1990);
        System.out.println(period.end());
    }
}
