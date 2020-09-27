package entities.machines;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Calibrator extends Machine {

    public Calibrator(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Calibration machine id: " + getId() + ", name: " + getName();
    }
}
