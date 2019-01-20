package com.themovie.themoviedb_mvp.root;

import com.themovie.themoviedb_mvp.activities.MainActivity;
import com.themovie.themoviedb_mvp.activities.MovieFragment;
import com.themovie.themoviedb_mvp.retrofit.ModelClient;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ModelClient.class, TopMoviesModule.class})
public interface ApplicationComponent {
    //void injectMovieFragment(MovieFragment target);
}
