package dto;

import javax.persistence.*;

/**
 * Author: Daniel
 */
@Entity
public class UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String userName;

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
}
