package entity;

import javax.persistence.*;

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

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("vehicleId=").append(vehicleId);
        sb.append(", vehicleName='").append(vehicleName).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

}
