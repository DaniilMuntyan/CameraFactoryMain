package entities.camera;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public final class CameraBack {
    private UUID id;
    private Boolean matrixCheck;
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
    private Camera camera;

    public CameraBack(Dimensions dimensions, Integer resolution, Integer colorDepth) {
        this.dimensions = dimensions;
        this.resolution = resolution;
        this.colorDepth = colorDepth;
    }

    @Override
    public String toString() {
        Dimensions dim = new Dimensions();
        return "Camera back id: " + id + "\nDimensions: " + dimensions + "\nResolution: " + resolution +
                " MP\nColor depth: " + colorDepth + " bpp";
    }
}