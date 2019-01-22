package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;
import com.themovie.themoviedb_mvp.retrofit.model.TvShowResult;

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
    public Observable<ViewModel> result() {
        return Observable.zip(repository.getMoviesFromNetwork(), repository.getTvShowsFromNetwork(), new BiFunction<MovieResult, TvShowResult, ViewModel>() {
            @Override
            public ViewModel apply(MovieResult movieResult, TvShowResult tvShowResult) throws Exception {
                return new ViewModel(movieResult, tvShowResult);
            }
        });
    }
}
