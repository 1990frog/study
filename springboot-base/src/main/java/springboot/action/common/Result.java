package springboot.action.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

//    static enum status{SUCCESS,FAIL}

    private Object data;
    private String status;

    public Result(Object data){
        this.data = data;
//        status = com.action.common.Result.status.SUCCESS;
        this.status = "success";
    }

    public static Result builder(Object data){
        return new Result(data);
    }

    public static Result builder(Object data,String status){
        return new Result(data,status);
    }
}
