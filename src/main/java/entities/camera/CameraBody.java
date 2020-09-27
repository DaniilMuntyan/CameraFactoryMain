package entities.camera;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public final class CameraBody {
    private UUID id;
    private Dimensions dimensions;
    private String color;
    private Camera camera;

    public CameraBody(Dimensions dimensions, String color) {
        this.dimensions = dimensions;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Camera body id: " + id + ", dimensions: " + dimensions + ", color: " + color;
    }

}
