package com.example.ourfirst.UI.Main;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.R;
import com.example.ourfirst.UI.Main.PostMainActivity;

public class MainActivity extends Activity {
    public static final String mypreference = "";
    SharedPreferences sharedpreferences;
    EditText location;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        location = (EditText) findViewById(R.id.warehouseLocation);
        id = (EditText) findViewById(R.id.warehouseID);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.getString("WarehouseLocation", "")!=""&&sharedpreferences.getString("WarehouseID", "")!="") {
            Intent intent=new Intent(this, PostMainActivity.class);
            intent.putExtra("WarehouseLocation",sharedpreferences.getString("WarehouseLocation", ""));
            intent.putExtra("WarehouseID",sharedpreferences.getString("ID", ""));
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Warehouse Data saved successfully", Toast.LENGTH_SHORT).show();
        }



    }

    //@Override
    protected void onStart()
    {
        super.onStart();
        if (sharedpreferences.getString("WarehouseLocation", "")!=""&&sharedpreferences.getString("WarehouseID", "")!="") {
            location.setText(sharedpreferences.getString("WarehouseLocation", ""));
            id.setText(sharedpreferences.getString("WarehouseID", ""));




        }
    }

    public void Store(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("WarehouseLocation", location.getText().toString());
        editor.putString("WarehouseID", id.getText().toString());
        editor.commit();
        Intent intent=new Intent(this, PostMainActivity.class);
        intent.putExtra("WarehouseLocation",sharedpreferences.getString("WarehouseLocation", ""));
        intent.putExtra("WarehouseID",sharedpreferences.getString("WarehouseID", ""));
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Warehouse data saved", Toast.LENGTH_SHORT).show();



    }
}