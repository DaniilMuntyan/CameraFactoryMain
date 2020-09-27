package controllers.ordering;

import controllers.EndPoints;
import controllers.GlobalVariables;
import dto.requests.order.OrderDetailDTO;
import entities.employees.Manager;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public final class OrderController {

    public Manager orderDetails(Manager manager) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO(manager.getId());

        HttpEntity<OrderDetailDTO> orderDetailDTOHttpEntity = new HttpEntity<>(orderDetailDTO);

        ResponseEntity<Manager> managerResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.ORDER, orderDetailDTOHttpEntity, Manager.class);

        return managerResponseEntity.getBody();
    }

}
