package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)                   // Dane zostaną pobrane za pierwszym razem
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Collection<Address> addresses = new ArrayList<Address>();   // ArrayList wspiera indexy

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", addresses=").append(addresses);
        sb.append('}');
        return sb.toString();
    }
}
