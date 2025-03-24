package com.DocBuilder.db;

public class RentAgreementRequest {

    private String landlordName;
    private String landlordAddress;
    private String landlordPhone;

    private String tenantName;
    private String tenantAddress;
    private String tenantPhone;

    private String address; // Adres nieruchomości
    private double area; // Powierzchnia nieruchomości w m²
    private double rentAmount; // Kwota czynszu
    private double depositAmount; // Kaucja
    private String paymentDueDate; // Termin płatności (np. "10 każdego miesiąca")

    private String startDate;
    private String endDate;
    private int terminationNotice; // Okres wypowiedzenia (np. 1 lub 3 miesiące)

    private String agreementDate; // Data podpisania umowy


    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordAddress() {
        return landlordAddress;
    }

    public void setLandlordAddress(String landlordAddress) {
        this.landlordAddress = landlordAddress;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTerminationNotice() {
        return terminationNotice;
    }

    public void setTerminationNotice(int terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
    }
}