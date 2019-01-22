package com.themovie.themoviedb_mvp.topmovies;

import io.reactivex.Observable;

public interface TopMoviesActivityMVP {

    interface View {
        void networkConnection();
        void updateData(ModelHolder viewModel);
        void toastMessageError(String toast);
    }

    interface Presenter {
        void loadData();
        void rxUnsubscribe();
        void setView(TopMoviesActivityMVP.View view);
    }

    interface Model {
        Observable<ModelHolder> result();
    }
}
