package entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

    @ElementCollection()
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")       // generator klucza głównego
    @CollectionId(columns = {@Column(name = "address_id")},       // nadaje klucz główny dla tabeli user_address
            generator = "hilo-gen",
            type = @Type(type = "long"))
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
