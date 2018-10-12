package com.mcs.kalherath.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSeries extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SeriesAdapter mAdapter;
    private List<SeriesObject> seriesList= new ArrayList<>();
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_series);

        recyclerView = findViewById(R.id.recycler_view);
        //mAdapter = new SeriesAdapter(this, seriesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(mAdapter);
        GetSeries();
    }

    public void GetSeries(){

        Call<List<SeriesObject>> call = apiService.getSeries();

        call.enqueue(new Callback<List<SeriesObject>>() {
            @Override
            public void onResponse(Call<List<SeriesObject>> call, Response<List<SeriesObject>> response) {
                List<SeriesObject> boo = new ArrayList<>();
                boo = response.body();
                mAdapter = new SeriesAdapter(ListSeries.this, boo);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<SeriesObject>>call, Throwable t) {
                // Log error here since request failed
                Log.e("MY.NAME.IS.", call.request().url().toString());
                Log.e("MY.NAME.IS.", t.toString());
            }
        });
    }


}
