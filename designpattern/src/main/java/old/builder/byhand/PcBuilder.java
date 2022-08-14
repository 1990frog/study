package old.builder.byhand;

import lombok.Builder;

class Cpu{}
class Memory{}
class Ssd{}
class Display{}

@Builder
public class PcBuilder {
    private Cpu cpu;
    private Memory memory;
    private Ssd ssd;
    private Display display;

    public static void main(String[] args) {
        PcBuilder pc = PcBuilder.builder()
                .cpu(new Cpu())
                .memory(new Memory())
                .ssd(new Ssd())
                .display(new Display())
                .build();
    }
}
