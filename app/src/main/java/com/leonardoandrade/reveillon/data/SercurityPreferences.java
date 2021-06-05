package com.leonardoandrade.reveillon.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SercurityPreferences {

    private SharedPreferences mSharedPreferences;

    public SercurityPreferences(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("Reveillon", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }
}
