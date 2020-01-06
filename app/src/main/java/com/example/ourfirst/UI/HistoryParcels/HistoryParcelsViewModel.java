package com.example.ourfirst.UI.HistoryParcels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Parcel;

import java.util.List;


public class HistoryParcelsViewModel extends AndroidViewModel {
    ParcelRepository parcelRepository=new ParcelRepository(getApplication());

    public HistoryParcelsViewModel(Application application) {
        super(application);
    }

    public MutableLiveData<List<Parcel>> getAllParcelsThat()
    {
       return parcelRepository.getAllParcelsThat();
    }
}
