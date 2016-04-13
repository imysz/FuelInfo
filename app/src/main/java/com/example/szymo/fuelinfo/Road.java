package com.example.szymo.fuelinfo;

public class Road {

    private long id;
    private String km;
    private String ill;
    private String avgUsage;
    private String unitPrice;
    private String totalPrice;
    private String date;

    public Road(){

    }

    public Road(String km, String ill, String avgUsage, String unitPrice, String totalPrice, String date){
        this.id=id;
        this.km = km;
        this.ill=ill;
        this.avgUsage=avgUsage;
        this.unitPrice=unitPrice;
        this.totalPrice=totalPrice;
        this.date=date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvgUsage() {
        return avgUsage;
    }

    public void setAvgUsage(String avgUsage) {
        this.avgUsage = avgUsage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
