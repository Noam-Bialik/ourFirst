package com.example.ourfirst.Entities;

import android.location.Location;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;

@Entity(tableName = "Parcels")
public class Parcel {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ID;
    private Enumes.ParcelType parcelType;
    private Boolean breakable;
    private Enumes.Weight weight;
    private String storageLocation;
    private String toName;
    private Location toLocation;
    private String toPhoneNumber;
    private String toMail;
    private SimpleDateFormat sendDate;

    private SimpleDateFormat reciviedDate;
    private Enumes.ParcelStatus parcelStatus;
    private String deliverName;
    private String idStorage;

    public Parcel() {
    }

    public Parcel(Enumes.ParcelType parcelType, Boolean breakable, Enumes.Weight weight, String storageLocation, String toName, Location toLocation, String toPhoneNumber, String toMail, SimpleDateFormat sendDate, SimpleDateFormat reciviedDate, Enumes.ParcelStatus parcelStatus, String deliverName, String idStorage) {
        this.parcelType = parcelType;
        this.breakable = breakable;
        this.weight = weight;
        this.storageLocation = storageLocation;
        this.toName = toName;
        this.toLocation = toLocation;
        this.toPhoneNumber = toPhoneNumber;
        this.toMail = toMail;
        this.sendDate = sendDate;
        this.reciviedDate = reciviedDate;
        this.parcelStatus = parcelStatus;
        this.deliverName = deliverName;
        this.idStorage = idStorage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public SimpleDateFormat getSendDate() {
        return sendDate;
    }

    public void setSendDate(SimpleDateFormat sendDate) {
        this.sendDate = sendDate;
    }

    public SimpleDateFormat getReciviedDate() {
        return reciviedDate;
    }

    public void setReciviedDate(SimpleDateFormat reciviedDate) {
        this.reciviedDate = reciviedDate;
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

    public String getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(String idStorage) {
        this.idStorage = idStorage;
    }
}