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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.ViewHolder> {

    private ArrayList<ViewModel> list;

    public TvShowsAdapter(ArrayList<ViewModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TvShowsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.toptvshows_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsAdapter.ViewHolder holder, int i) {
        Context context = holder.itemView.getContext();
        ViewModel viewModel = list.get(i);
        holder.title.setText(viewModel.getMovieResult().getTitle());
        Glide.with(context).load(context.getResources().getString(R.string.imagePath) + viewModel.getMovieResult().getPosterPath())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.image);
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

            title = itemView.findViewById(R.id.titleMovie);
            image = itemView.findViewById(R.id.imageMovie);

        }
    }
}
