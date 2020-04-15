package com.company.gaia.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class APIclient {


    private static final String GAIA_API_URL = "http://10.0.2.2:8080/";
    private static APIclient mInstance;
    private Retrofit retrofit;

    /**
     * Function that 'puts' everything together for the connection with the backend.
     * Get the API url and also the jackson converter.
     * @return
     */
    private APIclient() {

        /*
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();

                                Request.Builder requsetBuilder = original.newBuilder()
                                        .addHeader("Authorization")
                            }
                        }
                )*/

        retrofit = new Retrofit.Builder()
                .baseUrl(GAIA_API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static synchronized APIclient getInstance() {
        if (mInstance == null) {
            mInstance = new APIclient();
        }
        return mInstance;
    }

    public GaiaAPI getApi() {
        return retrofit.create(GaiaAPI.class);
    }
}
