package com.aravind.roomdbexample.roomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Entity class is basically used to create Table and colums in Database

@Entity(tableName = "notes")
//If we don't define tableName than by default tableName will be its class name
public class NoteEntity {

    //id and mNote are columns

    @NonNull
    @PrimaryKey
    private String id;

    @NonNull
    @ColumnInfo(name = "note") //To change the column name for particular field use columnInfo
    private String mNote;


    public NoteEntity(@NonNull String id, @NonNull String mNote) {
        this.id = id;
        this.mNote = mNote;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getNote() {
        return this.mNote;
    }

    public void setmNote(@NonNull String mNote) {
        this.mNote = mNote;
    }


}
