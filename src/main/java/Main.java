import controllers.GlobalVariables;
import controllers.models.CameraController;
import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.camera.CameraBody;
import entities.camera.CameraLens;
import org.springframework.http.MediaType;

import java.util.List;

public class Main {
    private static final String splitter = "-----------------------------------------------------------------------" +
            "------------------------------------------------------------------------------------------------------";

    private static void print() {
        System.out.println(splitter);
    }

    public static void main(String[] args) {
        GlobalVariables.headers.setContentType(MediaType.APPLICATION_JSON);

        ProductLifecycle productLifecycle = new ProductLifecycle();

        print();

        // Assembling
        Camera newCamera = productLifecycle.assembling();
        print();

        // Calibrating
        Camera calibratedCamera = productLifecycle.calibrating(newCamera);
        print();

        // Testing
        Camera testedCamera = productLifecycle.testing(calibratedCamera);
        print();

        // Final stage
        Camera finalCamera = productLifecycle.finalStage(testedCamera);
        print();

        // Ordering
        productLifecycle.ordering();

        print();
        System.out.println("\n↓ RESOURCES ↓\n");
        print();

        CameraController cameraController = new CameraController();

        // All cameras
        System.out.println("ALL CAMERAS");
        List<Camera> allCameras = cameraController.getAllCameras();
        for(Camera temp: allCameras) {
            System.out.println(temp);
        }
        print();

        // All camera backs
        System.out.println("ALL CAMERA BACKS");
        List<CameraBack> allCameraBacks = cameraController.getAllCameraBacks();
        for(CameraBack temp: allCameraBacks) {
            System.out.println(temp);
        }
        print();

        // All camera bodies
        System.out.println("ALL CAMERA BODIES");
        List<CameraBody> allCameraBodies = cameraController.getAllCameraBodies();
        for(CameraBody temp: allCameraBodies) {
            System.out.println(temp);
        }
        print();

        // All camera lens
        System.out.println("ALL CAMERA LENS");
        List<CameraLens> allCameraLens = cameraController.getAllCameraLens();
        for(CameraLens temp: allCameraLens) {
            System.out.println(temp);
        }
        print();
    }
}
