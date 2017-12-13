package cn.lawwing.footballplaybook.common;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by lawwing on 2017/12/11.
 */

public class FPBApp extends MultiDexApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        CrashReport
                .initCrashReport(getApplicationContext(), "54c4f09d16", false);
    }
    
    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
