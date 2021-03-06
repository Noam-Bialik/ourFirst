package com.example.ourfirst.UI.AddParcel;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.telephony.SmsManager;
import android.widget.Toast;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Enumes;
import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.Utils.GPService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddParcelViewModel extends AndroidViewModel {
    Context context;
    ParcelRepository parcelRepository;
    static Parcel parcel;
    public AddParcelViewModel(Application application) {
        super(application);
        context=application.getApplicationContext();
        parcelRepository=ParcelRepository.getInstance(getApplication());
    }

    public void verifyData(String warehouseID, int parcelType, int breakable, int weight, String warehouseLocation, String toName, String toLocation, String toPhoneNumber, String toMail) throws Exception {
        parcel = new Parcel();
        Date dateNow = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        dt1.set2DigitYearStart(dateNow);
        parcel.setReciviedDate(dt1);
        parcel.setSendDate(dt1);
        parcel.setWarehouseID(warehouseID);
        parcel.setWarehouseLocation(warehouseLocation);
        parcel.setDeliverName("");

        parcel.setParcelStatus(Enumes.ParcelStatus.WAITING);
        if (parcelType == 0 || parcelType == 1 || parcelType == 2) {
            parcel.setParcelType(Enumes.ParcelType.values()[parcelType]);
        } else throw new Exception("The parcelType is not correct");
        if (breakable == 0 || breakable == 1) {
            parcel.setBreakable(breakable == 1);
        } else throw new Exception("The breakable is not correct");
        if (weight == 0 || weight == 1 || weight == 2 || weight == 3) {
            parcel.setWeight(Enumes.Weight.values()[weight]);
        } else throw new Exception("The weight is not correct");
        if (toName.length()>1) {
            parcel.setToName(toName);
        }
        else throw new Exception("The toName is not correct most more one char");

        if (toMail.length()>1) {
            parcel.setToMail(toMail);
            //we verify main her
        }
        else throw new Exception("The toMail is not correct");

        if (toPhoneNumber.length()>1) {
            parcel.setToPhoneNumber(toPhoneNumber);
             }
        else throw new Exception("The toPhoneNumber is not correct");


        try
        {
            Location location=GPService.getLocationFromAddress(toLocation, context);
            parcel.setToLocation(location);
        }
        catch (Exception e) {
            throw new Exception("The location is not correct or your offline");
        }
        parcelRepository.addParcel(parcel);
    }
    public void addParcelToRoom()
    {
        parcelRepository.addParcelToRoom(parcel);
    }
    public MutableLiveData<Boolean>getSuccess()
    {
        return parcelRepository.getSuccess();
    }
}