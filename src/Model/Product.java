package Model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private float sellPrice;
    private float purchasePrice;
    private Date purchaseDate;
    private Date sellDate;
    private String bodySize;
    private boolean isSold;

    public Product(int id, String name, Brand brand, String bodySize, float purchasePrice,
                   Date purchaseDate, boolean isSold, float sellPrice, Date sellDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sellPrice = sellPrice;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.bodySize = bodySize;
        this.isSold = isSold;
        this.sellDate = sellDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getBodySize() {
        return bodySize;
    }

    public void setBodySize(String bodySize) {
        this.bodySize = bodySize;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getSellDate() {return sellDate;}

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", sellPrice=" + sellPrice +
                ", purchasePrice=" + purchasePrice +
                ", purchaseDate=" + purchaseDate +
                ", sellDate=" + sellDate +
                ", bodySize='" + bodySize + '\'' +
                ", isSold=" + isSold +
                '}';
    }
}


