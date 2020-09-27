import controllers.GlobalVariables;
import entities.camera.Camera;
import org.springframework.http.MediaType;

public class Main {

    private static final String splitter = "-----------------------------------------------------------------------" +
            "-------------------------------------------------";

    private static void print(Object object) {
        System.out.println(object);
        System.out.println(splitter);
    }

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
    }

}
