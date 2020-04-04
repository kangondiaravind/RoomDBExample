package com.aravind.roomdbexample.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;

//Dao is used to insert data into database

@Dao
public interface NoteDao {

    @Insert
    void insert(NoteEntity noteEntity);

}
