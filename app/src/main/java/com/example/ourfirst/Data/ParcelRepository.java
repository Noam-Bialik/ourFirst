package com.example.ourfirst.Data;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.ourfirst.Data.HistoryParcelRoom.HistoryDataSource;
import com.example.ourfirst.Data.HistoryParcelRoom.HistoryDataSourceDAO;
import com.example.ourfirst.Entities.Parcel;
import com.example.ourfirst.Utils.General;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ParcelRepository {

    private String warehouseId = "0";
    private static  ParcelRepository ourInstance;
    private HistoryDataSource historyDataSource;
    private HistoryDataSourceDAO historyDataSourceDAO;
    private MutableLiveData<ArrayList<Parcel>>parcels = new MutableLiveData<ArrayList<Parcel>>();

    HistoryParcelsFirebase historyParcelsFirebase;

    public void setWarehouseId(String id){
        HistoryParcelsFirebase.setID(id);
        warehouseId = id;
    }

    public ParcelRepository(Application application) {

        historyDataSource = HistoryDataSource.getInstance(application.getApplicationContext());
        historyDataSourceDAO = historyDataSource.historyDataSourceDAO();
        //parcels = new MutableLiveData<ArrayList<Parcel>>();
        ArrayList<Parcel> list = (ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat();
        if(list == null)
            list = new ArrayList<>();
        parcels.setValue(list);

        //List<Parcel> help = historyDataSourceDAO.getAllParcelsThat();
        //parcels.postValue((ArrayList<Parcel>) help);
        historyParcelsFirebase=HistoryParcelsFirebase.getInstance();
        HistoryParcelsFirebase.setID(warehouseId);
        HistoryParcelsFirebase.notifyToParcelList(new HistoryParcelsFirebase.CallBacks() {
            @Override
            public void parcelAdded(Parcel parcel) {
                if (parcels.getValue().size()<=historyParcelsFirebase.getMaxParcelIDFromFirebase())
                addParcelToParcelsArrayList(parcel);
//                historyDataSourceDAO.addParcel(parcel);
                // parcels.postValue((ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat());
            }

            @Override
            public void parcelRemoved(Parcel parcel) {
                historyDataSourceDAO.removeParcel(historyDataSourceDAO.queryRemove(parcel.getID()));
                parcels.postValue((ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat());
                removeParcelFromParcelsArrayList(parcel);
            }

            @Override
            public void parcelChanged(Parcel parcel) {
                historyDataSourceDAO.removeParcel(historyDataSourceDAO.queryRemove(parcel.getID()));
                historyDataSourceDAO.addParcel(parcel);
                parcels.postValue((ArrayList<Parcel>) historyDataSourceDAO.getAllParcelsThat());
                changeParcelInParcelsArrayList(parcel);
            }

            @Override
            public void notify(String str) {
                if (str!="")
                {

                }
            }
        });

    }

    public static ParcelRepository getInstance(Application application) {
        if (ourInstance==null)
            ourInstance=new ParcelRepository(application);
        return ourInstance;
    }

    //send to the firebase and in the firebase it will get unique id.
    public void addParcel(final Parcel parcel) throws Exception
    {
            historyParcelsFirebase.addParcelToFirebase(parcel);
           getSuccess();
    }
    public MutableLiveData<Boolean>getSuccess()
    {
        return historyParcelsFirebase.getSuccess();
    }
    public MutableLiveData<ArrayList<Parcel>> getAllParcelsThat()
    {
        return parcels;
    }


    private boolean addParcelToParcelsArrayList(Parcel parcel){
        try{
            ArrayList<Parcel> list = parcels.getValue();
            if(list == null)
                list = new ArrayList<>();
            list.add(parcel);
            parcels.setValue(list);//Dont now wy but working!!!!!!!!!!!
          //  parcels.postValue(list);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    private boolean removeParcelFromParcelsArrayList(Parcel parcel){
        try{
            ArrayList<Parcel> list = parcels.getValue();
            if(list == null)
                list = new ArrayList<>();
            else
                 list.remove(General.findIndexInParcels(list,parcel.getID()));
            parcels.postValue(list);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    private boolean changeParcelInParcelsArrayList(Parcel parcel){
        try{

            ArrayList<Parcel> list = parcels.getValue();
            if(list == null) {
                list = new ArrayList();
                throw new Exception("Parcels empty");
            }
            else
                list.remove(General.findIndexInParcels(list,parcel.getID()));
                list.add(parcel);
            parcels.postValue(list);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void addParcelToRoom(Parcel parcel)
    {
        historyDataSourceDAO.addParcel(parcel);
    }
}
