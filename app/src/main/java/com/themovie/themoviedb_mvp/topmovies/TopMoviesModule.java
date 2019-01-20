package com.themovie.themoviedb_mvp.topmovies;

import com.themovie.themoviedb_mvp.retrofit.ModelClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TopMoviesModule {

    @Provides
    public TopMoviesPresenter provideTopMoviesPresenter(TopMoviesModel topMoviesModel){
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public TopMoviesModel provideTopMoviesModel(TopMoviesRepository topMoviesRepository){
        return new TopMoviesModel(topMoviesRepository);
    }

    @Singleton
    @Provides
    public TopMoviesRepository provideTopMovieRepository(ModelClient modelClient){
        return new TopMoviesRepository(modelClient);
    }

}
