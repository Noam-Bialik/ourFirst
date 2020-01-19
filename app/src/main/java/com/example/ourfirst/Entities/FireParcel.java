package com.example.ourfirst.Entities;

import android.location.Location;

import com.example.ourfirst.Utils.Converters;

import java.text.SimpleDateFormat;

public class FireParcel {
    private int ID;
    private String warehouseID;
    private String warehouseLocation;
    private Enumes.ParcelStatus parcelStatus;
    private Enumes.ParcelType parcelType;
    private Boolean breakable;
    private Enumes.Weight weight;
    private String toName;
    private Location toLocation;
    private String toPhoneNumber;
    private String toMail;
    private SimpleDateFormat sendDate;
    private SimpleDateFormat reciviedDate;
    private String deliverName;


    public FireParcel(Parcel parcel) {
        this.ID = parcel.getID();
        this.warehouseID = parcel.getWarehouseID();
        this.warehouseLocation =parcel.getWarehouseLocation() ;
        this.parcelStatus = parcel.getParcelStatus();
        this.parcelType = parcel.getParcelType();
        this.breakable = parcel.getBreakable();
        this.weight = parcel.getWeight();
        this.toName = parcel.getToName();
        this.toLocation = parcel.getToLocation();
        this.toPhoneNumber = parcel.getToPhoneNumber();
        this.toMail = parcel.getToMail();
        this.sendDate = parcel.getSendDate();
        this.reciviedDate = parcel.getReciviedDate();
        this.deliverName = parcel.getDeliverName();
    }

    public FireParcel() {
        this.toLocation = new Location("");
    }
    public Double getLa()
    {return toLocation.getLatitude();}
    public Double getLo()
    {return toLocation.getLongitude();}
    public void setLa(Double la){
        toLocation.setLatitude(la);
    }
    public void setLo(Double lo){
        toLocation.setLatitude(lo);
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }




    public Enumes.ParcelStatus getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(Enumes.ParcelStatus parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Enumes.ParcelType getParcelType() {
        return parcelType;
    }

    public void setParcelType(Enumes.ParcelType parcelType) {
        this.parcelType = parcelType;
    }

    public Boolean getBreakable() {
        return breakable;
    }

    public void setBreakable(Boolean breakable) {
        this.breakable = breakable;
    }

    public Enumes.Weight getWeight() {
        return weight;
    }

    public void setWeight(Enumes.Weight weight) {
        this.weight = weight;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }





    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getSendDate() {
        Converters a = new Converters();
        return a.dateToDatabase(sendDate);
    }

    public void setSendDate(String sendDate) {
        Converters a = new Converters();

        this.sendDate = a.dateFromDatabase(sendDate);
    }

    public String getReciviedDate() {
        Converters a = new Converters();
        return a.dateToDatabase(reciviedDate);
    }

    public void setReciviedDate(String reciviedDate) {
        Converters a = new Converters();

        this.reciviedDate = a.dateFromDatabase(reciviedDate);
    }



    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }
}
