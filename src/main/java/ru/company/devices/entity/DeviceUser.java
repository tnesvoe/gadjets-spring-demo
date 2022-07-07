package ru.company.devices.entity;

import javax.persistence.*;

@Entity
public class DeviceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public DeviceUser() {

    }

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String thirdName;

    public void setName(String name) {
     this.name = name;
    }

    public DeviceUser(String surname, String name, String thirdName) {
     this.name = name;
     this.surname = surname;
     this.thirdName = thirdName;
    }

    public void setSurname() {}

    @Override
    public String toString() {
        return name + " " + surname + " " + thirdName;
    }
}
