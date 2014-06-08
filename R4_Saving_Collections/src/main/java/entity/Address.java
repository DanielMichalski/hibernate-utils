package entity;

import javax.persistence.Embeddable;

/**
 * Author: Daniel
 */

@Embeddable
public class Address {

    private String street;

    private String city;

    private String state;

    private String pinCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pincode) {
        this.pinCode = pincode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", pincode='").append(pinCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
