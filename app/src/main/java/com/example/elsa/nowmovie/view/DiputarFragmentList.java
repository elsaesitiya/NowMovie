package com.example.elsa.nowmovie.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.elsa.nowmovie.R;
import com.example.elsa.nowmovie.adapter.MovieAdapter;
import com.example.elsa.nowmovie.api.API;
import com.example.elsa.nowmovie.api.IRetrofit;
import com.example.elsa.nowmovie.api.RetrofitClient;
import com.example.elsa.nowmovie.model.Movie;
import com.example.elsa.nowmovie.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiputarFragmentList extends AppCompatActivity {
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList;
    private IRetrofit iRetrofit;
    String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_diputar_list);
        iRetrofit = RetrofitClient.getClient(API.NOW_PLAYING).create(IRetrofit.class);
        movieList = new ArrayList<>();


        movieAdapter = new MovieAdapter(this, movieList);

        rvMovie = findViewById(R.id.rvMovie);
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        rvMovie.setAdapter(movieAdapter);

        getMovies();
    }

    private void getMovies() {
        iRetrofit.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() != null) {
                    movieList.clear();
                    movieList.addAll(response.body().getResults());
                    movieAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_language:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}