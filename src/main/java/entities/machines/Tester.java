package entities.machines;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Tester extends Machine {

    public Tester(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Test machine id: " + getId() + ", name: " + getName();
    }

}
