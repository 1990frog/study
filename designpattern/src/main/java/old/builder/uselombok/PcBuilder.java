package old.builder.uselombok;

class Cpu{}
class Memory{}
class Ssd{}
class Display{}

public class PcBuilder {
    private Cpu cpu;
    private Memory memory;
    private Ssd ssd;
    private Display display;

    PcBuilder(Cpu cpu, Memory memory, Ssd ssd, Display display) {
        this.cpu = cpu;
        this.memory = memory;
        this.ssd = ssd;
        this.display = display;
    }

    public static PcBuilderBuilder builder() {
        return new PcBuilderBuilder();
    }

    public static class PcBuilderBuilder {
        private Cpu cpu;
        private Memory memory;
        private Ssd ssd;
        private Display display;

        PcBuilderBuilder() {
        }

        public PcBuilderBuilder cpu(Cpu cpu) {
            this.cpu = cpu;
            return this;
        }

        public PcBuilderBuilder memory(Memory memory) {
            this.memory = memory;
            return this;
        }

        public PcBuilderBuilder ssd(Ssd ssd) {
            this.ssd = ssd;
            return this;
        }

        public PcBuilderBuilder display(Display display) {
            this.display = display;
            return this;
        }

        public PcBuilder build() {
            return new PcBuilder(this.cpu, this.memory, this.ssd, this.display);
        }

        public String toString() {
            return "PcBuilder.PcBuilderBuilder(cpu=" + this.cpu + ", memory=" + this.memory + ", ssd=" + this.ssd + ", display=" + this.display + ")";
        }
    }

    public static void main(String[] args) {
        PcBuilder pc = builder()
                .cpu(new Cpu())
                .memory(new Memory())
                .ssd(new Ssd())
                .display(new Display())
                .build();
    }

}
