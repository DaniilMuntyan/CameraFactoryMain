package dto.camera_dto;

import entities.camera.Dimensions;
import lombok.Data;

@Data
public final class CameraBackDTO {
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
}
