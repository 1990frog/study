package action.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessError {
    private int errCode;
    private String errMsg;

    public BusinessError(BusinessErrorEnum businessErrorEnum){
        this.errCode = businessErrorEnum.getErrCode();
        this.errMsg = businessErrorEnum.getErrMsg();
    }
}
