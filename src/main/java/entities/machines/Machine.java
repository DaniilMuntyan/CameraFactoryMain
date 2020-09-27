package entities.machines;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Machine {
    private UUID id;
    private String name;

    public Machine(String name) {
        this.name = name;
    }

}
