package dto.requests.testing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TestCameraDTO {
    private UUID testerId;
    private UUID technicianId;
    private UUID cameraId;
}
