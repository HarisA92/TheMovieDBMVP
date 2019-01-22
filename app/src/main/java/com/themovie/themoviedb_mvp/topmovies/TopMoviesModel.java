package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TvShowResult;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ModelHolder> result() {
        return Observable.zip(repository.getMoviesFromNetwork(), repository.getTvShowsFromNetwork(), new BiFunction<MovieResult, TvShowResult, ModelHolder>() {
            @Override
            public ModelHolder apply(MovieResult movieResult, TvShowResult tvShowResult) throws Exception {
                return new ModelHolder(movieResult, tvShowResult);
            }
        });
    }
}
