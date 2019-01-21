package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.ModelClient;
import com.themovie.themoviedb_mvp.retrofit.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TopMoviesModule {

    @Provides
    public TopMoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMVP.Model topMoviesModel) {
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public TopMoviesActivityMVP.Model provideTopMoviesActivityModel(Repository repository) {
        return new TopMoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepository(RetrofitClient retrofitClient) {
        return new TopMoviesRepository(retrofitClient);
    }

}
