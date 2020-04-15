package com.company.gaia.Network;

import com.company.gaia.Entities.Challenge;
import com.company.gaia.Entities.User;
import com.company.gaia.Models.LoginResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GaiaAPI {

    /**
     * POST request to register new user.
     * @param username
     * @param email
     * @param password
     * @return created user in postgres database on Server side.
     */
    @FormUrlEncoded
    @POST("register")
    Call<User> registerUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    // Test to Log in user
    @FormUrlEncoded
    @POST("authenticate")
    Call<ResponseBody> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );


    /**
     * GET request for all users
     * @return List of users from API
     * TODO: add Query handling for search
     */
    @GET("/users")
    Call<List<User>> getUsers(
            @Header("Authorization") String authToken,
            @Body User user);

    /**
     * GET request for all challenges
     * @return list of all challenges from API
     * TODO: add request for single challenge? use /{id}
     */
    @GET("/challenges")
    Call<List<Challenge>> getChallenges();






}
