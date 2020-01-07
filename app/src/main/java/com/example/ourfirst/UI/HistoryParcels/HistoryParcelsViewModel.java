package com.example.ourfirst.UI.HistoryParcels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Parcel;

import java.util.ArrayList;


public class HistoryParcelsViewModel extends AndroidViewModel
{
    ParcelRepository parcelRepository=ParcelRepository.getInstance(getApplication());

    public HistoryParcelsViewModel(Application application)
    {
        super(application);
    }
    public MutableLiveData<ArrayList<Parcel>> getAllParcelsThat()
    {
       return parcelRepository.getAllParcelsThat();
    }
}
