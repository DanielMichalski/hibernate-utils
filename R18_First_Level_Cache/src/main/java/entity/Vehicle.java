package entity;

import javax.persistence.*;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "Vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_name")
    private String vehicleName;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("vehicleId=").append(vehicleId);
        sb.append(", vehicleName='").append(vehicleName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
