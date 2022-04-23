package com.example.qlvattu;

public class vatTu {
    private String id;
    private String name, unit, manu;
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public vatTu(String id, String name, String unit, String manu, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.manu = manu;
        this.price = price;
    }

    public vatTu(String name, String unit, String manu, int price) {
        this.name = name;
        this.unit = unit;
        this.manu = manu;
        this.price = price;
    }

    public vatTu() {
    }

    @Override
    public String toString() {
        return "vatTu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", manu='" + manu + '\'' +
                ", price=" + price +
                '}';
    }
}
