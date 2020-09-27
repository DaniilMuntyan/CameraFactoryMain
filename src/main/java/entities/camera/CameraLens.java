package entities.camera;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public final class CameraLens {
    private UUID id;
    private Integer focalLength;
    private LensType lensType;
    private Camera camera;

    public CameraLens(Integer focalLength, LensType lensType) {
        this.focalLength = focalLength;
        this.lensType = lensType;
    }

    @Override
    public String toString() {
        return "Camera lens id: " + id + ", focal length: " + focalLength + " mm, lens type: " + lensType;
    }
}
