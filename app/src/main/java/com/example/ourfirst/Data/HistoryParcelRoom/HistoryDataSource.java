package com.example.ourfirst.Data.HistoryParcelRoom;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.Utils.Converters;


@Database(entities = {Parcel.class},version = 1)
@TypeConverters({Converters.class})
public abstract class HistoryDataSource extends RoomDatabase {
    private static HistoryDataSource instance;

    public abstract HistoryDataSourceDAO historyDataSourceDAO();

    public static synchronized HistoryDataSource getInstance(Context context) {
        if (instance == null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),HistoryDataSource.class,"HistoryDataSource").allowMainThreadQueries().build();
        }
        return instance;
    }
}