package springboot.action.mvc.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("swagger param")
public class SwaggerParam {
    @ApiModelProperty("swagger 用户id")
    private String code;
    @ApiModelProperty("swagger 用户名")
    private String name;
}
