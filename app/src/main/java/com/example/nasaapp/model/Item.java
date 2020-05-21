
package com.example.nasaapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("href")
    private String mHref;
    @SerializedName("links")
    private List<Link> mLinks;

    public List<Datum> getData() {
        return mData;
    }

    public String getHref() {
        return mHref;
    }

    public List<Link> getLinks() {
        return mLinks;
    }

    public static class Builder {

        private List<Datum> mData;
        private String mHref;
        private List<Link> mLinks;

        public Item.Builder withData(List<Datum> data) {
            mData = data;
            return this;
        }

        public Item.Builder withHref(String href) {
            mHref = href;
            return this;
        }

        public Item.Builder withLinks(List<Link> links) {
            mLinks = links;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.mData = mData;
            item.mHref = mHref;
            item.mLinks = mLinks;
            return item;
        }

    }

}
