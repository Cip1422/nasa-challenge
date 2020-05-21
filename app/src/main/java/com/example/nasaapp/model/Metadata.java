
package com.example.nasaapp.model;

import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("total_hits")
    private Long mTotalHits;

    public Long getTotalHits() {
        return mTotalHits;
    }

    public static class Builder {

        private Long mTotalHits;

        public Metadata.Builder withTotalHits(Long totalHits) {
            mTotalHits = totalHits;
            return this;
        }

        public Metadata build() {
            Metadata metadata = new Metadata();
            metadata.mTotalHits = mTotalHits;
            return metadata;
        }

    }

}
