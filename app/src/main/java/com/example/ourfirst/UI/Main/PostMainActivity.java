package com.example.ourfirst.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ourfirst.R;
import com.example.ourfirst.UI.AddParcel.AddParcelActivity;
import com.example.ourfirst.UI.HistoryParcels.HistoryParcelsActivity;

public class PostMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);
    }

    public void gotoAddParcel(View view)
    {
        Intent intent=new Intent(this, AddParcelActivity.class);
        intent.putExtra("WarehouseLocation",getIntent().getExtras().getString("Location"));
        intent.putExtra("WarehouseID",getIntent().getExtras().getString("ID"));
        startActivity(intent);
    }
    public void gotoHistoryParcel(View view)
    {
        startActivity(new Intent(this, HistoryParcelsActivity.class));
    }
}