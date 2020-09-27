package dto.camera_dto;

import entities.camera.LensType;
import lombok.Data;

@Data
public final class CameraLensDTO {
    private Integer focalLength;
    private LensType lensType;
}
