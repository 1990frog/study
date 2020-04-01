package javase.base.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class CopyEntity implements Serializable {
    private static final long serialVersionUID = -1593212361687445369L;
    private String value;
    private CopyEntity next;
    public CopyEntity(){
    }
}
