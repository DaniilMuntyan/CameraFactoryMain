package controllers.assembling;

import controllers.EndPoints;
import controllers.GlobalVariables;
import dto.requests.assembling.AssembleBackDTO;
import dto.requests.assembling.AssembleBodyDTO;
import dto.requests.assembling.AssembleCameraDTO;
import dto.requests.assembling.AssembleLensDTO;
import entities.camera.*;
import entities.employees.Collector;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public final class AssembleController {
    private UUID colectorId;

    public AssembleController() {}

    public AssembleController(Collector collector) {
        this.colectorId = collector.getId();
    }

    public CameraBack assembleCameraBack(Dimensions dimensions, Integer resolution, Integer colorDepth) {
        AssembleBackDTO cameraBackDTO = new AssembleBackDTO(this.colectorId, dimensions, resolution, colorDepth);

        HttpEntity<AssembleBackDTO> assembleBack = new HttpEntity<>(cameraBackDTO);

        ResponseEntity<CameraBack> assembleBackResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.ASSEMBLE_CAMERA_BACK, assembleBack, CameraBack.class);

        return assembleBackResponseEntity.getBody();
    }

    public CameraBody assembleCameraBody(Dimensions dimensions, String color) {
        AssembleBodyDTO cameraBodyDTO = new AssembleBodyDTO(this.colectorId, dimensions, color);

        HttpEntity<AssembleBodyDTO> assembleBody = new HttpEntity<>(cameraBodyDTO);

        ResponseEntity<CameraBody> cameraBodyResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.ASSEMBLE_CAMERA_BODY, assembleBody, CameraBody.class);

        return cameraBodyResponseEntity.getBody();
    }

    public CameraLens assembleCameraLens(Integer focalLength, LensType lensType) {
        AssembleLensDTO cameraLensDTO = new AssembleLensDTO(this.colectorId, focalLength, lensType);

        HttpEntity<AssembleLensDTO> assembleLens = new HttpEntity<>(cameraLensDTO);

        ResponseEntity<CameraLens> cameraLensResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.ASSEMBLE_CAMERA_LENS, assembleLens, CameraLens.class);

        return cameraLensResponseEntity.getBody();
    }

    public Camera assembleCamera(CameraBack cameraBack, CameraBody cameraBody, CameraLens cameraLens) {
        AssembleCameraDTO cameraDTO = new AssembleCameraDTO(this.colectorId, cameraBack.getId(),
                cameraBody.getId(), cameraLens.getId());

        HttpEntity<AssembleCameraDTO> assembleCamera = new HttpEntity<>(cameraDTO);

        ResponseEntity<Camera> cameraResponseEntity = GlobalVariables.restTemplate
                .postForEntity(EndPoints.ASSEMBLE_CAMERA, assembleCamera, Camera.class);

        return cameraResponseEntity.getBody();
    }

}
