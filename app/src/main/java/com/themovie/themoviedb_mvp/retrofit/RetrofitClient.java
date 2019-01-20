package com.themovie.themoviedb_mvp.retrofit;

import com.themovie.themoviedb_mvp.retrofit.model.TopRatedMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {

    @GET("/3/movie/top_rated")
    Observable<TopRatedMovies> getMovies(@Query("page") int page);

    /*@GET("/3/tv/top_rated")
    Observable<TopRatedTvShows> getTvShows(@Query("api_key") String api_key,
                                           @Query("q") String language,
                                           @Query("page") int page);*/

    @GET("/3/search/movie")
    Observable<TopRatedMovies> getSearchedMovies(@Query("api_key") String api_key,
                                                 @Query("q") String language,
                                                 @Query("query") String query);

    /*@GET("/3/search/tv")
    Observable<TopRatedTvShows> getSearchedTvShows(@Query("api_key") String api_key,
                                                   @Query("q") String language,
                                                   @Query("query") String query);*/
}
