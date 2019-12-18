package builder.demo4;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tire {
    public Tire(){}
    public Tire(String tire){this.setTire(tire);}
    private String tire;
}
