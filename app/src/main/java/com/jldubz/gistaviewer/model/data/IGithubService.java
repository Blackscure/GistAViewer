package com.jldubz.gistaviewer.model.data;

import com.jldubz.gistaviewer.model.gists.Gist;

import java.util.List;

import retrofit2.http.GET;

public interface IGithibService {

    @GET("/gists/public") //https://api.github.com/gist
    call<List<Gist>> getpublicGists();

    @GET("/gists")
    call<List<Gist>> getyourGists();

    call<List<Gist>> getstarredGists();
}
