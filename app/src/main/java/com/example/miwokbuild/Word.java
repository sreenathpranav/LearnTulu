package com.example.miwokbuild;

public class Word {

    private String mDefaultTranslation;                //fields
    private String mTuluTranslation;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED = -1;


    public Word(String defaultTranslation, String tuluTranslation, int audioResourceId) {           //constructor
        mDefaultTranslation = defaultTranslation;
        mTuluTranslation = tuluTranslation;
        mAudioResourceId= audioResourceId;
    }

    public Word(int imageResourceId, String defaultTranslation, String tuluTranslation, int audioResourceId) {
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mTuluTranslation = tuluTranslation;
        mAudioResourceId=audioResourceId;
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

    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
