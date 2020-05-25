package com.example.wednesdayapp.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wednesdayapp.utils.models.ItunesResultData;
import com.example.wednesdayapp.utils.models.RootData;
import com.example.wednesdayapp.utils.retrofit.APIClient;
import com.example.wednesdayapp.utils.retrofit.APIInterface;
import com.example.wednesdayapp.utils.roomdatabase.WednsedayTable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkRepository {

    private static final String TAG = "NetworkRepository";
    static NetworkRepository repository;
    MutableLiveData<ArrayList<WednsedayTable>> dataMutableLiveData;
    MutableLiveData<Boolean> isDataAvailble;

    public static NetworkRepository getInstance() {
        if (repository == null) {
            repository = new NetworkRepository();
        }
        return repository;
    }

    public LiveData<Boolean> getDataAvailalbeFlag() {
        isDataAvailble = new MutableLiveData<>();
        return isDataAvailble;
    }

    void updateDataAvailableFlag(boolean flag) {
        isDataAvailble.setValue(flag);
    }

    public MutableLiveData<ArrayList<WednsedayTable>> getLiveData() {
        dataMutableLiveData = new MutableLiveData<>();
        return dataMutableLiveData;
    }

    public void getDatFromServer(String searchTerm) {
        APIClient.setBaseUrl("https://itunes.apple.com");
        APIInterface service = APIClient.getclient().create(APIInterface.class);
        Call<RootData> request = service.getDataFromServer(searchTerm);
        request.enqueue(new Callback<RootData>() {
            @Override
            public void onResponse(Call<RootData> call, Response<RootData> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Count= " + response.body().getResultCount());
                    if (response.body() != null && response.body().getResultCount() > 0) {
                        RootData rootData = response.body();
                        ArrayList<WednsedayTable> table = convertToTableData(rootData);
                        updateServerdata(table);
                    } else {
                        //update No data available
                    }
                } else {
                    Log.d(TAG, "onResponse: Not successfully");
                    updateDataAvailableFlag(false);
                }
            }

            @Override
            public void onFailure(Call<RootData> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private ArrayList<WednsedayTable> convertToTableData(RootData rootData) {
        ArrayList<WednsedayTable> arrayList = new ArrayList<>();
        for (int i = 0; i < rootData.getResultCount(); i++) {
            WednsedayTable table = new WednsedayTable();
            table.setArtistId(rootData.getResults().get(i).getArtistId() + "");
            table.setArtistName(rootData.getResults().get(i).getArtistName() + "");
            table.setArtistViewUrl(rootData.getResults().get(i).getArtistViewUrl() + "");
            table.setArtworkUrl30(rootData.getResults().get(i).getArtworkUrl30() + "");
            table.setArtworkUrl60(rootData.getResults().get(i).getArtworkUrl60() + "");
            table.setArtworkUrl100(rootData.getResults().get(i).getArtworkUrl100() + "");
            table.setArtistViewUrl(rootData.getResults().get(i).getArtistViewUrl() + "");
            table.setCollectionCensoredName(rootData.getResults().get(i).getCollectionCensoredName() + "");
            table.setCollectionExplicitness(rootData.getResults().get(i).getCollectionExplicitness() + "");
            table.setCollectionName(rootData.getResults().get(i).getCollectionName() + "");
            table.setCollectionPrice(rootData.getResults().get(i).getCollectionPrice() + "");
            table.setCollectionViewUrl(rootData.getResults().get(i).getCollectionViewUrl() + "");
            table.setCountry(rootData.getResults().get(i).getCountry() + "");
            table.setCurrency(rootData.getResults().get(i).getCurrency() + "");
            table.setDiscCount(rootData.getResults().get(i).getDiscCount() + "");
            table.setDiscNumber(rootData.getResults().get(i).getDiscNumber() + "");
            table.setKind(rootData.getResults().get(i).getKind() + "");
            table.setPreviewUrl(rootData.getResults().get(i).getPreviewUrl());
            table.setPrimaryGenreName(rootData.getResults().get(i).getPrimaryGenreName());
            table.setReleaseDate(rootData.getResults().get(i).getReleaseDate());
            table.setStreamable(rootData.getResults().get(i).getIsStreamable());
            table.setTrackCensoredName(rootData.getResults().get(i).getTrackCensoredName());
            table.setTrackCount(rootData.getResults().get(i).getTrackCount() + "");
            table.setTrackExplicitness(rootData.getResults().get(i).getTrackExplicitness());
            table.setTrackId(rootData.getResults().get(i).getTrackId() + "");
            table.setTrackNumber(rootData.getResults().get(i).getTrackNumber() + "");
            table.setTrackName(rootData.getResults().get(i).getTrackName() + "");
            table.setTrackPrice(rootData.getResults().get(i).getTrackPrice() + "");
            table.setTrackTimeMillis(rootData.getResults().get(i).getTrackTimeMillis() + "");
            table.setTrackViewUrl(rootData.getResults().get(i).getTrackViewUrl() + "");
            table.setWrapperType(rootData.getResults().get(i).getWrapperType() + "");
            arrayList.add(table);
        }
        return arrayList;

    }

    private void updateServerdata(ArrayList<WednsedayTable> rootData) {
        dataMutableLiveData.setValue(rootData);
    }

}
