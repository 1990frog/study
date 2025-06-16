import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * <p>
 * 枚举代替常量
 * </p>
 *
 * @author cai
 * @since 2022/8/15
 */
@Slf4j
public class EnumInsteadOfConstant {

    static final int APPLE_FUJI = 0;
    static final int APPLE_PIPPIN = 1;
    static final int APPLE_GRANNY_SMITH = 2;

    enum APPLE {FUJI, PIPPIN, GRANNY_SMITH}

    @Test
    public void test1() {
        Integer score = APPLE_PIPPIN + APPLE_FUJI / APPLE_GRANNY_SMITH;
        log.info(score.toString());
    }

    @Test
    public void test2() {
        System.out.println(APPLE.values());
    }
}
