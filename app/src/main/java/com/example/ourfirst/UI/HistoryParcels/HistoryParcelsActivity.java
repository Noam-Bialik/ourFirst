package com.example.ourfirst.UI.HistoryParcels;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.example.ourfirst.Data.ParcelRepository;
import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.R;
import com.example.ourfirst.Utils.Converters;
import com.example.ourfirst.Utils.ItemArrayAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HistoryParcelsActivity extends AppCompatActivity {

    ArrayList<String> allParcelsThat = new ArrayList<>();
    HistoryParcelsViewModel historyParcelsViewModel;
    Converters converters=new Converters();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_parcels_activity);
        historyParcelsViewModel=new HistoryParcelsViewModel(getApplication());


        historyParcelsViewModel.getAllParcelsThat().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(final List<Parcel> parcelList) {
                allParcelsThat.clear();
                for (Parcel item : parcelList) {
                    allParcelsThat.add("" + (item.getID()));
                }
                ListView parcelsList=(ListView) findViewById(R.id.ParcelsList);
                ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(getApplication(), R.layout.list_item, allParcelsThat);
                parcelsList.setAdapter(itemArrayAdapter);
                parcelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        onParcelClick(parcelList.get(position));
                    }
                });
            }
        });

    }

    public void onParcelClick(Parcel parcel)
    {
        Calendar cal = Calendar.getInstance();
        AlertDialog alertDialog = new AlertDialog.Builder(HistoryParcelsActivity.this).create();
        alertDialog.setTitle("ditels of parcel");
        String str="ID: "+parcel.getID() +
                "\nWarehouseID: "+parcel.getWarehouseID()+
                "\nWarehouseLocation: "+parcel.getWarehouseLocation()+
                "\nParcelType: "+parcel.getParcelType().toString()+"" +
                "\nBreakable: "+parcel.getBreakable().toString()+
                "\nWeight: "+parcel.getWeight().toString()+
                "\nParcelStatus: "+parcel.getParcelStatus()+
                "\nReciviedDate: "+parcel.getReciviedDate().format(cal.getTime())+
                "\nSendDate: "+parcel.getSendDate().format(cal.getTime())+
                "\nToLocation: "+converters.locationToDatabase(parcel.getToLocation())+
                "\nTomail: "+parcel.getToMail()+
                "\nToname: "+parcel.getToName()+
                "\nTophoneNumber: "+parcel.getToPhoneNumber()+
                "\nDeliverName: "+parcel.getDeliverName();
        alertDialog.setMessage(str);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }
}
