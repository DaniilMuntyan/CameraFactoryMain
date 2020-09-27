import controllers.GlobalVariables;
import controllers.assembling.AssembleController;
import controllers.models.EmployeeController;
import entities.camera.*;
import entities.employees.Collector;
import entities.employees.Employee;
import entities.employees.Manager;
import entities.employees.Technician;
import entities.machines.Calibrator;
import entities.machines.Machine;
import entities.machines.Packer;
import entities.machines.Tester;
import org.springframework.http.MediaType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String splitter = "-----------------------------------------------------------------------" +
            "-------------------------------------------------";

    private static List<String> getPhones() {
        Random rand = new Random();
        List<String> listNumbers = new ArrayList<>();
        for(int i = 0; i < 100; ++i) {
            int n1 = rand.nextInt(7) + 1;
            int n2 = rand.nextInt(8);
            int n3 = rand.nextInt(8);
            int set2 = rand.nextInt(899) + 100;
            int set3 = rand.nextInt(8999) + 1000;
            listNumbers.add("(" + n1 + n2 + n3 + ")" + "-" + set2 + "-" + set3);
        }
        return listNumbers;
    }

    private static List<String> getListFromFile(String fileName) {
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                list.add(currentLine);
            }
            return list;

        } catch (IOException e) {
            return null;
        }
    }

    private static void print(Object object) {
        System.out.println(object);
        System.out.println(splitter);
    }

    private static void print() {
        System.out.println(splitter);
    }

    private static <T> T getRandomFromList(List<T> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private final static class DataForTesting {
        final List<String> names;
        final List<String> surnames;
        final List<String> colors;
        final List<String> robots;
        final List<String> phones;

        DataForTesting() {
            this.names = getListFromFile("./src/Files/Names.txt");
            this.surnames = getListFromFile("./src/Files/Surnames.txt");
            this.colors = getListFromFile("./src/Files/Colors.txt");
            this.robots = getListFromFile("./src/Files/Robot companies.txt");
            this.phones = getPhones();
        }
    }

    private final static class ListOfEntities {
        final List<Employee> collectors;
        final List<Employee> managers;
        final List<Employee> technicians;
        final List<Machine> calibrators;
        final List<Machine> testers;
        final List<Machine> packers;

        ListOfEntities() {
            this.collectors = new ArrayList<>();
            this.managers = new ArrayList<>();
            this.technicians = new ArrayList<>();
            this.calibrators = new ArrayList<>();
            this.testers = new ArrayList<>();
            this.packers = new ArrayList<>();
        }
    }

    private static List<String> getNameSurnamePhone(DataForTesting dataForTesting) {
        String name = getRandomFromList(dataForTesting.names);
        String surname = getRandomFromList(dataForTesting.surnames);
        String phone = getRandomFromList(dataForTesting.phones);

        return new ArrayList<>(Arrays.asList(name, surname, phone));
    }

    /*private static Manager createManager(Manager manager) {
        ResponseEntity<Manager> manager_response = restTemplate.postForEntity(Endpoints.CREATE_MANAGER, manager,
                Manager.class);
        return manager_response.getBody();
    }*/

    private static ListOfEntities initializeEntities(DataForTesting dataForTesting){
        ListOfEntities listOfEntities = new ListOfEntities();

        // Managers initialization
        for(int i = 0; i < 5; i++) {
            List<String> nameSurnamePhone = getNameSurnamePhone(dataForTesting);

            Employee manager;
            manager = new Manager(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));


            //listOfEntities.managers.add(manager);
        }

        // Collectors and technicians initialization
        for(int i = 0; i < 10; i++) {
            List<String> nameSurnamePhone = getNameSurnamePhone(dataForTesting);
            Employee collector;
            Employee technician;

            collector = new Collector(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));

            listOfEntities.collectors.add(collector);

            nameSurnamePhone = getNameSurnamePhone(dataForTesting);
            technician = new Technician(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));

            listOfEntities.technicians.add(technician);
        }

        // Machines initialization
        for(int i = 0; i < 5; ++i) {
            Machine calibrator = new Calibrator(getRandomFromList(dataForTesting.robots));
            Machine tester = new Tester(getRandomFromList(dataForTesting.robots));
            Machine packer = new Packer(getRandomFromList(dataForTesting.robots));

            listOfEntities.calibrators.add(calibrator);
            listOfEntities.testers.add(tester);
            listOfEntities.packers.add(packer);
        }

        return listOfEntities;

    }

    public static void main(String[] args) {
        GlobalVariables.headers.setContentType(MediaType.APPLICATION_JSON);

        EmployeeController employeeController = new EmployeeController();
        Collector collector = employeeController.createCollector("col", "hwvfk", "vhwjk");

        AssembleController assembleController = new AssembleController(collector);
        Dimensions dimensions = new Dimensions(96, 57, 20);
        CameraBack cameraBack = assembleController.assembleCameraBack(dimensions, 45, 2);
        print(cameraBack);
        CameraBody cameraBody = assembleController.assembleCameraBody(dimensions, "grey");
        print(cameraBody);
        CameraLens cameraLens = assembleController.assembleCameraLens(95, LensType.LONG_FOCUS);
        print(cameraLens);
        Camera camera = assembleController.assembleCamera(cameraBack, cameraBody, cameraLens);
        print(camera);
    }

}
