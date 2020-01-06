package com.example.ourfirst.Utils;

import android.location.Location;

import androidx.room.TypeConverter;


import com.example.ourfirst.Entities.Enumes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Converters {
    @TypeConverter
    public SimpleDateFormat dateFromDatabase(String date) {
        return date == null ? null : new SimpleDateFormat(date);
    }

    @TypeConverter
    public String dateToDatabase(SimpleDateFormat date) {
        return date == null ? null : date.toString();
    }

    @TypeConverter
    public String parcelStatusToDatabase(Enumes.ParcelStatus parcelStatus) {
        return parcelStatus == null ? null : parcelStatus.toString();
    }

    @TypeConverter
    public String parcelTypeToDatabase(Enumes.ParcelType parcelType) {
        return parcelType == null ? null : parcelType.toString();
    }

    @TypeConverter
    public String weightToDatabase(Enumes.Weight weight) {
        return weight == null ? null : weight.toString();
    }

    @TypeConverter
    public Enumes.ParcelStatus parcelStatusFromDatabase(String parcelStatus) {
        return parcelStatus == null ? null : Enumes.ParcelStatus.valueOf(parcelStatus);
    }

    @TypeConverter
    public Enumes.ParcelType parcelTypeFromDatabase(String parcelType) {
        return parcelType == null ? null : Enumes.ParcelType.valueOf(parcelType);
    }

    @TypeConverter
    public Enumes.Weight weightFromDatabase(String weight) {
        return weight == null ? null : Enumes.Weight.valueOf(weight);
    }

    @TypeConverter
    public String locationToDatabase(Location location) {
        if (location==null)
            return null;
        String str;
        str=Location.convert(location.getLatitude(),1)+Location.convert(location.getLongitude(),1);
        return str;
    }

    @TypeConverter
    public Location locationFromDatabase(String location) {
       if (location==null)
           return null;

       double s1=Double.parseDouble(location.substring(0,location.length()/2));
       double s2=Double.parseDouble(location.substring(location.length()/2,location.length()));
       Location location1=new Location("location");
       location1.setLatitude(s1);
       location1.setLongitude(s2);
       return location1;
    }
}