package com.example.tutrest;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productFirstName;
    private String productLastName;
    private double price;
    private boolean inStock;
    private Category category;
    private String manufacturer;

    private String description;

    public Product() {

    }

    public void setId(Long id) {
        this.id = id;
    }


    public enum Category {
        ELECTRONICS,
        CLOTHING,
        BOOKS,
        FOOD
    }

    public Product(String productFirstName,String productLastName, double price, boolean inStock, Category category, String manufacturer, String description) {

        this.productFirstName = productFirstName;
        this.productLastName = productLastName;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
        this.manufacturer = manufacturer;
        this.description=description;
    }
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return this.productFirstName + " " + this.productLastName;
    }

    public void setProductName(String productName) {
        String[] parts = productName.split(" ");
        this.productFirstName= parts[0];
        this.productLastName = parts[1];
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductFirstName() {
        return this.productFirstName;
    }

    public String getProductLastName() {
        return this.productLastName;
    }

    public void setFirstName(String firstName) {
        this.productFirstName = firstName;
    }

    public void setLastName(String lastName) {
        this.productLastName = lastName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) && Objects.equals(this.productFirstName, product.productFirstName)
                && Objects.equals(this.productLastName, product.productLastName)
                && Objects.equals(this.price, product.price) && Objects.equals(this.inStock, product.inStock)
                && Objects.equals(this.description, product.description) && Objects.equals(this.category, product.category)
                && Objects.equals(this.manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.productFirstName,this.productLastName, this.price, this.category, this.description,
                this.manufacturer, this.inStock);
    }

    @Override
    public String toString() {

        return "Product{" +
                "id=" + this.id +
                ", productFirstName='" + this.productFirstName + '\'' +
                ", productLastName='" + this.productLastName + '\'' +
                ", price=" + this.price + '\'' +
                ", inStock=" + this.inStock +'\'' +
                ", category=" + this.category +'\'' +
                ", manufacturer='" + this.manufacturer + '\'' +
                ", description = " + this.description+
                '}';
    }
}





