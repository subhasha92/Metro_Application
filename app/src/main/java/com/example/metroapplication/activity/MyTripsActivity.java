package com.example.metroapplication.activity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.metroapplication.adapter.MyTripsAdapter;
import com.example.metroapplication.utils.MenuActivity;
import com.example.metroapplication.model.MyTrips;
import com.example.metroapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyTripsActivity extends MenuActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override       // for font style
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/caviar_dreams.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_my_trips);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("My Trips");
        }else{getSupportActionBar().setTitle("My Trips");}

        RecyclerView mList = findViewById(R.id.recycler_view_my_trips);

        List<MyTrips> tripsList = new ArrayList<>();
        tripsList.add(new MyTrips(20));
        tripsList.add(new MyTrips(20));
        tripsList.add(new MyTrips(44));
        tripsList.add(new MyTrips(34));
        tripsList.add(new MyTrips(34));
        tripsList.add(new MyTrips(28));
        RecyclerView.Adapter adapter = new MyTripsAdapter(getApplicationContext(), tripsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);




    }
}
