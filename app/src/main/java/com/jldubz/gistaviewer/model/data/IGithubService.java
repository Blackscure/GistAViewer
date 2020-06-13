package com.jldubz.gistaviewer.model.data;

import com.jldubz.gistaviewer.model.gists.Gist;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface IGithubService {

    @GET("/gists/public") //https://api.github.com/gist/public
    Call<List<Gist>> getpublicGists();

    @GET("/gists")
    Call<List<Gist>> getyourGists();

    @GET("/gists/starred")
    Call<List<Gist>> getstarredGists();
}
