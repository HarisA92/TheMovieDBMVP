package com.themovie.themoviedb_mvp.retrofit;

import com.themovie.themoviedb_mvp.retrofit.model.TopRatedMovies;
import com.themovie.themoviedb_mvp.retrofit.model.TopRatedTvShow;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {

    @GET("/3/movie/top_rated")
    Observable<TopRatedMovies> getMovies(@Query("page") int page);

    @GET("/3/tv/top_rated")
    Observable<TopRatedTvShow> getTvShows(@Query("page") int page);

}
