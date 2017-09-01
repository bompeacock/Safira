package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForDetails;
import com.example.cong.myapplication.api.IRequestSingleImage;
import com.example.cong.myapplication.interfaceView.IDetailsProductView;
import com.example.cong.myapplication.model.Color;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.ResultGetCode;
import com.example.cong.myapplication.model.ResultProducByGroupAndType;
import com.example.cong.myapplication.utils.RetrofitUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 27/08/2017.
 */

public class DetailsProductPresenter {
    IDetailsProductView detailsProductView;

    IRequestForDetails requestForDetails;

    IRequestSingleImage requestSingleImage;

    DatabaseReference database;
    FirebaseUser user ;

    public DetailsProductPresenter(IDetailsProductView detailsProductView) {
        this.detailsProductView = detailsProductView;
        requestForDetails = RetrofitUtils.getRetrofitWithRealServer()
                .create(IRequestForDetails.class);
        requestSingleImage = RetrofitUtils.getRetrofitWithRealServer()
                .create(IRequestSingleImage.class);
        user = FirebaseAuth.getInstance().getCurrentUser();
        database  = FirebaseDatabase.getInstance().getReference().child(user.getUid());
    }

    public void loadDataImagesProduct(String code) {


        requestSingleImage.getImagesDetails(code).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<String> urlList =  handleResponse(response.body());

                if(urlList!=null){
                    detailsProductView.loadViewImagesDetails(urlList);
                    detailsProductView.loadViewInfoProduct(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    private List<String> handleResponse(List<Product> body) {
        List<String> list = new ArrayList<>();
        for(Product product: body){
            list.add(product.getUrlImage());
        }
        return list;
    }

    public void loadDataImageColor(String code) {

        requestForDetails.getColors(code).enqueue(new Callback<List<Color>>() {
            @Override
            public void onResponse(Call<List<Color>> call, Response<List<Color>> response) {
                detailsProductView.loadViewProductColor(response.body());
            }

            @Override
            public void onFailure(Call<List<Color>> call, Throwable t) {

            }
        });
    }

    public void loadDataCode(int productId) {
        requestForDetails.getCode(productId).enqueue(new Callback<ResultGetCode>() {
            @Override
            public void onResponse(Call<ResultGetCode> call, Response<ResultGetCode> response) {

                loadDataImagesProduct(response.body().getImageTarget().getProduct().getCode());
            }

            @Override
            public void onFailure(Call<ResultGetCode> call, Throwable t) {

            }
        });

    }

    public void loadDataRecommandation(String code) {
        requestSingleImage.getRecommandation(code).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                handleLoadRecommandation(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    private void handleLoadRecommandation(List<Product> body) {
        List<ResultProducByGroupAndType> list = new ArrayList<>();
        for (Product product : body){
            list.add(new ResultProducByGroupAndType(product));
        }
        detailsProductView.loadViewRecommandation(list);
    }

    public void addToCart(final Product product) {
        database.child("cart").push().setValue(product);
        detailsProductView.showMessageAddToCart("Add to cart successfully");
//        database.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String message ;
//                if(!ProductUtils.getAllProductCartOnFireBase(dataSnapshot).contains(product)){
//                    database.setValue(product);
//                    message = "Add to cart successfully";
//                }else message = "Have existed";
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


    }
}
