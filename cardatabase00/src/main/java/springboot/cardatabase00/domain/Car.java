package springboot.cardatabase00.domain;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String brand;

    private String model;

    private String color;

    private String resistrationNumber;

    private int modelYear;

    private int price;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car() {}

    public Car(String brand, String model, String color, String resistrationNumber, int modelYear, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.resistrationNumber = resistrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() {
        return Id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getResistrationNumber() {
        return resistrationNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getPrice() {
        return price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setResistrationNumber(String resistrationNumber) {
        this.resistrationNumber = resistrationNumber;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
