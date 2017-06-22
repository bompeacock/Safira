package com.example.cong.myapplication.utils;

import com.example.cong.myapplication.model.CollectionTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static Retrofit getNormally() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getSpecifically(){
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new CollectionTypeAdapter())
                .create();
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    //if must have a key to access
//    private static OkHttpClient client(){
//        return new OkHttpClient.Builder()
//                .addInterceptor(apiKeyInterceptor())
//                .build();
//    }
//    private static Interceptor apiKeyInterceptor(){
//        return new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                HttpUrl url = request.url()
//                        .newBuilder().addQueryParameter("api_key",Constant.API_KEY)
//                        .build();
//                request = request.newBuilder()
//                        .url(url)
//                        .build();
//                return chain.proceed(request);
//
//            }
//        };
//    }
}
