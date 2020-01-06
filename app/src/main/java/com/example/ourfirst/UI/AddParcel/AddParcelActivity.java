package com.example.ourfirst.UI.AddParcel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfirst.R;


public class AddParcelActivity  extends AppCompatActivity {


    private AddParcelViewModel addParcelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);
        Button finishAdd = (Button) findViewById(R.id.finishAdd);
        final String storageLocation=getIntent().getStringExtra("StorageLocation");
        final String idStorage=getIntent().getStringExtra("ID");
        finishAdd.setOnClickListener(new View.OnClickListener() {
          //  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            int parcelType;
            int breakable;
            int weight ;
            String toName;
            String toLocation;
            String toPhoneNumber;
            String toMail;
            @Override
            public void onClick(View v) {
                {
                /*    parcelType = ((RadioGroup) findViewById(R.id.Type)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Type)).getCheckedRadioButtonId()));
                   breakable = ((RadioGroup) findViewById(R.id.Breakable)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Breakable)).getCheckedRadioButtonId()));
                    weight = ((RadioGroup) findViewById(R.id.Weight)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Weight)).getCheckedRadioButtonId()));
                    toName = ((EditText) findViewById(R.id.ToName)).getText().toString();
                    toLocation = ((EditText) findViewById(R.id.DdestenationMail)).getText().toString();
                    toPhoneNumber = ((EditText) findViewById(R.id.PhoneNumber)).getText().toString();
                    toMail = ((EditText) findViewById(R.id.DdestenationMail)).getText().toString();
                    addParcelViewModel=new AddParcelViewModel(getApplication());*/
                    parcelType = 1;
                    breakable = 1;
                    weight = 1;
                    toName = "nave";
                    toLocation = "יפו 6";
                    toPhoneNumber = "0528616878";
                    toMail = "כעכגע";
                    addParcelViewModel=new AddParcelViewModel(getApplication());
                try {
                    addParcelViewModel.verifyData(idStorage, parcelType, breakable, weight, storageLocation, toName, toLocation, toPhoneNumber, toMail);
                    }
                    catch (Exception  e)
                    {
                        Toast.makeText(AddParcelActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}


