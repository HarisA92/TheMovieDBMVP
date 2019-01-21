package com.themovie.themoviedb_mvp.topmovies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.themovie.themoviedb_mvp.R;
import com.themovie.themoviedb_mvp.retrofit.model.MovieResult;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.ViewHolder> {

    ArrayList<ViewModel> list = new ArrayList<>();

    public TopMoviesAdapter(ArrayList<ViewModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TopMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.topmovies_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMoviesAdapter.ViewHolder viewHolder, int i) {
        ViewModel viewModel = list.get(i);
        viewHolder.title.setText(viewModel.getTitle());
        Glide.with(viewHolder.itemView.getContext()).load(viewModel.getImage()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
