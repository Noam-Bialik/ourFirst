package com.example.ourfirst.UI.AddParcel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Enumes;
import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.Utils.GPService;
import java.util.Date;
import java.util.List;

public class AddParcelViewModel extends AndroidViewModel {
    static int ID = 0;
    Context context;
    ParcelRepository parcelRepository;

    public AddParcelViewModel(Application application) {
        super(application);
        context=application.getApplicationContext();
        parcelRepository=new ParcelRepository(application);
    }

    public void verifyData(String idStorage, int parcelType, int breakable, int weight, String storageLocation, String toName, String toLocation, String toPhoneNumber, String toMail) throws Exception {
        Parcel parcel = new Parcel();
        Date dateNow = new Date();
        parcel.setReciviedDate(dateNow.toString());
        parcel.setIdStorage(idStorage);
        parcel.setStorageLocation(storageLocation);
        parcel.setID(ID++);

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
            //we verify main her
        }
        else throw new Exception("The toPhoneNumber is not correct");


        try
        {
            parcel.setToLocation(GPService.getLocationFromAddress(toLocation, context));
            //need check;
        }
        catch (Exception e) {
            throw new Exception("The location is not correct");
        }
        parcelRepository.addParcel(parcel);
        Toast.makeText(context, "Add parcel successfuly", Toast.LENGTH_SHORT).show();
    }


    public MutableLiveData<List<Parcel>> getAllParcelsThat() {
        return parcelRepository.getAllParcelsThat();
    }
}