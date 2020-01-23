package com.example.ourfirst.UI.AddParcel;

import android.Manifest;
import android.os.Bundle;
import android.os.Parcel;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;

import com.example.ourfirst.R;

public class AddParcelActivity extends AppCompatActivity {
    AddParcelViewModel addParcelViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);

    }
    public void Add(View view) {
        int parcelType;
        int breakable;
        int weight ;
        String toName;
        String toLocation;
        final String toPhoneNumber;
        String toMail;
        try {
            parcelType = ((RadioGroup) findViewById(R.id.ParcelType)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.ParcelType)).getCheckedRadioButtonId()));
            breakable = ((RadioGroup) findViewById(R.id.Breakable)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Breakable)).getCheckedRadioButtonId()));
            weight = ((RadioGroup) findViewById(R.id.Weight)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Weight)).getCheckedRadioButtonId()));
            toName = ((EditText) findViewById(R.id.ToName)).getText().toString();
            toLocation = ((EditText) findViewById(R.id.ToLocation)).getText().toString();
            toPhoneNumber = ((EditText) findViewById(R.id.PhoneNumber)).getText().toString();
            toMail = ((EditText) findViewById(R.id.ToMail)).getText().toString();

            final String storageLocation = getIntent().getStringExtra("WarehouseLocation");
            final String idStorage = getIntent().getStringExtra("WarehouseID");
            addParcelViewModel=new AddParcelViewModel(getApplication());
            //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
            //SmsManager smgr = SmsManager.getDefault();
            //smgr.sendTextMessage(toPhoneNumber,null,"Hello customer, your package has arrived at the warehouse",null,null);
            addParcelViewModel.verifyData(idStorage, parcelType, breakable, weight, storageLocation, toName, toLocation, toPhoneNumber, toMail);
            addParcelViewModel.getSuccess()
                    .observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if(aBoolean)
                            {
                            Toast.makeText(getApplicationContext(), "Add parcel successfuly", Toast.LENGTH_SHORT).show();
                            addParcelViewModel.addParcelToRoom();
                            SmsManager smgr = SmsManager.getDefault();
                            smgr.sendTextMessage(toPhoneNumber,"The Warehouse","Hello customer, your package has arrived at the warehouse",null,null);
                            finish();
                                    Toast.makeText(AddParcelActivity.this,"Parcel added successfully", Toast.LENGTH_SHORT).show();


                            }
                            //else Toast.makeText(AddParcelActivity.this,"Parcel added not successfully", Toast.LENGTH_SHORT).show();
                        }
                    });

        }
        catch (Exception e)
        {
            Toast.makeText(AddParcelActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
