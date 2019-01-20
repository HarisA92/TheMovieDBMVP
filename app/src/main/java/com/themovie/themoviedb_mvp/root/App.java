package com.themovie.themoviedb_mvp.root;

import android.app.Application;

import com.themovie.themoviedb_mvp.retrofit.ModelClient;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .modelClient(new ModelClient())
                .topMoviesModule(new TopMoviesModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
