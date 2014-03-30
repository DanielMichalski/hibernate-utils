package dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column (name = "joind_date")
    @Temporal(TemporalType.DATE)
    private Date joindedDate;

    @Column (name = "address")
    private String address;

    @Column (name = "description")
    @Lob
    private String description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + " gett";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoindedDate() {
        return joindedDate;
    }

    public void setJoindedDate(Date joindedDate) {
        this.joindedDate = joindedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetails{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", joindedDate=").append(joindedDate);
        sb.append(", address='").append(address).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
