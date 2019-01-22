package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TvShowResult;

public class ModelHolder {

    private MovieResult movieResult;
    private TvShowResult tvShowResult;

    ModelHolder(MovieResult movieResult, TvShowResult tvShowResult) {
        this.movieResult = movieResult;
        this.tvShowResult = tvShowResult;
    }

    public MovieResult getMovieResult() {
        return movieResult;
    }

    public void setMovieResult(MovieResult movieResult) {
        this.movieResult = movieResult;
    }

    public TvShowResult getTvShowResult() {
        return tvShowResult;
    }

    public void setTvShowResult(TvShowResult tvShowResult) {
        this.tvShowResult = tvShowResult;
    }
}
