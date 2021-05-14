package com.example.miwokbuild;

public class Word {

    private String mDefaultTranslation;                //fields
    private String mTuluTranslation;

    public Word (String defaultTranslation,String tuluTranslation){           //constructor
        mDefaultTranslation=defaultTranslation;
        mTuluTranslation=tuluTranslation;
    }

    public String getDefaultTranslation(){                //methods
        return mDefaultTranslation;
    }
    public String getTuluTranslation(){
        return mTuluTranslation;
    }
}
