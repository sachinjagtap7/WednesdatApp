package com.example.wednesdayapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.wednesdayapp.R;
import com.example.wednesdayapp.databinding.ActivityMainBinding;
import com.example.wednesdayapp.model.NetworkRepository;
import com.example.wednesdayapp.utils.CustomClickLisnter;
import com.example.wednesdayapp.utils.IsInternetAvaialble;
import com.example.wednesdayapp.utils.adapters.ITunesRecyclerViewAdapter;
import com.example.wednesdayapp.utils.models.RootData;
import com.example.wednesdayapp.utils.roomdatabase.WednsedayTable;
import com.example.wednesdayapp.viewmodels.ItunesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ItunesViewModel viewModel;
    Context context;
    ActivityMainBinding binding;
    ArrayList<WednsedayTable> arrayList;
    ITunesRecyclerViewAdapter adapter;
    ProgressDialog progressDialog;
    CustomClickLisnter customClickLisnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this;
        showProgressDialog();
        viewModel = ViewModelProviders.of(this).get(ItunesViewModel.class);
        customClickLisnter = new CustomClickLisnter() {
            @Override
            public void clickToShowDetails(int posisiton) {
                //startFragment
            }
        };
        initRecyclerView();
        binding.svSearchSongs.setOnQueryTextListener(this);
        viewModel.isInternetAvailableLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                dismissProgressDialog();
                if (aBoolean) {
                    // viewModel.getDataFromServer();
                    binding.tvNoInternetLable.setVisibility(View.GONE);
                } else {
                    //set message No Internet available
                    //retrive data from databse and update recycleview
                    Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT).show();
                    binding.tvNoInternetLable.setVisibility(View.VISIBLE);
                    // viewModel.getdataFromDatabse();
                }

            }
        });
        viewModel.isInternetAvailable();
        viewModel.serverDataLivedata.observe(this, new Observer<ArrayList<WednsedayTable>>() {
            @Override
            public void onChanged(ArrayList<WednsedayTable> arrayList) {
                if (arrayList.size() > 0) {
                    updateRecyclerView(arrayList);
                    saveDataInDatabase(arrayList);
                } else {

                }
            }
        });
        viewModel.databaseDataLiveData.observe(this, new Observer<List<WednsedayTable>>() {
            @Override
            public void onChanged(List<WednsedayTable> arrayList) {
                if (arrayList.size() > 0)
                    updateRecyclerView(arrayList);
            }
        });
        viewModel.isNetworkDataAvailable.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (!aBoolean) {
                    binding.tvResultText.setText("0 Results");
                    arrayList.clear();
                    adapter.notifyDataSetChanged();
                }

            }
        });

    }

    private void saveDataInDatabase(ArrayList<WednsedayTable> arrayList) {
        viewModel.saveRoomData(arrayList);
    }

    private void updateRecyclerView(List<WednsedayTable> tables) {
        binding.rvItemList.setVisibility(View.VISIBLE);
        binding.tvDefaultText.setVisibility(View.GONE);
        binding.tvResultText.setVisibility(View.VISIBLE);
        binding.tvResultText.setText(tables.size() + " Results");
        if (arrayList != null) {
            arrayList.clear();
            arrayList.addAll(tables);
            adapter.notifyDataSetChanged();
        }
    }

    private void initRecyclerView() {
        arrayList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rvItemList.setLayoutManager(manager);
        adapter = new ITunesRecyclerViewAdapter(this, arrayList, customClickLisnter);
        binding.rvItemList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Retriving data.please wait");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText != null && !newText.toString().equals("") && newText.length() > 0) {
            binding.tvResultText.setText("0 Results");
            binding.tvResultText.setVisibility(View.VISIBLE);
            if (viewModel.isInternetAvailableLiveData.getValue())
                viewModel.getDataFromServer(newText);
            else
                viewModel.getdataFromDatabse(newText);
        } else {
            if (newText.equals("")) {
                binding.tvResultText.setText("");
                binding.tvResultText.setVisibility(View.GONE);
                arrayList.clear();
                adapter.notifyDataSetChanged();
            }
        }
        return false;
    }

}
