package com.themovie.themoviedb_mvp.topmovies;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TopMoviesPresenter implements TopMoviesActivityMVP.Presenter {

    private TopMoviesActivityMVP.Model model;
    private TopMoviesActivityMVP.View view;
    private Disposable disposable = null;

    TopMoviesPresenter(TopMoviesActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        disposable = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelHolder>() {
                    @Override
                    public void accept(ModelHolder viewModel) throws Exception {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        if (view != null) {
                            view.toastMessageError("Error getting data");
                        }
                    }
                });
    }

    @Override
    public void rxUnsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void setView(TopMoviesActivityMVP.View view) {
        this.view = view;
    }
}
