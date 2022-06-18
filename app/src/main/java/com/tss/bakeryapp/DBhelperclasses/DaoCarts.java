package com.tss.bakeryapp.DBhelperclasses;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DaoCarts {
    //insert the carts item
    @Insert
    void InsertCarts(CartsTableModel cartsTableModel);
    @Query("SELECT * FROM cartsitem")
    List< CartsTableModel > getAll();
}
