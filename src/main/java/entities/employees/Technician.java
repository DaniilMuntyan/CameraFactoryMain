package entities.employees;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public final class Technician extends Employee {

    public Technician(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    @Override
    public String toString() {
        return "Technician " + getName() + " " + getSurname() + ", id: " +  getId() + ", phone: " + getPhone();
    }
}
