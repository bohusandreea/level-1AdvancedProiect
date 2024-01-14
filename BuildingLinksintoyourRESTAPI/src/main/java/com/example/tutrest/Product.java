package com.example.tutrest;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productName;
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

    public Product(String productName, double price, boolean inStock, Category category, String manufacturer, String description) {

        this.productName = productName;
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
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) && Objects.equals(this.productName, product.productName)
                && Objects.equals(this.price, product.price) && Objects.equals(this.inStock, product.inStock)
                && Objects.equals(this.description, product.description) && Objects.equals(this.category, product.category)
                && Objects.equals(this.manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.productName, this.price, this.category, this.description,
                this.manufacturer, this.inStock);
    }

    @Override
    public String toString() {

        return "Product{" +
                "id=" + this.id +
                ", productName='" + this.productName + '\'' +
                ", price=" + this.price + '\'' +
                ", inStock=" + this.inStock +'\'' +
                ", category=" + this.category +'\'' +
                ", manufacturer='" + this.manufacturer + '\'' +
                ", description = " + this.description+
                '}';
    }
}





