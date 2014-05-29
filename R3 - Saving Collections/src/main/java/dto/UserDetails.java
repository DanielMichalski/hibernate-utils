package dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ElementCollection
    private Set<Address> listOfAdresses = new HashSet<Address>();

    @Column(name = "joind_date")
    @Temporal(TemporalType.DATE)
    private Date joindedDate;

    @Column(name = "description")
    @Lob
    private String description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
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

    public String getDescription() {
        return description;
    }

    public Set<Address> getListOfAdresses() {
        return listOfAdresses;
    }

    public void setListOfAdresses(Set<Address> listOfAdresses) {
        this.listOfAdresses = listOfAdresses;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
