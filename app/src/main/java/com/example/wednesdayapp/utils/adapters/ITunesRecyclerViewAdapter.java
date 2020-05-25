package com.example.wednesdayapp.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wednesdayapp.R;
import com.example.wednesdayapp.databinding.LayoutItuneEntryViewBinding;
import com.example.wednesdayapp.utils.CustomClickLisnter;
import com.example.wednesdayapp.utils.roomdatabase.WednsedayTable;

import java.util.ArrayList;

public class ITunesRecyclerViewAdapter extends RecyclerView.Adapter<ITunesRecyclerViewAdapter.ITUnesViewholder> {

    Context context;
    ArrayList<WednsedayTable> arrayList;
    LayoutItuneEntryViewBinding binding;
    CustomClickLisnter customClickLisnter;

    public ITunesRecyclerViewAdapter(Context context, ArrayList<WednsedayTable> arrayList, CustomClickLisnter customClickLisnter) {
        this.context = context;
        this.arrayList = arrayList;
        this.customClickLisnter = customClickLisnter;
    }

    @NonNull
    @Override
    public ITUnesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_itune_entry_view, parent, false);
        return new ITUnesViewholder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ITUnesViewholder holder, int position) {

        if (holder != null) {
            holder.bind(position);
        }
    }

    @Override
    public int getItemCount() {
        if (arrayList != null)
            return arrayList.size();
        else
            return 0;
    }

    class ITUnesViewholder extends RecyclerView.ViewHolder {

        public ITUnesViewholder(@NonNull View itemView) {
            super(itemView);
            binding.cvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //send position of click view  to activity
                    customClickLisnter.clickToShowDetails(getAdapterPosition());
                }
            });

        }

        public void bind(int position) {
            binding.tvTrackName.setText(arrayList.get(position).getTrackName());
            binding.tvArtistName.setText(arrayList.get(position).getArtistName());
            binding.tvTackCost.setText(arrayList.get(position).getTrackPrice());
            binding.tvTackReleaseDate.setText(arrayList.get(position).getReleaseDate());
        }
    }
}
