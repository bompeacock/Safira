package com.example.cong.myapplication.model;

import android.util.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;

/**
 * Created by CongNV4 on 6/21/2017.
 */

public class CollectionTypeAdapter implements TypeAdapterFactory {
    public final static int TYPE_BANNER = 1;
    public final static int TYPE_CAROUSEL =2;
    public final static int TYPE_MIX_PRODUCT =3;

    private Map<Integer,TypeAdapter<? extends ResultsCollection>> ADAPTERS = new ArrayMap<>();
    private TypeAdapter<ResultsCollection> baseTypeAdapter;
    private TypeAdapter<JsonElement> elementAdapter;


    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

        if (!ResultsCollection.class.isAssignableFrom(type.getRawType())) return null;

        ADAPTERS.put(TYPE_BANNER,gson.getDelegateAdapter(this,TypeToken.get(TypeBanner.class)));
        ADAPTERS.put(TYPE_CAROUSEL,gson.getDelegateAdapter(this,TypeToken.get(TypeCarousel.class)));
        ADAPTERS.put(TYPE_MIX_PRODUCT,gson.getDelegateAdapter(this,TypeToken.get(TypeMixProduct.class)));

        baseTypeAdapter = gson.getDelegateAdapter(this, TypeToken.get(ResultsCollection.class));

        elementAdapter = gson.getAdapter(JsonElement.class);

        return (TypeAdapter<T>) new ResultCollectionAdapter().nullSafe();
    }
    private class ResultCollectionAdapter extends TypeAdapter<ResultsCollection>{

        @Override
        public void write(JsonWriter out, ResultsCollection value) throws IOException {
            Integer type = value.getType();
            TypeAdapter<? extends ResultsCollection> adapter = type == null ? baseTypeAdapter : ADAPTERS.get(type);
            if(value instanceof TypeBanner){
                writeWrap(adapter, out, (TypeBanner) value, TypeBanner.class);
            }else if(value instanceof TypeCarousel){
                writeWrap(adapter, out, (TypeCarousel) value, TypeCarousel.class);
            }else if(value instanceof TypeMixProduct){
                writeWrap(adapter, out, (TypeMixProduct) value, TypeMixProduct.class);
            }else {
                writeWrap(adapter, out, (ResultsCollection) value, ResultsCollection.class);
            }
        }
        private <T extends ResultsCollection> void writeWrap(TypeAdapter<? extends ResultsCollection> adapter,
                                                 JsonWriter out, T value, Class<T> dummyForT) throws IOException {
            ((TypeAdapter<T>)adapter).write(out, value);
        }

        @Override
        public ResultsCollection read(JsonReader in) throws IOException {
            JsonObject objectJson = elementAdapter.read(in).getAsJsonObject();
            JsonElement typeJson = objectJson.get("type");

            Integer type = Integer.parseInt(typeJson.toString());

            TypeAdapter<? extends ResultsCollection> adapter = type == null ? baseTypeAdapter : ADAPTERS.get(type);

            return adapter.fromJsonTree(objectJson);
        }
    }
}
