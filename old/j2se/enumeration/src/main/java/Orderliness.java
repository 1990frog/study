import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 枚举具有有序性：ordinal() 返回具体排序
 * </p>
 *
 * @author cai
 * @since 2022/8/24
 */
public class Orderliness {

    enum number1{
        ZERO,ONE,TWE,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN
    }

    @Getter
    @AllArgsConstructor
    enum number2{
        ZERO(0),ONE(1),TWE(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10);
        private final int sort;
    }

    public static void main(String[] args) {
        System.out.println(number1.SIX.ordinal());
        System.out.println(number2.ZERO.getSort());
    }

}
