package com.example.ourfirst.UI.Main;

import android.Manifest;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.R;
import com.example.ourfirst.UI.AddParcel.AddParcelActivity;
import com.example.ourfirst.UI.HistoryParcels.HistoryParcelsActivity;

public class PostMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);




    }

    public void gotoAddParcel(View view)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {


            Intent intent = new Intent(this, AddParcelActivity.class);
            intent.putExtra("WarehouseLocation", getIntent().getExtras().getString("WarehouseLocation"));
            intent.putExtra("WarehouseID", getIntent().getExtras().getString("WarehouseID"));
            startActivity(intent);
        }
        else Toast.makeText(PostMainActivity.this,"You are offline", Toast.LENGTH_SHORT).show();

    }
    public void gotoHistoryParcel(View view)
    {
        startActivity(new Intent(this, HistoryParcelsActivity.class));
    }
}