package springboot.gateway.predicate;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeBetweenConfig {
    LocalTime start;
    LocalTime end;
}
