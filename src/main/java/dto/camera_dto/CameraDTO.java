package dto.camera_dto;

import entities.camera.CameraBack;
import entities.camera.CameraBody;
import entities.camera.CameraLens;
import lombok.Data;

@Data
public final class CameraDTO {
    private CameraBack cameraBack;
    private CameraBody cameraBody;
    private CameraLens cameraLens;
}
