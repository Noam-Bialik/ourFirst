package com.example.ourfirst.Data.HistoryParcelRoom;

import androidx.room.Dao;
import androidx.room.Delete;
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

    @Delete
    void removeParcel(Parcel parcel);

    @Query("SELECT * FROM parcels")
    List<Parcel> getAllParcelsThat();

    @Query("SELECT * FROM parcels WHERE ID=:id")
    Parcel queryRemove(int id);
}
