package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;

import io.reactivex.Observable;

public interface TopMoviesActivityMVP {

    interface View {
        void networkConnection();
        void updateData(ViewModel viewModel);
        void toastMessageError(String toast);
    }

    interface Presenter {
        void loadData();
        void rxUnsubscribe();
        void setView(TopMoviesActivityMVP.View view);
    }

    interface Model {
        Observable<MovieResult> result();
    }
}
