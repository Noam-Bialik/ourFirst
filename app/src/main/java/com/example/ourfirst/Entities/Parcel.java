package com.example.ourfirst.Entities;

import android.location.Location;

import java.util.Date;

public class Parcel {
    private Enumes.ParcelType parcelType;
    private boolean breakable;
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

}
