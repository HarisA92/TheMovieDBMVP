package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;

import io.reactivex.Observable;


public interface Repository {

    Observable <MovieResult> getMoviesFromNetwork();
    Observable <String> getTvShowsFromNetwork();
    Observable <String> getTitleData();
    Observable <MovieResult> getResultData();

}
