package com.example.ourfirst.UI.AddParcel;

import android.location.Location;

import androidx.lifecycle.ViewModel;

import com.example.ourfirst.Entities.Enumes;
import com.example.ourfirst.Entities.Parcel;

import java.util.Date;

public class AddParcelViewModel extends ViewModel {
    public void verifyData(String parcelType,String breakable,String weight, String storageLocation, String toName,String toLocation,String toPhoneNumber, String toMail,String sendDate,String reciviedData,String parcelStatus, String deliverName)throws Exception {
        Parcel parcel = new Parcel();
        if (parcelType == "1" || parcelType == "2" || parcelType == "3") {
            parcel.setParcelType(Enumes.ParcelType.values()[Integer.parseInt(parcelType)]);
        }
        else throw new Exception("The parcel type is not correct");




    }
}
