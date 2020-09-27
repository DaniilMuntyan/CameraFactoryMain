package dto.requests.calibration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public final class CalibrateCameraDTO {
    private UUID calibratorId;
    private UUID cameraId;
}
