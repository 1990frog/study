package action.mvc.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel("swagger response")
public class SwaggerResponse {
    @ApiModelProperty("swagger 用户id")
    private String code;
    @ApiModelProperty("swagger 用户名")
    private String name;
}
