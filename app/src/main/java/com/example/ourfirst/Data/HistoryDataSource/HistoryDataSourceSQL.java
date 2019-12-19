package com.example.ourfirst.Data.HistoryDataSource;

import android.location.Location;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.ourfirst.Entities.Enumes;
import java.util.Date;

@Entity(tableName = "Parcels")
public class HistoryDataSourceSQL
{
    @PrimaryKey
    private String ID ;
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
