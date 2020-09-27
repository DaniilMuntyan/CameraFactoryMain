package controllers.testing;

import controllers.EndPoints;
import controllers.GlobalVariables;
import dto.requests.testing.TestCameraDTO;
import entities.camera.Camera;
import entities.employees.Technician;
import entities.machines.Tester;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public final class TestingController {
    private Tester tester;
    private Technician technician;

    public TestingController(Tester tester, Technician technician) {
        this.tester = tester;
        this.technician = technician;
    }

    public Camera test(Camera camera) {
        TestCameraDTO testCameraDTO = new TestCameraDTO(this.tester.getId(), this.technician.getId(),
                camera.getCamera_id());

        HttpEntity<TestCameraDTO> testCamera = new HttpEntity<>(testCameraDTO);

        ResponseEntity<Camera> cameraResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.TESTING, testCamera, Camera.class);

        return cameraResponseEntity.getBody();
    }
}
