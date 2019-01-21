package com.themovie.themoviedb_mvp.topmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.themovie.themoviedb_mvp.R;
import com.themovie.themoviedb_mvp.root.App;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesActivityMVP;
import com.themovie.themoviedb_mvp.topmovies.ViewModel;

import javax.inject.Inject;

import dagger.Provides;

public class MainActivity extends AppCompatActivity implements TopMoviesActivityMVP.View {

    @Inject
    TopMoviesActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getComponent().injectMainActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
    }


    @Override
    public void networkConnection() {

    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void toastMessageError(String toast) {

    }
}

