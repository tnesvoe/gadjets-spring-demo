package ru.company.devices.entity;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name="brand", nullable = false)
    private String brand;

    @Column(name="model", nullable = false)
    private String model;

    // Many devices to one client
    @ManyToOne
    private Client client;

    public Device() {

    }

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }


    /*
    @Override
    public boolean equals(final Object otherObj) {
        if ((otherObj == null) || !(otherObj instanceof Room)) {
            return false;
        }
        final Room other = (Room) otherObj;
        return new EqualsBuilder().append(getNumber(), other.getNumber())
                .append(getBuilding().getId(), other.getBuilding().getId())
                .isEquals();
    }
    * */

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getModel())
                .append(getBrand())
                .append(getId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel();
    }


}
