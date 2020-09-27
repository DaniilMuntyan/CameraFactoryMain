package entities.camera;

import entities.employees.Manager;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public final class Camera {
    private UUID camera_id;
    private String innerInfo;
    private Boolean isPacked = false;
    private Boolean isFirmware = false;
    private Boolean isWipedClean = false;
    private Boolean isRejected = false;
    private CameraBack cameraBack;
    private CameraBody cameraBody;
    private CameraLens cameraLens;
    private Manager manager;

    public Camera(CameraBack cameraBack, CameraBody cameraBody, CameraLens cameraLens) {
        this.cameraBack = cameraBack;
        this.cameraBody = cameraBody;
        this.cameraLens = cameraLens;
    }

    @Override
    public String toString() {
        String packing = isPacked ? "Packed" : "Unpacked";
        String flashing = isFirmware ? "flashed" : "unflashed";
        String cleaning = isWipedClean ? "wiped" : "not wiped";

        String string = (packing + ", "  + cleaning + ", " +  flashing + " camera " + camera_id + "\n" + cameraBack + "\n" +
                cameraBody + "\n" + cameraLens);
        return string;
    }
}
