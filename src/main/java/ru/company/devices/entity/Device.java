package ru.company.devices.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name="device_type", nullable = false)
    private String deviceType;

    @Column(name="brand", nullable = false)
    private String brand;

    @Column(name="model", nullable = false)
    private String model;

    @Column(name="processor")
    private String processor;

    @Column(name="diagonal")
    private double diagonal;

    @Column(name="ram")
    private int ram;


    // Many devices to one client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return this.client;
    }

    // девайсы без клиента или с клиентом

    public Device(String deviceType, String processor, double diagonal, int ram, String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.client = null;
        this.deviceType = deviceType;
        this.processor = processor;
        this.diagonal = diagonal;
        this.ram = ram;
    }

    public Device(String deviceType, String processor, double diagonal, int ram, String brand, String model, Client client) {
        this.brand = brand;
        this.model = model;
        this.client = client;
        this.deviceType = deviceType;
        this.processor = processor;
        this.diagonal = diagonal;
        this.ram = ram;
    }

    public Device() {

    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getDiagonal() {
        return this.diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
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


    @Override
    public boolean equals(final Object otherObj) {
        if ((otherObj == null) || !(otherObj instanceof Device)) {
            return false;
        }
        final Device other = (Device) otherObj;

        return new EqualsBuilder()
                .append(getBrand(), other.getBrand())
                .append(getModel(), other.getModel())
                .append(getClient().getId(), other.getClient().getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getRam())
                .append(getDeviceType())
                .append(getModel())
                .append(getBrand())
                .append(getId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + " " + getDeviceType() + " " + getProcessor() + " " + getDiagonal() + " " + getRam();
    }


}
