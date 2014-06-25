package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Author: Daniel
 */
@Entity
@DiscriminatorValue("car")
public class FourWheeler extends Vehicle {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FourWheeler{");
        sb.append("steeringWheel='").append(steeringWheel).append('\'');
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
