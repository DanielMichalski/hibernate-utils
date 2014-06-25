package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Author: Daniel
 */
@Entity
@DiscriminatorValue("bike")
public class TwoWheeler extends Vehicle {
    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TwoWheeler{");
        sb.append("steeringHandle='").append(steeringHandle).append('\'');
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
