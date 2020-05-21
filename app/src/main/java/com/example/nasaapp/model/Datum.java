
package com.example.nasaapp.model;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("center")
    private String mCenter;
    @SerializedName("date_created")
    private String mDateCreated;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("description_508")
    private String mDescription508;
    @SerializedName("keywords")
    private List<String> mKeywords;
    @SerializedName("media_type")
    private String mMediaType;
    @SerializedName("nasa_id")
    private String mNasaId;
    @SerializedName("secondary_creator")
    private String mSecondaryCreator;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("photographer")
    private String mPhotographer;

    public String getCenter() {
        return mCenter;
    }

    public String getDateCreated() {
        return mDateCreated;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getDescription508() {
        return mDescription508;
    }

    public List<String> getKeywords() {
        return mKeywords;
    }

    public String getMediaType() {
        return mMediaType;
    }

    public String getNasaId() {
        return mNasaId;
    }

    public String getSecondaryCreator() {
        return mSecondaryCreator;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPhotographer(){
        return mPhotographer;
    }

    public static class Builder {

        private String mCenter;
        private String mDateCreated;
        private String mDescription;
        private String mDescription508;
        private List<String> mKeywords;
        private String mMediaType;
        private String mNasaId;
        private String mSecondaryCreator;
        private String mTitle;
        private String mPhotographer;

        public Datum.Builder withCenter(String center) {
            mCenter = center;
            return this;
        }

        public Datum.Builder withDateCreated(String dateCreated) {
            mDateCreated = dateCreated;
            return this;
        }

        public Datum.Builder withDescription(String description) {
            mDescription = description;
            return this;
        }

        public Datum.Builder withDescription508(String description508) {
            mDescription508 = description508;
            return this;
        }

        public Datum.Builder withKeywords(List<String> keywords) {
            mKeywords = keywords;
            return this;
        }

        public Datum.Builder withMediaType(String mediaType) {
            mMediaType = mediaType;
            return this;
        }

        public Datum.Builder withNasaId(String nasaId) {
            mNasaId = nasaId;
            return this;
        }

        public Datum.Builder withSecondaryCreator(String secondaryCreator) {
            mSecondaryCreator = secondaryCreator;
            return this;
        }

        public Datum.Builder withTitle(String title) {
            mTitle = title;
            return this;
        }

        public Datum.Builder withPhotographer(String photographer){
            mPhotographer = photographer;
            return this;
        }

        public Datum build() {
            Datum datum = new Datum();
            datum.mCenter = mCenter;
            datum.mDateCreated = mDateCreated;
            datum.mDescription = mDescription;
            datum.mDescription508 = mDescription508;
            datum.mKeywords = mKeywords;
            datum.mMediaType = mMediaType;
            datum.mNasaId = mNasaId;
            datum.mSecondaryCreator = mSecondaryCreator;
            datum.mTitle = mTitle;
            datum.mPhotographer = mPhotographer;
            return datum;
        }

    }

    @NonNull
    @Override
    public String toString() {
        return mNasaId + " " + mDateCreated + " " + mTitle;
    }
}
