package dto.requests.testing;

import lombok.Data;

import java.util.UUID;

@Data
public class TestCameraDTO {
    private UUID testerId;
    private UUID technicianId;
    private UUID cameraId;
}
