package com.tss.bakeryapp.DBhelperclasses;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = CartsTableModel.class,version = 3,exportSchema = true)
public abstract class DataBaseCarts extends RoomDatabase{
    //data base instance
  public static DataBaseCarts instance;
    private static String databasename="db_bakery";
    public synchronized static DataBaseCarts getInstance(Context mcontext){
        // check
        if(instance == null){
            instance = Room.databaseBuilder(mcontext,DataBaseCarts.class,databasename).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
     return instance;
    }
public abstract DaoCarts daoCarts();
}
