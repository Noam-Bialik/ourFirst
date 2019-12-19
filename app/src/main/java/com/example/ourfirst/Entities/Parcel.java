package com.example.ourfirst.Entities;

import android.location.Location;

import java.util.Date;

public class Parcel {
    private String ID ;
    private Enumes.ParcelType parcelType;
    private Boolean breakable;
    private Enumes.Weight weight;
    private String storageLocation;
    private String toName;
    private Location toLocation;
    private String toPhoneNumber;
    private String toMail;
    private Date sendDate;
    private Date reciviedData;
    private Enumes.ParcelStatus parcelStatus;
    private String deliverName;
    public Parcel(){};
    public Parcel(Enumes.ParcelType parcelType, Boolean breakable, Enumes.Weight weight, String storageLocation, String toName, Location toLocation, String toPhoneNumber, String toMail, Date sendDate, Date reciviedData, Enumes.ParcelStatus parcelStatus, String deliverName) {
        this.ID = null;
        this.parcelType = parcelType;
        this.breakable = breakable;
        this.weight = weight;
        this.storageLocation = storageLocation;
        this.toName = toName;
        this.toLocation = toLocation;
        this.toPhoneNumber = toPhoneNumber;
        this.toMail = toMail;
        this.sendDate = sendDate;
        this.reciviedData = reciviedData;
        this.parcelStatus = parcelStatus;
        this.deliverName = deliverName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReciviedData() {
        return reciviedData;
    }

    public void setReciviedData(Date reciviedData) {
        this.reciviedData = reciviedData;
    }

    public Enumes.ParcelStatus getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(Enumes.ParcelStatus parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }
}
