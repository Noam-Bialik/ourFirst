package com.example.ourfirst.UI.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ourfirst.R;

public class MainActivity extends Activity {

    static final String mypreference = "";
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

        if (sharedpreferences.getString("Location", "")!=""&&sharedpreferences.getString("ID", "")!="") {

            Intent intent=new Intent(this, PostMainActivity.class);
            intent.putExtra("WarehouseLocation",sharedpreferences.getString("Location", ""));
            intent.putExtra("WarehouseID",sharedpreferences.getString("ID", ""));
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Warehouse Data saved successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void Store(View view)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Location", location.getText().toString());
        editor.putString("ID", id.getText().toString());
        editor.commit();

        Intent intent=new Intent(this, PostMainActivity.class);
        intent.putExtra("WarehouseLocation",sharedpreferences.getString("Location", ""));
        intent.putExtra("WarehouseID",sharedpreferences.getString("ID", ""));
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Warehouse data saved", Toast.LENGTH_SHORT).show();
    }
}