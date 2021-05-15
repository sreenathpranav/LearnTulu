package com.example.miwokbuild;

public class Word {

    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private String mDefaultTranslation;                //fields
    private String mTuluTranslation;
    public static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String tuluTranslation) {           //constructor
        mDefaultTranslation = defaultTranslation;
        mTuluTranslation = tuluTranslation;
    }

    public Word(int imageResourceId, String defaultTranslation, String tuluTranslation) {
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mTuluTranslation = tuluTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
    public String getDefaultTranslation() {                //methods
        return mDefaultTranslation;
    }
    public String getTuluTranslation() {
        return mTuluTranslation;
    }


    public boolean hasImage() {
       return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
