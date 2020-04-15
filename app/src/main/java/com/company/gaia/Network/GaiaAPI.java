package com.company.gaia.Network;

import com.company.gaia.Entities.Challenge;
import com.company.gaia.Fragments.ChallengesFragment;
import com.company.gaia.Entities.User;
import com.company.gaia.Models.LoginRequest;
import com.company.gaia.Models.LoginResponse;
import com.company.gaia.Models.RegisterResponse;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GaiaAPI {

    /**
     * POST request to register new user.
     *
     * @return created user in postgres database on Server side.
     */
    @POST("register")
    @Headers("Content-Type: application/json")
    Call<RegisterResponse> registerUser(
            @Body HashMap<String, String> Body
    );

    // Test to Log in user
    @POST("authenticate")
    @Headers("Content-Type: application/json")
    Call<LoginResponse> loginUser(
            @Body HashMap<String, String> Body
    );


    /**
     * GET request for all users
     * @return List of users from API
     * TODO: add Query handling for search
     */
    @GET("/users")
    Call<List<User>> getUsers();

    /**
     * GET request for all challenges
     * @return list of all challenges from API
     * TODO: add request for single challenge? use /{id}
     */
    @GET("/challenges")
    Call<List<Challenge>> getChallenges();






}
