package com.example.ourfirst.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfirst.R;
import com.example.ourfirst.UI.AddParcel.AddParcelActivity;
import com.example.ourfirst.UI.HistoryParcel.HistoryParcelsActivity;

public class MainActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final Button addParcel = (Button) findViewById(R.id.AddParcel);
        Button historyParcel = (Button) findViewById(R.id.HistoryParcel);
        addParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddParcel();
            }
        });
        historyParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHistoryParcel();
            }
        });
    }
    public void gotoAddParcel()
        {
            startActivity(new Intent(this, AddParcelActivity.class));
        }
    public void gotoHistoryParcel()
        {
            startActivity(new Intent(this,HistoryParcelsActivity.class));
        }
}
