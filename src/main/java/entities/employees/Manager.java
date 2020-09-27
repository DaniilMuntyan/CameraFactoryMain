package entities.employees;

import entities.camera.Camera;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Manager extends Employee {

    private List<Camera> defects;

    public void orderDetails() {
        Iterator<Camera> i = this.defects.iterator();
        while(i.hasNext()) {
            Camera camera = i.next();
            camera.setManager(null);
            i.remove();
        }
    }

    public void addToOrder(Camera camera) {
        if (this.defects.contains(camera))
            return;

        defects.add(camera);
    }

    public Manager(String name, String surname, String phone) {
        super(name, surname, phone);
        this.defects = new ArrayList<>();
    }

    private String getDefectList() {
        String detailsToAdd = "";
        for (Camera camera: defects) {
            detailsToAdd = detailsToAdd.concat(camera.getCamera_id() + "\n");
        }
        return detailsToAdd;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone() +
                "\nDetails to order: " + getDefectList();
    }

}
