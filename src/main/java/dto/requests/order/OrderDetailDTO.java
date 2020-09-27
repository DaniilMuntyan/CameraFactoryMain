package dto.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public final class OrderDetailDTO {
    private UUID managerId;
}
