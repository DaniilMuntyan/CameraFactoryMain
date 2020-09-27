package dto.requests.calibration;

import lombok.Data;

import java.util.UUID;

@Data
public final class CalibrateCameraDTO {
    private UUID calibratorId;
    private UUID cameraId;
}
