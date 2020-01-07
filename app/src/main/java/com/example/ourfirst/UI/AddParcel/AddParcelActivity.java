package com.example.ourfirst.UI.AddParcel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Enumes;
import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.R;
import com.example.ourfirst.Utils.GPService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddParcelActivity extends AppCompatActivity {
    ParcelRepository parcelRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel2);

    }
    public void Add(View view) {
        try {
            final String storageLocation = getIntent().getStringExtra("StorageLocation");
            final String idStorage = getIntent().getStringExtra("ID");
            parcelRepository= ParcelRepository.getInstance(getApplication());
            Date d=new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            date.set2DigitYearStart(d);
            Parcel parcel = new Parcel(Enumes.ParcelType.SMALLPKJ,true, Enumes.Weight.U500G,storageLocation,"nave", GPService.getLocationFromAddress("הועד הלאומי 21",getApplicationContext()),"0528616878","navesarussi@gmail.com",date,date, Enumes.ParcelStatus.WAITING,"",idStorage);
            parcelRepository.addParcel(parcel);
            Toast.makeText(AddParcelActivity.this,"Parcel added successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Log.i("EXE",e.getMessage());
        }
    }
}
