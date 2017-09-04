package com.example.cong.myapplication.presenter;

import com.example.cong.myapplication.api.IRequestForDetails;
import com.example.cong.myapplication.interfaceView.IFavoriteView;
import com.example.cong.myapplication.model.Product;
import com.example.cong.myapplication.model.Size;
import com.example.cong.myapplication.utils.ProductUtils;
import com.example.cong.myapplication.utils.RetrofitUtils;
import com.example.cong.myapplication.utils.StructureFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cong on 03/09/2017.
 */

public class FavoritePresenter {
    IFavoriteView favoriteView;

    DatabaseReference databaseReference;

    FirebaseUser user;

    public FavoritePresenter(IFavoriteView favoriteView) {
        this.favoriteView = favoriteView;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void loadDataFavorive() {
        databaseReference.child(user.getUid()).child(StructureFirebase.FAVORITE)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<Product> productList = ProductUtils.getAllProductCartOnFireBase(dataSnapshot);
                        List<String> listKey = ProductUtils.getAllKeyCartOnFireBase(dataSnapshot);

                        favoriteView.showViewFavorite(productList, listKey);
                        
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

    }

    public void removeItemFavorite(String key, int position) {
        databaseReference.child(user.getUid()).child(StructureFirebase.FAVORITE)
                .child(key).removeValue();
        favoriteView.deleteItem(position);

    }

    public void loadSize(final Product product) {
        IRequestForDetails iRequestForDetails = RetrofitUtils.getRetrofitWithRealServer()
                .create(IRequestForDetails.class);
        iRequestForDetails.getSizes(product.getCode()).enqueue(new Callback<List<Size>>() {
            @Override
            public void onResponse(Call<List<Size>> call, Response<List<Size>> response) {
                handleSize(response.body(),product);
            }

            @Override
            public void onFailure(Call<List<Size>> call, Throwable t) {

            }
        });
    }

    private void handleSize(List<Size> body, Product product) {
        List<String> sizes = new ArrayList<>();
        for(Size size :body){
            sizes.add(size.getSize());
        }
        favoriteView.showSizeDialog(sizes,product);
    }

    public void addProductToCart(Product p) {
        databaseReference.child(user.getUid()).child(StructureFirebase.CART).push().setValue(p);
    }
}
