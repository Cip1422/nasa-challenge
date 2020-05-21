
package com.example.nasaapp.model;


import com.google.gson.annotations.SerializedName;

public class NasaImage {

    @SerializedName("collection")
    private Collection mCollection;

    public Collection getCollection() {
        return mCollection;
    }

    public static class Builder {

        private Collection mCollection;

        public NasaImage.Builder withCollection(Collection collection) {
            mCollection = collection;
            return this;
        }

        public NasaImage build() {
            NasaImage nasaImage = new NasaImage();
            nasaImage.mCollection = mCollection;
            return nasaImage;
        }

    }

}
