package com.kingleystudio.remarket;

import android.content.Context;
import android.provider.Settings;

import com.kingleystudio.remarket.models.di.Dialog;
import com.kingleystudio.remarket.models.di.User;

public class Config {
    public static User currentUser = null;

    public static User userToProfile;
    public static int adIdToShow;
    public static Dialog dialogToShow;

    public static Context baseContext;

    public static String getDeviceID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if ("000000000".matches("^[0]+$")) {
            return string;
        }
        return "000000000";
    }
}
