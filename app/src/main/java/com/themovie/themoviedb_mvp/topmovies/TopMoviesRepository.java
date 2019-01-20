package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.ModelClient;
import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TopRatedMovies;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TopMoviesRepository implements Repository {

    private ModelClient modelClient;
    private ArrayList<MovieResult> list;

    public TopMoviesRepository(ModelClient modelClient) {
        this.modelClient = modelClient;
    }

    @Override
    public Observable<MovieResult> getMoviesFromNetwork() {
        Observable<TopRatedMovies> topRatedMoviesObservable = modelClient.retrofitClient().getMovies(1);
        /*return topRatedMoviesObservable.concatMap(new Function<TopRatedMovies, ObservableSource<MovieResult>>() {
            @Override
            public ObservableSource<MovieResult> apply(TopRatedMovies topRatedMovies) {
                return Observable.fromIterable(topRatedMovies.getResults());
            }
        }).doOnNext(new Consumer<MovieResult>() {
            @Override
            public void accept(MovieResult movieResult) {
                list.add(movieResult);
            }
        });*/
        return topRatedMoviesObservable.map(new Function<TopRatedMovies, MovieResult>() {
            @Override
            public MovieResult apply(TopRatedMovies topRatedMovies) throws Exception {
                return topRatedMovies.getResults().get(0);
            }
        }).doOnNext(new Consumer<MovieResult>() {
            @Override
            public void accept(MovieResult movieResult) throws Exception {
                list.add(movieResult);
            }
        });
    }

    @Override
    public Observable<String> getTvShowsFromNetwork() {

        return null;
    }

    @Override
    public Observable<String> getTitleData() {
        return null;
    }

    @Override
    public Observable<MovieResult> getResultData() {
        return null;
    }
}