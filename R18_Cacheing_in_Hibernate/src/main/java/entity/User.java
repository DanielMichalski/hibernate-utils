package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@NamedQuery(name = "User.byId", query = "from User where id = ?")
@NamedNativeQuery(name = "User.byName",
        query = "SELECT * FROM users WHERE name = ?", resultClass = User.class)
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", vehicles=").append(vehicles);
        sb.append('}');
        return sb.toString();
    }

}
