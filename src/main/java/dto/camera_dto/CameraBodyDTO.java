package dto.camera_dto;

import entities.camera.Dimensions;
import lombok.Data;

@Data
public final class CameraBodyDTO {
    private Dimensions dimensions;
    private String color;
}
