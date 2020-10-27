import controllers.GlobalVariables;
import entities.camera.Camera;
import org.springframework.http.MediaType;

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

        for(int i = 0; i < 3; i++) {

            // Assembling
            Camera newCamera = productLifecycle.assembling();
            print();

            // Calibrating
            Camera calibratedCamera = productLifecycle.calibrating(newCamera);
            print();

            // Final stage
            productLifecycle.finalStage(calibratedCamera);
            print();

        }
    }
}
