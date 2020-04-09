package com.company.gaia.Network;

import com.company.gaia.Entities.Challenge;
import com.company.gaia.Entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GaiaAPI {

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/challenges")
    Call<List<Challenge>> getChallenges();

    // Test to Log in user
    @FormUrlEncoded
    @POST("/authenticate")
    Call<User> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );

    // Test to Regsiter User
    @FormUrlEncoded
    @POST("/register")
    Call<User> registerUser(
            @Field("username") String username,
            @Field("password") String password
    );


}
