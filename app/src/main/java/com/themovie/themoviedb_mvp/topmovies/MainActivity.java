package com.themovie.themoviedb_mvp.topmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.themovie.themoviedb_mvp.R;
import com.themovie.themoviedb_mvp.root.App;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesActivityMVP;
import com.themovie.themoviedb_mvp.topmovies.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Provides;

public class MainActivity extends AppCompatActivity implements TopMoviesActivityMVP.View {

    @Inject
    TopMoviesActivityMVP.Presenter presenter;
    private ArrayList<ViewModel> movieList = new ArrayList<>();
    private ArrayList<ViewModel> tvshowList = new ArrayList<>();
    private TvShowsAdapter tvShowsAdapter;
    private TopMoviesAdapter topMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getComponent().injectMainActivity(this);
        buildRecyclerViewMovie();
        buildRecyclerViewTvShow();
    }

    private void buildRecyclerViewMovie(){
        RecyclerView recyclerViewMovie = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMovie.setLayoutManager(layoutManager);
        recyclerViewMovie.setHasFixedSize(true);
        topMoviesAdapter = new TopMoviesAdapter(movieList);
        recyclerViewMovie.setAdapter(topMoviesAdapter);
    }

    private void buildRecyclerViewTvShow(){
        RecyclerView recyclerViewTvShow = findViewById(R.id.recycler_view_tvshows);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewTvShow.setLayoutManager(layoutManager);
        recyclerViewTvShow.setHasFixedSize(true);
        tvShowsAdapter = new TvShowsAdapter(tvshowList);
        recyclerViewTvShow.setAdapter(tvShowsAdapter);
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
        movieList.add(viewModel);
        tvshowList.add(viewModel);
        topMoviesAdapter.notifyDataSetChanged();
        tvShowsAdapter.notifyDataSetChanged();
    }

    @Override
    public void toastMessageError(String toast) {

    }
}

