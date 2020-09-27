package entities.machines;

import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.camera.Dimensions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Tester extends Machine {

    public boolean checkDimensions(CameraBack cameraBack) {
        Dimensions standardBack = new Dimensions(25, 20, 15);
        return cameraBack.getDimensions().compareTo(standardBack) > 0;
    }

    public boolean checkAutofocus(Camera camera) {
        Boolean isDefected = new Random().nextInt(4) == 0; // Probability of defect: 1/4
        return !isDefected;
    }

    public Tester(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Test machine id: " + getId() + "\nName: " + getName();
    }

}
