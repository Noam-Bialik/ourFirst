package com.example.ourfirst.UI.AddParcel;

import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ourfirst.Entities.Enumes;
import com.example.ourfirst.R;
import com.example.ourfirst.UI.MainActivity;

import java.util.Date;

public class AddParcelActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);
        Button finishAdd=(Button)findViewById(R.id.finishAdd);
        final AddParcelViewModel addParcelviewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(AddParcelViewModel.class);
        finishAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    try{
                    String parcelType=findViewById(R.id.Type).toString();
                    String breakable=findViewById(R.id.Breakable).toString();
                    String weight=findViewById(R.id.Weight).toString();
                    String storageLocation=findViewById(R.id.StorageLocation).toString();
                    String toName=findViewById(R.id.ToName).toString();
                    String toLocation=findViewById(R.id.DdestenationMail).toString();
                    String toPhoneNumber=findViewById(R.id.PhoneNumber).toString();
                    String toMail=findViewById(R.id.DdestenationMail).toString();
                    String sendDate=findViewById(R.id.SendDate).toString();
                    String reciviedData=findViewById(R.id.RecivedDate).toString();
                    String parcelStatus=findViewById(R.id.ParcelStatus).toString();
                    String deliverName=findViewById(R.id.DeliverName).toString();
                    addParcelviewModel.verifyData(parcelType,breakable,weight,storageLocation,toName,toLocation,toPhoneNumber,toMail,sendDate,reciviedData,parcelStatus,deliverName);
                }
                    catch(Exception e)
                    {
                    Toast.makeText(AddParcelActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}