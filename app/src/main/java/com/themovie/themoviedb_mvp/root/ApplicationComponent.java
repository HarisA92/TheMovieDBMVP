package com.themovie.themoviedb_mvp.root;

import com.themovie.themoviedb_mvp.retrofit.ModelClient;
import com.themovie.themoviedb_mvp.retrofit.RetrofitClient;
import com.themovie.themoviedb_mvp.topmovies.MainActivity;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ModelClient.class, TopMoviesModule.class})
public interface ApplicationComponent {
    void injectMainActivity(MainActivity mainActivity);
}
