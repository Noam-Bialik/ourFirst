package com.example.ourfirst.UI.HistoryParcels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.R;
import com.example.ourfirst.Utils.ItemArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class HistoryParcelsActivity extends AppCompatActivity {
    ArrayList<String> allParcelsThat = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("EXE","FDGDFG");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcels);
        HistoryParcelsViewModel historyViewModel;
        ListView parcelsList;
        historyViewModel=new HistoryParcelsViewModel(getApplication());
       historyViewModel.getAllParcelsThat().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcelList) {
                for (Parcel item : parcelList) {
                    allParcelsThat.add("" + (item.getID()));
                }
            }
        });
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this, R.layout.list_item, allParcelsThat);
        parcelsList = (ListView) findViewById(R.id.ParcelsList);
        parcelsList.setAdapter(itemArrayAdapter);
        parcelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),allParcelsThat.get(position), Toast.LENGTH_SHORT).show();
                //we can show deteils parcel
            }
        });


    }
}
