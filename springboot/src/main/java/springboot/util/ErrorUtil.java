package springboot.util;

import org.springframework.validation.BindingResult;

public class ErrorUtil {
    public static String processErrorString(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getFieldErrors().stream().forEach(n->stringBuilder.append(n.getDefaultMessage()+","));
        stringBuilder.substring(0,stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
