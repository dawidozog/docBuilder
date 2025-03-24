package com.DocBuilder.db;

public class CarSaleAgreementRequest {

    private String sellerName;
    private String sellerAddress;
    private String sellerPeselNip;
    private String sellerPhone;

    private String buyerName;
    private String buyerAddress;
    private String buyerPeselNip;
    private String buyerPhone;

    private String carBrand;
    private String carModel;
    private int year;
    private String vin;
    private String plateNumber;
    private int mileage;

    private double price;
    private String paymentMethod; // "Gotówka" lub "Przelew"

    private String agreementDate;
    private String agreementLocation;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerPeselNip() {
        return sellerPeselNip;
    }

    public void setSellerPeselNip(String sellerPeselNip) {
        this.sellerPeselNip = sellerPeselNip;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerPeselNip() {
        return buyerPeselNip;
    }

    public void setBuyerPeselNip(String buyerPeselNip) {
        this.buyerPeselNip = buyerPeselNip;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
    }

    public String getAgreementLocation() {
        return agreementLocation;
    }

    public void setAgreementLocation(String agreementLocation) {
        this.agreementLocation = agreementLocation;
    }
}
