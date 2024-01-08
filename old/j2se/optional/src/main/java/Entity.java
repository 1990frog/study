import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Entity {
    private String code;
    private String name;
}