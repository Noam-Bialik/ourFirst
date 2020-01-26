package com.example.ourfirst.Data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.ourfirst.Entities.FireParcel;
import com.example.ourfirst.Entities.Parcel;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class HistoryParcelsFirebase {

    private static DatabaseReference parcelsRef = FirebaseDatabase.getInstance().getReference("Parcels");
    private static DatabaseReference maxParcelIDIDRef = FirebaseDatabase.getInstance().getReference("maxParcelID");
    private static String ID = "";
    private static int maxParcelID = 0;
    static MutableLiveData<Boolean> success =new MutableLiveData<Boolean>();
    private static boolean upDateing=false;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        HistoryParcelsFirebase.ID = ID;
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("warehouses").setValue(ID+" connected");
    }

    //setters & getters
    public static DatabaseReference getParcelsRef() {
        return parcelsRef;
    }
    public static void setParcelsRef(DatabaseReference parcelsRef) {
        HistoryParcelsFirebase.parcelsRef = parcelsRef;
    }


    public void addParcelToFirebase(final Parcel parcel) throws Exception {
        if(upDateing) {
            if (parcel.getID() <= maxParcelID) {
                maxParcelID = maxParcelID + 1;
                parcel.setID(maxParcelID);
            }
            //success.postValue(false);
            maxParcelIDIDRef.setValue(maxParcelID).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    FireParcel a = new FireParcel(parcel);

                    parcelsRef.child(String.valueOf(parcel.getID())).setValue(a).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            success.postValue(true);
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            success.postValue(false);
                        }
                    }).addOnCanceledListener(new OnCanceledListener() {
                        @Override
                        public void onCanceled() {
                            success.postValue(false);
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            success.postValue(true);
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    success.setValue(false);
                }
            });
        }
        else throw new Exception("מסתנכרן אנא המתינו כמה דקות");
    }

    public static void notifyToParcelList(final CallBacks callBacks ){
        parcelsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try{
                    FireParcel parcel = dataSnapshot.getValue(FireParcel.class);
                    if(ID.equals(parcel.getWarehouseID())){
                        Parcel help = new Parcel(parcel);
                        callBacks.parcelAdded(help);
                    }

                    Log.i("eee","com/example/ourfirst/Data/HistoryParcelsFirebase.java :ffjfjfjfjfjfj");
                }catch(Exception e){
                    callBacks.notify(e.getMessage());
                }}

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {
                    FireParcel parcel = dataSnapshot.getValue(FireParcel.class);
                    if(ID.equals(parcel.getWarehouseID()))
                        callBacks.parcelChanged(new Parcel(parcel));
                }catch(Exception e){ callBacks.notify(e.getMessage()); } }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                try {
                    FireParcel parcel = dataSnapshot.getValue(FireParcel.class);
                    if(ID.equals(parcel.getWarehouseID()))
                        callBacks.parcelRemoved(new Parcel(parcel));
                }catch(Exception e){ callBacks.notify(e.getMessage()); } }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }


    //listeners
    public interface CallBacks{
        void parcelAdded(Parcel parcel);
        void parcelRemoved(Parcel parcel);
        void parcelChanged(Parcel parcel);
        void notify(String str);
    }
    public int getMaxParcelIDFromFirebase()
    {
        return maxParcelID;

    }

    public MutableLiveData<Boolean> getSuccess(){
        return success;
    }

    //singleton
    private HistoryParcelsFirebase(){

        maxParcelIDIDRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    maxParcelID = dataSnapshot.getValue(int.class);
                    upDateing=true;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }
    private static HistoryParcelsFirebase instance;
    public static HistoryParcelsFirebase getInstance(){
        if(instance == null)
            instance = new HistoryParcelsFirebase();
        return instance;
    }
}
