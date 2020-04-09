package com.company.gaia.Network;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class APIclient {

    private static Retrofit retrofit = null;
    private static final String GAIA_API_URL = "http://10.0.2.2:8080/";

    /**
     * Function that 'puts' everything together for the connection with the backend.
     * Get the API url and also the jackson converter.
     * @return
     */
    public static Retrofit getGaiaClient() {
        return new Retrofit.Builder()
                .baseUrl(GAIA_API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
