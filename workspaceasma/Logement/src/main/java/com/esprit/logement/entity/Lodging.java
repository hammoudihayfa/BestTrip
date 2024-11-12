package com.esprit.logement.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Lodging {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String address;
    private double pricePerNight;

    // Constructors, getters, and setters
    public Lodging() {}

    public Lodging(String name, String address, double pricePerNight) {
        this.name = name;
        this.address = address;
        this.pricePerNight = pricePerNight;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    @Override
    public String toString() {
        return "Lodging{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}