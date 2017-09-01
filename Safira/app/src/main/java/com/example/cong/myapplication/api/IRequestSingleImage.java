package com.example.cong.myapplication.api;

import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultPickProductAndRec;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cong on 26/08/2017.
 */

public interface IRequestSingleImage {
    @GET("single-image/getSingleImage")
    Call<List<ResultPickProductAndRec>> getProductForPicking(@Query("mixImageId") int mixImageId);

    @GET("single-image/getDetailsImage")
    Call<List<Product>> getImagesDetails(@Query("imageCode") String imageCode);

    @GET("single-image/search")
    Call<List<ResultProducByGroupAndType>> search(@Query("keyword") String keyword, @Query("location") boolean location);

    @GET("single-image/findForCart")
    Call<Product>  getInfoFromColor(@Query("productId") int productId);

    @GET("single-image/image-relai")
    Call<List<Product>> getRecommandation(@Query("imageCode") String imageCode);
}
