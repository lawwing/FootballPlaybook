package cn.lawwing.footballplaybook.common;

import org.greenrobot.eventbus.EventBus;

import com.tencent.bugly.crashreport.CrashReport;

import cn.lawwing.lawwingnormalsdk.global.GlobalApplication;

/**
 * Created by lawwing on 2017/12/11.
 */

public class FPBApp extends GlobalApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        CrashReport
                .initCrashReport(getApplicationContext(), "54c4f09d16", false);
    }
    
    public static EventBus getEventBus()
    {
        return EventBus.getDefault();
    }
}
