package com.lotr.booking.util;

import android.util.Log;

public class LogUtils {

    private static final String LOG_PREFIX = "!_";
    private static final String LOG_POSTFIX = " ";

    public static String makeLogTag(Class cls) {
        return LOG_PREFIX + cls.getSimpleName() + LOG_POSTFIX;
    }

    /*
     * Обходит ограничения фиксированного размера буфера logcat
     * Позволяет выводить логи любого объема
     */
    public static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }
}
