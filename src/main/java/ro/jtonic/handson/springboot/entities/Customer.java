package ro.jtonic.handson.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Antonel Ernest Pazargic on 06/09/16.
 * @author Antonel Ernest Pazargic
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // @JsonIgnore
    private Byte age;

    public Customer() {
    }

    public Customer(String name, Byte age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name) {
        this(name, null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }

}
