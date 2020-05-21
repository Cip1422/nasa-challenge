
package com.example.nasaapp.model;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("href")
    private String mHref;
    @SerializedName("prompt")
    private String mPrompt;
    @SerializedName("rel")
    private String mRel;
    @SerializedName("render")
    private String mRender;

    public String getHref() {
        return mHref;
    }

    public String getPrompt() {
        return mPrompt;
    }

    public String getRel() {
        return mRel;
    }

    public String getRender() {
        return mRender;
    }

    public static class Builder {

        private String mHref;
        private String mPrompt;
        private String mRel;
        private String mRender;

        public Link.Builder withHref(String href) {
            mHref = href;
            return this;
        }

        public Link.Builder withPrompt(String prompt) {
            mPrompt = prompt;
            return this;
        }

        public Link.Builder withRel(String rel) {
            mRel = rel;
            return this;
        }

        public Link.Builder withRender(String render) {
            mRender = render;
            return this;
        }

        public Link build() {
            Link link = new Link();
            link.mHref = mHref;
            link.mPrompt = mPrompt;
            link.mRel = mRel;
            link.mRender = mRender;
            return link;
        }

    }

}
