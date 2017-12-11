package cn.lawwing.footballplaybook.common;

import com.tencent.bugly.crashreport.CrashReport;

import android.app.Application;

/**
 * Created by lawwing on 2017/12/11.
 */

public class FPBApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        CrashReport
                .initCrashReport(getApplicationContext(), "54c4f09d16", false);
    }
}
