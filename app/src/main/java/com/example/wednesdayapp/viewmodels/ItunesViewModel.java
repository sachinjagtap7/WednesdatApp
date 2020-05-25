package com.example.wednesdayapp.viewmodels;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.wednesdayapp.model.DatabaseRepository;
import com.example.wednesdayapp.model.NetworkRepository;
import com.example.wednesdayapp.utils.IsInternetAvaialble;
import com.example.wednesdayapp.utils.models.RootData;
import com.example.wednesdayapp.utils.roomdatabase.WednsedayTable;

import java.util.ArrayList;
import java.util.List;

public class ItunesViewModel extends AndroidViewModel {

    public LiveData<Boolean> isInternetAvailableLiveData;
    MutableLiveData<Boolean> isInternetAvailableMutableLiveData;
    public LiveData<ArrayList<WednsedayTable>> serverDataLivedata;
    public LiveData<List<WednsedayTable>> databaseDataLiveData;
    public LiveData<Boolean> isNetworkDataAvailable;
    Context context;

    public ItunesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        DatabaseRepository.getInstance(context);
        isInternetAvailableMutableLiveData = new MutableLiveData<>();
        isInternetAvailableLiveData = Transformations.map(isInternetAvailableMutableLiveData, data -> isInternetAvaialble(data));
        serverDataLivedata = Transformations.map(NetworkRepository.getInstance().getLiveData(), data -> getData(data));
        databaseDataLiveData = Transformations.map(DatabaseRepository.getInstance(context).gettableLiveData(), data -> getTableLiveData(data));
        isNetworkDataAvailable = Transformations.map(NetworkRepository.getInstance().getDataAvailalbeFlag(), data -> getIsDataAvailableFlag(data));
    }


    private Boolean getIsDataAvailableFlag(Boolean data) {
        return data;
    }

    private List<WednsedayTable> getTableLiveData(List<WednsedayTable> data) {
        return data;
    }

    private ArrayList<WednsedayTable> getData(ArrayList<WednsedayTable> data) {
        return data;
    }

    private Boolean isInternetAvaialble(Boolean data) {
        return data;
    }

    public void isInternetAvailable() {
        isInternetAvailableMutableLiveData.setValue(IsInternetAvaialble.isIntenetAvaialble(context));
    }

    public void getDataFromServer(String searchTerm) {
        NetworkRepository.getInstance().getDatFromServer(searchTerm);
    }

    public void saveRoomData(ArrayList<WednsedayTable> arrayList) {
        new AsyncTask<Void, String, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                for (int i = 0; i < arrayList.size(); i++) {
                    DatabaseRepository.getInstance(context).insertData(context, arrayList.get(i));
                }
                return null;
            }
        }.execute();
    }

    public void getdataFromDatabse(String newText) {
        new AsyncTask<Void, String, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                DatabaseRepository.getInstance(context).getDataFromDatabase(context, newText);
                return null;
            }
        }.execute();
    }

}
