package dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = @Column(name = "adress_id"), generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<Address> listOfAdresses = new ArrayList<Address>();

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

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Address> getListOfAdresses() {
        return listOfAdresses;
    }

    public void setListOfAdresses(Collection<Address> listOfAdresses) {
        this.listOfAdresses = listOfAdresses;
    }
}
