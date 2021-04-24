package com.mwguy.vezdecod10mobile.services;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

public class CodeService {
    protected static final String PREFS_NAME = "somefileidk";

    @Nullable
    protected static String readSecretCode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(CodeService.PREFS_NAME, 0);

        return preferences.getString("code", null);
    }

    public static boolean isSecretCodePresent(Context context) {
        return readSecretCode(context) != null;
    }

    public static boolean validateSecretCode(Context context, @Nullable String code) {
        if (code == null) {
            return false;
        }

        String storedCode = readSecretCode(context);
        if (storedCode == null) {
            return true; // пускаем при первом запуске
        }

        return storedCode.equalsIgnoreCase(code);
    }

    public static boolean setSecretCode(Context context, @Nullable String code) {
        if (code == null) {
            return false;
        }

        SharedPreferences.Editor preferences = context.getSharedPreferences(CodeService.PREFS_NAME, 0).edit();
        preferences.putString("code", code);
        return preferences.commit();
    }
}
