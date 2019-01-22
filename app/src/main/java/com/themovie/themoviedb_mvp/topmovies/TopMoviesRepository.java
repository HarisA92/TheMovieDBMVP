package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.RetrofitClient;
import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TopRatedMovies;
import com.themovie.themoviedb_mvp.retrofit.model.TopRatedTvShow;
import com.themovie.themoviedb_mvp.retrofit.model.TvShowResult;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class TopMoviesRepository implements Repository {

    private RetrofitClient modelClient;
    private ArrayList<MovieResult> movieResultsList;
    private ArrayList<TvShowResult> tvShowResultsList;

    TopMoviesRepository(RetrofitClient modelClient) {
        this.modelClient = modelClient;
        movieResultsList = new ArrayList<>();
        tvShowResultsList = new ArrayList<>();
    }

    @Override
    public Observable<MovieResult> getMoviesFromNetwork() {
        Observable<TopRatedMovies> topRatedMoviesObservable = (modelClient.getMovies(1).concatWith(modelClient.getMovies(2)));
        return topRatedMoviesObservable.concatMap(new Function<TopRatedMovies, ObservableSource<MovieResult>>() {
            @Override
            public ObservableSource<MovieResult> apply(TopRatedMovies topRatedMovies) {
                return Observable.fromIterable(topRatedMovies.getResults());
            }
        }).doOnNext(new Consumer<MovieResult>() {
            @Override
            public void accept(MovieResult movieResult) {
                movieResultsList.add(movieResult);
            }
        });

    }

    @Override
    public Observable<TvShowResult> getTvShowsFromNetwork() {
        Observable <TopRatedTvShow> observable = modelClient.getTvShows(1);
        return observable.concatMap(new Function<TopRatedTvShow, ObservableSource<? extends TvShowResult>>() {
            @Override
            public ObservableSource<? extends TvShowResult> apply(TopRatedTvShow topRatedTvShow) throws Exception {
                return Observable.fromIterable(topRatedTvShow.getResults());
            }
        }).doOnNext(new Consumer<TvShowResult>() {
            @Override
            public void accept(TvShowResult tvShowResult) throws Exception {
                tvShowResultsList.add(tvShowResult);
            }
        });
    }
}
