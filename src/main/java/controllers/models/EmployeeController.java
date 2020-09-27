package controllers.models;

import controllers.EndPoints;
import controllers.GlobalVariables;
import entities.employees.Collector;
import entities.employees.Manager;
import entities.employees.Technician;
import org.springframework.http.ResponseEntity;

public final class EmployeeController {

    public Collector createCollector(String name, String surname, String phone) {
        Collector collector = new Collector(name, surname, phone);
        ResponseEntity<Collector> collectorResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_COLLECTOR, collector, Collector.class);
        return collectorResponseEntity.getBody();
    }

    public Manager createManager(String name, String surname, String phone) {
        Manager manager = new Manager(name, surname, phone);
        ResponseEntity<Manager> managerResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_MANAGER, manager, Manager.class);
        return managerResponseEntity.getBody();
    }

    public Technician createTechnician(String name, String surname, String phone) {
        Technician technician = new Technician(name, surname, phone);
        ResponseEntity<Technician> technicianResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_TECHNICIAN, technician, Technician.class);
        return technicianResponseEntity.getBody();
    }

}
