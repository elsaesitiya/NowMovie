package com.example.elsa.nowmovie.api;

import com.example.elsa.nowmovie.model.Movie;
import com.example.elsa.nowmovie.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {
    //    itu API_KEY ku, ganti pake API_KEY mu :D
    @GET("now_playing?api_key=280af572647b3e8153b144e478ba7a36")
    Call<List<Movie>> getMoviesT();

    @GET("now_playing?api_key=280af572647b3e8153b144e478ba7a36")
    Call<MovieResponse> getMovies();

}