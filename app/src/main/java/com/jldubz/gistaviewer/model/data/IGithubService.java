package com.jldubz.gistaviewer.model.data;

import com.jldubz.gistaviewer.model.GitHubUser;
import com.jldubz.gistaviewer.model.gists.Gist;
import com.jldubz.gistaviewer.model.gists.GistComment;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGithubService {

    @GET("/gists/public") //https://api.github.com/gist/public?page=1
    Call<List<Gist>> getpublicGists(@Query("page") int pageNum);

    @GET("/gists")
    Call<List<Gist>> getyourGists(@Query("page") int pageNum);

    @GET("/gists/starred")
    Call<List<Gist>> getstarredGists(@Query("page") int pageNum);

    @GET("/gist/(gistId)")
    Call<Gist> getGistById(@Path("gistId") String gistId);

    @GET("/gist/(gistId)comments")
    Call<List<GistComment>>  getGistCommentsById(@Path("gistId")String GistId,@Query("page")int pageNum);

    @HEAD("/gist/(gistId)comments")
    Call<Void>  getGistCommentsHeaderById(@Path("gistId")String GistId);

    //user
    @GET("/user")
    Call<GitHubUser> getLoggedUser(@Header("Authorization") String auth);

}
