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

        // owning side

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String thirdName;

    @Column(name="phone_num", nullable = false)
    private long phoneNum;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Device> devices;

    public long getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Device> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Client(String surname, String name, String thirdName, long phoneNum, String email) {
     this.name = name;
     this.surname = surname;
     this.thirdName = thirdName;
     this.phoneNum = phoneNum;
     this.email = email;
    }

    public Client(String surname, String name, String thirdName, long phoneNum, String email, List<Device> devices) {
        this.name = name;
        this.surname = surname;
        this.thirdName = thirdName;
        this.devices = devices;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Client() {

    }

    public Client(String fromFullName, long phoneNum, String email) {
        String[] split = fromFullName.split(" ");
        this.surname = split[0];
        this.name = split[1];
        this.thirdName = split[2];
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public void setSurname(String surname) {this.surname = surname;}

    @Override
    public String toString() {
        return surname + " " + name + " " + thirdName + " " + phoneNum + " " + email;
    }
}
