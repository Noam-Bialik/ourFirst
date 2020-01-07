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
    static int ID=0;
    ArrayList<String> allParcelsThat = new ArrayList<>();
    ParcelRepository parcelRepository;
    Converters converters=new Converters();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_parcels_activity);
        parcelRepository=ParcelRepository.getInstance(getApplication());

/*        final ArrayList<Parcel> a=parcelRepository.getAllParcelsThat().getValue();
        if (a!=null) {
            for (Parcel item : a) {
                allParcelsThat.add("" + (item.getID()));
            }
        }
        ListView parcelsList=(ListView) findViewById(R.id.ParcelsList);
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(getApplication(), R.layout.list_item, allParcelsThat);
        parcelsList.setAdapter(itemArrayAdapter);
        parcelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onParcelClick(a.get(position));
            }
        });*/


        parcelRepository.getAllParcelsThat().observe(this, new Observer<List<Parcel>>() {
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
                "\nidstorage: "+parcel.getIdStorage()+
                "\nstorageLocation: "+parcel.getStorageLocation()+
                "\nparcelType: "+parcel.getParcelType().toString()+"" +
                "\nbreakable: "+parcel.getBreakable().toString()+
                "\nweight: "+parcel.getWeight().toString()+
                "\nparcelStatus: "+parcel.getParcelStatus()+
                "\nreciviedDate: "+parcel.getReciviedDate().format(cal.getTime())+
                "\nsendDate: "+parcel.getSendDate().format(cal.getTime())+
                "\ntoLocation: "+converters.locationToDatabase(parcel.getToLocation())+
                "\ntomail: "+parcel.getToMail()+
                "\ntoname: "+parcel.getToName()+
                "\nTophoneNumber: "+parcel.getToPhoneNumber()+
                "\ndeliverName: "+parcel.getDeliverName();
        alertDialog.setMessage(str);
//E"ברוכין","nave",GPService.getLocationFromAddress("הועד הלאומי 21",getApplicationContext()),"0528616878","navesarussi@gmail.com",date,date, Enumes.ParcelStatus.WAITING,"","1"Enumes.ParcelType.SMALLPKJ,true, Enumes.Weight.U500G,"ברוכין","nave",GPService.getLocationFromAddress("הועד הלאומי 21",getApplicationContext()),"0528616878","navesarussi@gmail.com",date,date, Enumes.ParcelStatus.WAITING,"","1"
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });

        alertDialog.show();
    }
    /*public void Add(View view) {
        try {
            parcelRepository=ParcelRepository.getInstance(getApplication());
            Date d=new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            date.set2DigitYearStart(d);
            //Parcel parcel = new Parcel("nave", "045",dt1,Enumes.Weight.U20KG,GPService.getLocationFromAddress("הועד הלאומי 21",getApplicationContext()));
            Parcel parcel = new Parcel(Enumes.ParcelType.SMALLPKJ,true, Enumes.Weight.U500G,"ברוכין","nave",GPService.getLocationFromAddress("הועד הלאומי 21",getApplicationContext()),"0528616878","navesarussi@gmail.com",date,date, Enumes.ParcelStatus.WAITING,"","1");
            parcelRepository.addParcel(parcel);
        }
        catch (Exception e)
        {
            Log.i("EXE",e.getMessage());
        }
    }*/
}
