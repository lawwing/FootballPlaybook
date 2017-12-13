package cn.lawwing.lawwingnormalsdk.global;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import cn.lawwing.lawwingnormalsdk.BuildConfig;

/**
 * Created by lawwing on 2017/12/13.
 * <p>
 * 全局Application
 */

public class GlobalApplication extends MultiDexApplication
{
    private static final String LOG_TAG = "LAWWING_LOGGER";
    
    protected static Context context;
    
    protected static Handler handler;
    
    protected static int mainThreadId;
    
    private static GlobalApplication mApp;
    
    public static synchronized GlobalApplication getInstance()
    {
        return mApp;
    }
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
        Logger.init(LOG_TAG).logLevel(
                BuildConfig.IS_SHOW_LOG ? LogLevel.FULL : LogLevel.NONE);
    }
    
    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext()
    {
        return context;
    }
    
    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler()
    {
        return handler;
    }
    
    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId()
    {
        return mainThreadId;
    }
    
    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
