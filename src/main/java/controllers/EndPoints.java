package controllers;

public class EndPoints {
    public static final String URL = "http://localhost:8080";

    public static final String ASSEMBLE_CAMERA_BACK = URL + "/api/assemble/camera_back";
    public static final String ASSEMBLE_CAMERA_BODY = URL + "/api/assemble/camera_body";
    public static final String ASSEMBLE_CAMERA_LENS = URL + "/api/assemble/camera_lens";
    public static final String ASSEMBLE_CAMERA = URL + "/api/assemble/camera";

    public static final String CREATE_COLLECTOR = URL + "/api/collectors";
    public static final String CREATE_MANAGER = URL + "/api/managers";
    public static final String CREATE_TECHNICIAN = URL + "/api/technicians";

    public static final String CREATE_CALIBRATOR = URL + "/api/calibrators";
    public static final String CREATE_PACKER = URL + "/api/packers";
    public static final String CREATE_TESTER = URL + "/api/testers";

    public static final String CALIBRATE_CAMERA = URL + "/api/calibrate";
    public static final String TESTING = URL + "/api/test";
    public static final String ORDER = URL + "/api/order";
    public static final String FINAL_STAGE = URL + "/api/final_stage";


}
