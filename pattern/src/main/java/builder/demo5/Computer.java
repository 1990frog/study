package builder.demo5;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;
}
