package com.example.wednesdayapp.model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wednesdayapp.utils.roomdatabase.WednesdayDatabse;
import com.example.wednesdayapp.utils.roomdatabase.WednsedayTable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private static final String TAG = "DatabaseRepository";
    static DatabaseRepository repository;
    MutableLiveData<List<WednsedayTable>> tableMutabledata;

    public static DatabaseRepository getInstance(Context context) {
        if (repository == null) {
            repository = new DatabaseRepository();
            WednesdayDatabse.getDatabaseIntance(context);
        }
        return repository;
    }


    public void insertData(Context context, WednsedayTable table) {
        long result = WednesdayDatabse.getDatabaseIntance(context).wednedayDao().InsertDatEntry(table);
        Log.d(TAG, "insertData: result:" + result);
    }

    public void getDataFromDatabase(Context context, String searchTerm) {
        List<WednsedayTable> data = WednesdayDatabse.getDatabaseIntance(context).wednedayDao().getTableEntries(searchTerm);
        updateDataFromDatabse(data);
    }

    public void updateDataFromDatabse(List<WednsedayTable> data) {
        tableMutabledata.postValue(data);

    }

    public MutableLiveData<List<WednsedayTable>> gettableLiveData() {
        tableMutabledata = new MutableLiveData<>();
        return tableMutabledata;
    }


}
