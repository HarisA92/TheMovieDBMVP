package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MovieResult> result() {
        return repository.getMoviesFromNetwork();
    }
}
