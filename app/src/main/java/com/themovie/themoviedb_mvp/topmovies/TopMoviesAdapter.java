package com.themovie.themoviedb_mvp.topmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.themovie.themoviedb_mvp.R;
import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;

import java.util.ArrayList;

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.ViewHolder> {

    private ArrayList<ViewModel> list;

    public TopMoviesAdapter(ArrayList<ViewModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TopMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMoviesAdapter.ViewHolder viewHolder, int position) {
        Context context = viewHolder.itemView.getContext();
        ViewModel viewModel = list.get(position);
        viewHolder.textMovie.setText(viewModel.getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + viewModel.getImage())
                .apply(RequestOptions.circleCropTransform()).into(viewHolder.imageMovie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textMovie;
        ImageView imageMovie;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textMovie = itemView.findViewById(R.id.text_movie);
            imageMovie = itemView.findViewById(R.id.image_movie);
        }
    }
}
