package com.themovie.themoviedb_mvp.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themovie.themoviedb_mvp.R;
import com.themovie.themoviedb_mvp.root.App;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesActivityMVP;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesAdapter;
import com.themovie.themoviedb_mvp.topmovies.TopMoviesPresenter;
import com.themovie.themoviedb_mvp.topmovies.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;


public class MovieFragment extends Fragment implements TopMoviesActivityMVP.View {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @Inject
    TopMoviesPresenter presenter;
    private ArrayList<ViewModel> resultList;
    private RecyclerView recyclerView;
    private TopMoviesAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((App) Objects.requireNonNull(getActivity()).getApplication()).getComponent().injectMovieFragment(this);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        resultList = new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        buildRecyclerView(v);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
        buildRecyclerAdapter();
    }

    private void buildRecyclerAdapter(){
        adapter = new TopMoviesAdapter(resultList);
        recyclerView.setAdapter(adapter);
    }

    private void buildRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recycler_view_movie);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void networkConnection() {

    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void toastMessageError(String toast) {

    }
}
