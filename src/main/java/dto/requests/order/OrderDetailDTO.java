package dto.requests.order;

import lombok.Data;

import java.util.UUID;

@Data
public final class OrderDetailDTO {
    private UUID managerId;
}
