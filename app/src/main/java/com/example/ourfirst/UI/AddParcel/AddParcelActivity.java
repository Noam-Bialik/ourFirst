package com.example.ourfirst.UI.AddParcel;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfirst.R;
import com.example.ourfirst.UI.MainActivity;

public class AddParcelActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_parcel_activity);
        Button Back =(Button)findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
        Button finishAdd=(Button)findViewById(R.id.finishAdd);
        finishAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {


                    Toast.makeText(getBaseContext(),"the parcel is added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void goBack()
    {
        startActivity(new Intent(this, MainActivity.class));
    }

}
