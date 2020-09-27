package controllers.models;

import controllers.EndPoints;
import controllers.GlobalVariables;
import entities.camera.Camera;
import entities.camera.CameraBack;
import entities.camera.CameraBody;
import entities.camera.CameraLens;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public final class CameraController {

    public List<CameraBack> getAllCameraBacks() {
        ResponseEntity<List<CameraBack>> responseEntity = GlobalVariables.restTemplate
                .exchange(EndPoints.GET_ALL_BACKS, HttpMethod.GET, GlobalVariables.headersEntity,
                        new ParameterizedTypeReference<List<CameraBack>>(){});

        return responseEntity.getBody();
    }

    public List<CameraBody> getAllCameraBodies() {
        ResponseEntity<List<CameraBody>> responseEntity = GlobalVariables.restTemplate
                .exchange(EndPoints.GET_ALL_BODIES, HttpMethod.GET, GlobalVariables.headersEntity,
                        new ParameterizedTypeReference<List<CameraBody>>(){});

        return responseEntity.getBody();
    }

    public List<CameraLens> getAllCameraLens() {
        ResponseEntity<List<CameraLens>> responseEntity = GlobalVariables.restTemplate
                .exchange(EndPoints.GET_ALL_LENS, HttpMethod.GET, GlobalVariables.headersEntity,
                        new ParameterizedTypeReference<List<CameraLens>>(){});

        return responseEntity.getBody();
    }

    public List<Camera> getAllCameras() {
        ResponseEntity<List<Camera>> responseEntity = GlobalVariables.restTemplate
                .exchange(EndPoints.GET_ALL_CAMERAS, HttpMethod.GET, GlobalVariables.headersEntity,
                        new ParameterizedTypeReference<List<Camera>>(){});

        return responseEntity.getBody();
    }
}
