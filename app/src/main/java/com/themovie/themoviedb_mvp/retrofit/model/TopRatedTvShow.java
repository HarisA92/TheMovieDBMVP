package com.themovie.themoviedb_mvp.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TopRatedTvShow {
    @SerializedName("results")
    @Expose
    private List<TvShowResult> results = new ArrayList<>();

    public List<TvShowResult> getResults() {
        return results;
    }
}
