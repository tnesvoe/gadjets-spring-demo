package ru.company.devices.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }



    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String thirdName;

    @OneToMany(mappedBy = "client")
    private List<Device> devices;

    public void setName(String name) {
     this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Client(String surname, String name, String thirdName) {
     this.name = name;
     this.surname = surname;
     this.thirdName = thirdName;
    }

    public Client() {

    }

    public Client(String fromFullName) {
        String[] split = fromFullName.split(" ");
        this.surname = split[0];
        this.name = split[1];
        this.thirdName = split[2];
    }

    public void setSurname(String surname) {this.surname = surname;}

    @Override
    public String toString() {
        return surname + " " + name + " " + thirdName;
    }
}
