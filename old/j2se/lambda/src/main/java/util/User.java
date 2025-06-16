package util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author cai
 * @since 2023/2/15
 */
@Data
@Builder
@AllArgsConstructor
public class User {
    private int gender;
    private int age;
    private String name;

    public static List<User> getData(){
        return new ArrayList<User>() {{
            add(User.builder().name("jim").age(12).gender(0).build());
            add(User.builder().name("lucy").age(12).gender(1).build());
            add(User.builder().name("tom").age(13).gender(0).build());
        }};
    }
}
