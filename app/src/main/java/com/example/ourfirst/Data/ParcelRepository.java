package com.example.ourfirst.Data;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.ourfirst.Data.HistoryDataSource.HistoryDataSource;
import com.example.ourfirst.Data.HistoryDataSource.HistoryDataSourceDAO;
import com.example.ourfirst.Entities.Parcel;

import java.util.List;

public class ParcelRepository {

    private HistoryDataSource historyDataSource;
    private HistoryDataSourceDAO historyDataSourceDAO;
    private MutableLiveData<List<Parcel>> parcels;

    public ParcelRepository(Application application) {
        historyDataSource = Room.databaseBuilder(application, HistoryDataSource.class, "some name").allowMainThreadQueries().build();
        historyDataSourceDAO = historyDataSource.historyDataSourceDAO();
        historyDataSource = Room.databaseBuilder(application.getApplicationContext(), HistoryDataSource.class, "Parcels").build();
        parcels=new MutableLiveData<List<Parcel>>();
    }

    public void addParcel(Parcel parcel) {
        historyDataSourceDAO.addParcel(parcel);
    }

    public MutableLiveData<List<Parcel>> getAllParcelsThat() {
        parcels.getValue();
        return parcels;
    }
}
/*
    private static class AddParcelAsyncTask extends AsyncTask<Parcel,Void ,Void>
    {
        private HistoryDataSourceDAO historyDataSourceDAO;
        private AddParcelAsyncTask(HistoryDataSourceDAO historyDataSourceDAO)
        {
            this.historyDataSourceDAO=historyDataSourceDAO;
        }
        @Override
        protected Void doInBackground(Parcel... parcels) {
            historyDataSourceDAO.addParcel(parcels[0]);
            return null;
        }
    }
    public void addParcel(Parcel parcel)
    {
        new AddParcelAsyncTask(historyDataSourceDAO).execute(parcel);
    }
    public LiveData<List<Parcel>> getAllRecivedParcels()
    {
        return allRecivedParcel;
    }
}*/


