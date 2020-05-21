
package com.example.nasaapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("href")
    private String mHref;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("links")
    private List<Link> mLinks;
    @SerializedName("metadata")
    private Metadata mMetadata;
    @SerializedName("version")
    private String mVersion;

    public String getHref() {
        return mHref;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public List<Link> getLinks() {
        return mLinks;
    }

    public Metadata getMetadata() {
        return mMetadata;
    }

    public String getVersion() {
        return mVersion;
    }

    public static class Builder {

        private String mHref;
        private List<Item> mItems;
        private List<Link> mLinks;
        private Metadata mMetadata;
        private String mVersion;

        public Collection.Builder withHref(String href) {
            mHref = href;
            return this;
        }

        public Collection.Builder withItems(List<Item> items) {
            mItems = items;
            return this;
        }

        public Collection.Builder withLinks(List<Link> links) {
            mLinks = links;
            return this;
        }

        public Collection.Builder withMetadata(Metadata metadata) {
            mMetadata = metadata;
            return this;
        }

        public Collection.Builder withVersion(String version) {
            mVersion = version;
            return this;
        }

        public Collection build() {
            Collection collection = new Collection();
            collection.mHref = mHref;
            collection.mItems = mItems;
            collection.mLinks = mLinks;
            collection.mMetadata = mMetadata;
            collection.mVersion = mVersion;
            return collection;
        }

    }

}
