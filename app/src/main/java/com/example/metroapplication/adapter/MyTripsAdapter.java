package com.example.metroapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metroapplication.R;
import com.example.metroapplication.activity.DetailActivity;
import com.example.metroapplication.apis.apiModel.MyTripRequestData;
import com.example.metroapplication.apis.apiModel.MyTripResponseData;
import com.example.metroapplication.model.MyTrips;

import java.util.List;

public class MyTripsAdapter extends RecyclerView.Adapter<MyTripsAdapter.ViewHolder> {

    private final Context context;
    private final List<MyTripResponseData> list;

    public MyTripsAdapter(Context context, List<MyTripResponseData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_my_trips, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return new ViewHolder(v);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyTripResponseData mytrip = list.get(position);

        holder.date.setText(mytrip.getTripDate());
        holder.time.setText(String.valueOf(mytrip.getTripStartTime()));
        holder.amount.setText(String.format("Rs %.2f",Float.valueOf(mytrip.getTripAmount())));
        holder.fromStnTV.setText(mytrip.getInStnName());
        holder.toStnTV.setText(mytrip.getOutStnName());

    }

    @Override
    public int getItemCount() {

            return list.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView amount ;
        public TextView fromStnTV ;
        public TextView toStnTV ;
       public TextView date;
        public TextView time;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_mytrip);
            time = itemView.findViewById(R.id.time_mytrip);
            fromStnTV=itemView.findViewById(R.id.from_mytrip);
            toStnTV=itemView.findViewById(R.id.to_mytrip);
            amount = itemView.findViewById(R.id.amount_mytrips);
        }
    }
}
