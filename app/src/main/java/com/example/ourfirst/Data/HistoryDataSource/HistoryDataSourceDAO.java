package com.example.ourfirst.Data.HistoryDataSource;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ourfirst.Entities.Parcel;

import java.util.List;

@Dao
public interface HistoryDataSourceDAO {
    @Insert
    void addParcel(Parcel parcel);

    @Update
     void updateParccel(Parcel parcel);

    @Query("SELECT * FROM parcels WHERE parcelStatus=:Situation ")
    List<Parcel> getAllParcelsThat(String Situation);

}
