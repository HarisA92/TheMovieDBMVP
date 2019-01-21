package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.RetrofitClient;
import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TopRatedMovies;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class TopMoviesRepository implements Repository {

    private RetrofitClient modelClient;
    private ArrayList<MovieResult> list;

    TopMoviesRepository(RetrofitClient modelClient) {
        this.modelClient = modelClient;
        list = new ArrayList<>();
    }

    @Override
    public Observable<MovieResult> getMoviesFromNetwork() {
        Observable<TopRatedMovies> topRatedMoviesObservable = modelClient.getMovies(1);
        return topRatedMoviesObservable.concatMap(new Function<TopRatedMovies, ObservableSource<MovieResult>>() {
            @Override
            public ObservableSource<MovieResult> apply(TopRatedMovies topRatedMovies) {
                return Observable.fromIterable(topRatedMovies.getResults());
            }
        }).doOnNext(new Consumer<MovieResult>() {
            @Override
            public void accept(MovieResult movieResult) {
                list.add(movieResult);
                int a = 0;
            }
        });

    }
}
