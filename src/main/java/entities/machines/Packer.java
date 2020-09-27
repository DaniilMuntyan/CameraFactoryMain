package entities.machines;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Packer extends Machine {

    public Packer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Packing machine id: " + getId() + ", name: " + getName();
    }
}
