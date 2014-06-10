package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @ManyToMany(mappedBy = "vehicles")
    private Collection<User> users = new ArrayList<User>();

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("vehicleId=").append(vehicleId);
        sb.append(", vehicleName='").append(vehicleName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
