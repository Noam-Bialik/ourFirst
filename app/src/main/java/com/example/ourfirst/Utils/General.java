package com.example.ourfirst.Utils;

import com.example.ourfirst.Entities.Parcel;

import java.util.List;

public class General{

     static public int findIndexInParcels(List<Parcel> parcels, int id){
         for(int i = 0;i < parcels.size();i++)
             if(id == parcels.get(i).getID())
                 return i;

        return -1;
     }

}
