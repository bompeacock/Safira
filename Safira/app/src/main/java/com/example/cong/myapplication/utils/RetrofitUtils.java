package com.example.cong.myapplication.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static Retrofit getNormally() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofitWithRealServer(){
        return new Retrofit.Builder()
                .baseUrl(Constant.REAL_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


//    public static Retrofit getRetrofit(){
//        return new Retrofit.Builder()
//                .baseUrl(Constant.BASE_URL_TEST)
//                .client(client())
//                .addConverterFactory(GsonConverterFactory.create()) // convert xml to json object purpose
//                .build();
//    }
//
//    //if must have a key to access
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
