package com.example.ourfirst.UI.AddParcel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
        String toPhoneNumber;
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
            addParcelViewModel.verifyData(idStorage, parcelType, breakable, weight, storageLocation, toName, toLocation, toPhoneNumber, toMail);
            Toast.makeText(AddParcelActivity.this,"Parcel added successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(AddParcelActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
