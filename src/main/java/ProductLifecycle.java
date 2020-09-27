import controllers.assembling.AssembleController;
import controllers.calibration.CalibrationController;
import controllers.final_stage.FinalStageController;
import controllers.models.EmployeeController;
import controllers.models.MachineController;
import controllers.ordering.OrderController;
import controllers.testing.TestingController;
import entities.camera.*;
import entities.employees.Collector;
import entities.employees.Employee;
import entities.employees.Manager;
import entities.employees.Technician;
import entities.machines.Calibrator;
import entities.machines.Machine;
import entities.machines.Packer;
import entities.machines.Tester;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class ProductLifecycle {
    private final InputDataHandler inputDataHandler;
    private final Random rand;

    public ProductLifecycle() {
        this.inputDataHandler = new InputDataHandler();
        this.rand = new Random();
    }

    public Camera assembling() {
        EmployeeController employeeController = new EmployeeController();

        List<Collector> collectors = employeeController.getAllCollectors();
        Collector collectorCameraBack = this.inputDataHandler.getRandomFromList(collectors);
        Collector collectorCameraBody = this.inputDataHandler.getRandomFromList(collectors);
        Collector collectorCameraLens = this.inputDataHandler.getRandomFromList(collectors);
        Collector collectorCamera = this.inputDataHandler.getRandomFromList(collectors);

        AssembleController assembleController = new AssembleController();

        Dimensions backDimensions = inputDataHandler.getRandomDimensions();
        Integer resolutionBack = 20 + rand.nextInt(100);
        Integer colorDepth = 10 + rand.nextInt(100);
        CameraBack cameraBack = assembleController.assembleCameraBack(collectorCameraBack, backDimensions,
                resolutionBack, colorDepth);
        System.out.println("ASSEMBLED " + cameraBack.toString());

        Dimensions bodyDimensions = inputDataHandler.getRandomDimensions();
        String color = inputDataHandler.getRandomColor();
        CameraBody cameraBody = assembleController.assembleCameraBody(collectorCameraBody, bodyDimensions, color);
        System.out.println("ASSEMBLED " + cameraBody.toString());

        Integer focalLength = 10 + rand.nextInt(100);
        LensType lensType = inputDataHandler.getRandomLens();
        CameraLens cameraLens = assembleController.assembleCameraLens(collectorCameraLens, focalLength, lensType);
        System.out.println("ASSEMBLED " + cameraLens.toString());

        Camera camera = assembleController.assembleCamera(collectorCamera, cameraBack, cameraBody, cameraLens);
        System.out.println("ASSEMBLED " + camera.toString());

        return camera;
    }

    public Camera calibrating(Camera camera) {
        MachineController machineController = new MachineController();

        List<Calibrator> calibrators = machineController.getAllCalibrators();
        Machine calibrator = inputDataHandler.getRandomFromList(calibrators);

        CalibrationController calibrationController = new CalibrationController((Calibrator) calibrator);
        Camera newCamera = calibrationController.calibrateCamera(camera);
        System.out.println("CALIBRATED " + newCamera);

        return camera;
    }

    public Camera testing(Camera camera) {
        MachineController machineController = new MachineController();
        EmployeeController employeeController = new EmployeeController();

        List<Tester> testers = machineController.getAllTesters();
        Machine tester = inputDataHandler.getRandomFromList(testers);

        List<Technician> technicians = employeeController.getAllTechnicians();
        Employee technician = inputDataHandler.getRandomFromList(technicians);

        TestingController testingController = new TestingController((Tester) tester, (Technician) technician);
        Camera testedCamera = testingController.test(camera);
        System.out.println("TESTED " + camera);

        return testedCamera;
    }

    public Camera finalStage(Camera camera) {
        EmployeeController employeeController = new EmployeeController();
        MachineController machineController = new MachineController();

        List<Technician> technicians = employeeController.getAllTechnicians();
        List<Manager> managers = employeeController.getAllManagers();
        List<Packer> packers = machineController.getAllPackers();

        Employee technician = inputDataHandler.getRandomFromList(technicians);
        Employee manager = inputDataHandler.getRandomFromList(managers);
        Machine packer = inputDataHandler.getRandomFromList(packers);

        FinalStageController finalStageController =
                new FinalStageController((Technician) technician, (Manager) manager, (Packer) packer);

        Camera finalCamera = finalStageController.finalStage(camera);
        System.out.println("FINAL STAGE " + camera);

        return finalCamera;
    }

    public void ordering() {
        EmployeeController employeeController = new EmployeeController();

        List<Manager> managers = employeeController.getAllManagers();
        Collections.reverse(managers); // From end to begin

        for(Manager manager: managers) {
            if (manager.getDefects().size() != 0) {
                OrderController orderController = new OrderController();
                System.out.println("DEFECTED CAMERAS WAS FOUND " + manager);
                Manager newManager = orderController.orderDetails(manager);
                System.out.println("ORDERED " + newManager);
            }
        }

        System.out.println("ALL COPIES ARE SERVICEABLE");
    }
}
