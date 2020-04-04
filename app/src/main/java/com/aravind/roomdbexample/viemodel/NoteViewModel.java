package com.aravind.roomdbexample.viemodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

import com.aravind.roomdbexample.roomdb.NoteDao;
import com.aravind.roomdbexample.roomdb.NoteEntity;
import com.aravind.roomdbexample.roomdb.NoteRoomDataBase;

public class NoteViewModel extends AndroidViewModel {

    private NoteRoomDataBase noteRoomDataBase;
    private NoteDao noteDao;

    public NoteViewModel(Application application) {
        super(application);

        noteRoomDataBase = NoteRoomDataBase.getDatabase(application);
        noteDao = noteRoomDataBase.noteDao();

    }

    //Createing Wrapper for insertion operation
    public void insert(NoteEntity noteEntity) {
        //we are performing non UI operation so we are using Async Task
        //alternatively you can enable .allowMainThreadQueries() in NoteRoomDatabaseClass

        //new InsertAsyncTask(noteDao).execute(noteEntity);
        noteDao.insert(noteEntity);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TAG", "ViewModel destroyed");
    }


/*
    private static class InsertAsyncTask extends AsyncTask<NoteEntity,Void,Void> {

        NoteDao noteDao;

        public InsertAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDao.insert(noteEntities[0]);
            return null;
        }
    }
*/
}
