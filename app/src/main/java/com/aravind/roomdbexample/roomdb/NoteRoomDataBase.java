package com.aravind.roomdbexample.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = NoteEntity.class, version = 1)
public abstract class NoteRoomDataBase extends RoomDatabase {

    public abstract NoteDao noteDao();

    //make it singleton
    private  static volatile NoteRoomDataBase noteRoomInstance;

    public static NoteRoomDataBase getDatabase(Context context){
        if (noteRoomInstance==null){
            synchronized (NoteRoomDataBase.class){
                if(noteRoomInstance == null){
                    noteRoomInstance = Room.databaseBuilder(context.getApplicationContext(),NoteRoomDataBase.class,"note_database")
                            .build();
                }
            }
        }
        return noteRoomInstance;
    }
}
