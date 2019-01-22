package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TvShowResult;

import io.reactivex.Observable;


public interface Repository {

    Observable <MovieResult> getMoviesFromNetwork();
    Observable <TvShowResult> getTvShowsFromNetwork();


}
