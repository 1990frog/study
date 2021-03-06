package javase.base.generic.extend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Father<T1, T2> {
    T1 t1;
    T2 t2;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Child<T1, T2, T3> extends Father<T1, T2> {
    private T3 t3;
}

@Slf4j
public class AllExtend {

    @Test
    public void test() {
        Father<Integer, String> father = new Father<>(1, "2");
        log.info("father = {}", father);
    }

}
