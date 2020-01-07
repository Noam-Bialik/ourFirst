package com.example.ourfirst.Data;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.ourfirst.Data.HistoryParcelRoom.HistoryDataSource;
import com.example.ourfirst.Data.HistoryParcelRoom.HistoryDataSourceDAO;
import com.example.ourfirst.Entities.Parcel;
import java.util.ArrayList;

public class ParcelRepository {
    private static  ParcelRepository ourInstance;

    private HistoryDataSource historyDataSource;
    private HistoryDataSourceDAO historyDataSourceDAO;
    private MutableLiveData<ArrayList<Parcel>> parcels;

   public static ParcelRepository getInstance(Application application) {
        if (ourInstance==null)
        ourInstance=new ParcelRepository(application);
      return ourInstance;
    }

    public ParcelRepository(Application application) {
        historyDataSource = HistoryDataSource.getInstance(application.getApplicationContext());
        historyDataSourceDAO = historyDataSource.historyDataSourceDAO();
        parcels = new MutableLiveData<ArrayList<Parcel>>();
    }

    public void addParcel(Parcel parcel) {
        historyDataSourceDAO.addParcel(parcel);
        parcels.postValue((ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat());
    }




    public MutableLiveData<ArrayList<Parcel>> getAllParcelsThat() {
        parcels.postValue((ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat());
        return parcels;
    }
}



