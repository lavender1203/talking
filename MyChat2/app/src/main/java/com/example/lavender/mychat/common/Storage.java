package com.example.lavender.mychat.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lavender on 15-11-25.
 */
public class Storage {
    private final static String STORAGE_FILE_NAME = "chatclient.config";

    public static void putString(Context ctx, String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(ctx);
        sharedPreferences.edit().putString(key,value).commit();
    }

    public static String getString(Context ctx, String key, String... defaultValue){
        SharedPreferences sharedPreferences = getSharedPreferences(ctx);
        String dv = "";
        for(String v:defaultValue){
            dv =v;
            break;
        }
        return sharedPreferences.getString(key,dv);
    }


    public static Boolean getBoolean(Context ctx, String key, Boolean... defaultValue){
        SharedPreferences sharedPreferences = getSharedPreferences(ctx);
        Boolean dv = false;
        for(Boolean v:defaultValue){
            dv =v;
            break;
        }
        return sharedPreferences.getBoolean(key,dv);
    }

    public static void putBoolean(Context ctx, String key, boolean value){
        SharedPreferences sharedPreferences = getSharedPreferences(ctx);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static SharedPreferences getSharedPreferences(Context ctx){
        return ctx.getSharedPreferences(STORAGE_FILE_NAME, Context.MODE_PRIVATE);
    }
}
