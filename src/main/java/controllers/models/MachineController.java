package controllers.models;

import controllers.EndPoints;
import controllers.GlobalVariables;
import entities.machines.Calibrator;
import entities.machines.Packer;
import entities.machines.Tester;
import org.springframework.http.ResponseEntity;

public final class MachineController {

    public Calibrator createCalibrator(String name) {
        Calibrator calibrator = new Calibrator(name);
        ResponseEntity<Calibrator> calibratorResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_CALIBRATOR, calibrator, Calibrator.class);
        return calibratorResponseEntity.getBody();
    }

    public Packer createPacker(String name) {
        Packer packer = new Packer(name);
        ResponseEntity<Packer> packerResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_PACKER, packer, Packer.class);
        return packerResponseEntity.getBody();
    }

    public Tester createTester(String name) {
        Tester tester = new Tester(name);
        ResponseEntity<Tester> testerResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.CREATE_TESTER, tester, Tester.class);
        return testerResponseEntity.getBody();
    }

}
