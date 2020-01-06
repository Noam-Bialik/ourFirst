package com.example.ourfirst.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfirst.R;
import com.example.ourfirst.UI.AddParcel.AddParcelActivity;
import com.example.ourfirst.UI.HistoryParcels.HistoryParcelsActivity;

public class PostMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);

        Button addParcel = (Button) findViewById(R.id.AddParcel);
        addParcel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddParcel();
            }
        });

        Button historyParcels = (Button) findViewById(R.id.HistoryParcel);
        historyParcels.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHistoryParcel();
            }
        });
    }


    private void gotoAddParcel()
    {
        Intent intent=new Intent(this, AddParcelActivity.class);
        intent.putExtra("StorageLocation",getIntent().getExtras().getString("StorageLocation"));
        intent.putExtra("ID",getIntent().getExtras().getString("ID"));
        startActivity(intent);
    }
    private void gotoHistoryParcel()
    {
        startActivity(new Intent(this, HistoryParcelsActivity.class));
    }
}