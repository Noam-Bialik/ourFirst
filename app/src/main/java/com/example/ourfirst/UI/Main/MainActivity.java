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
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    EditText location;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location = (EditText) findViewById(R.id.storageLocation);
        id = (EditText) findViewById(R.id.idStorage);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.getString("Location", "")!=""&&sharedpreferences.getString("ID", "")!="") {
            Intent intent=new Intent(this, PostMainActivity.class);
            intent.putExtra("StorageLocation",sharedpreferences.getString("Location", ""));
            intent.putExtra("ID",sharedpreferences.getString("ID", ""));
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Data Storage Stored Successfuly!", Toast.LENGTH_SHORT).show();
        }
    }

    //@Override
    protected void onStart()
    {
        super.onStart();
        if (sharedpreferences.getString("Location", "")!=""&&sharedpreferences.getString("ID", "")!="") {
            location.setText(sharedpreferences.getString("Location", ""));
            id.setText(sharedpreferences.getString("ID", ""));
        }
    }
    public void Store(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Location", location.getText().toString());
        editor.putString("ID", id.getText().toString());
        editor.commit();
        Intent intent=new Intent(this, PostMainActivity.class);
        intent.putExtra("StorageLocation",sharedpreferences.getString("Location", ""));
        intent.putExtra("ID",sharedpreferences.getString("ID", ""));
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Storage data saved", Toast.LENGTH_SHORT).show();
    }
}