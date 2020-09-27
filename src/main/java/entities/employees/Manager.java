package entities.employees;

import entities.camera.Camera;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Manager extends Employee {

    private List<Camera> defects;

    public Manager(String name, String surname, String phone) {
        super(name, surname, phone);
        this.defects = new ArrayList<>();
    }

    public String getDefectList() {
        String detailsToAdd = "[";
        for (Camera camera: defects) {
            if (defects.indexOf(camera) < defects.size() - 1)
                detailsToAdd = detailsToAdd.concat(camera.getCamera_id() + ", ");
            else
                detailsToAdd = detailsToAdd.concat(camera.getCamera_id() + "]");
        }
        return detailsToAdd;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " " + getSurname() + ", id: " +  getId() + ", phone: " + getPhone() +
                ", details to order: " + (defects.size() > 0 ? getDefectList() : "[]");
    }

}
