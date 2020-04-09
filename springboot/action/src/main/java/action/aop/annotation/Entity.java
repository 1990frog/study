package action.aop.annotation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entity {

    private String key;
    private String code;
    @Decode("value")
    private String value;
    private String valueStr;

}
