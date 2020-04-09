package action.mvc.domain.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestParam {

    @NotBlank(message = "code不能为null")
    private String code;
    @NotBlank(message = "name不能为null")
    private String name;

}
