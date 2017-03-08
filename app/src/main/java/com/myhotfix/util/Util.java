package com.myhotfix.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class Util {
    // 获取系统版本号
    public static String getVersionName(Context context) {
        String version = "";
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            version = packInfo.versionName;
        } catch (Exception e) {
            // LogUtil.e(Util.class, "getVersionName", e);
        }
        return version;
    }

    // 获取系统versionCode
    public static int getVersionCode(Context context) {
        int version = -1;
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            version = packInfo.versionCode;
        } catch (Exception e) {
            // LogUtil.e(Util.class, "getVersionCode", e);
        }
        return version;
    }
}
