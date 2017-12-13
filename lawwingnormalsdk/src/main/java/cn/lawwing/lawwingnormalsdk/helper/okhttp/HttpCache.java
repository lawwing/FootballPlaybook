package cn.lawwing.lawwingnormalsdk.helper.okhttp;

import java.io.File;

import cn.lawwing.lawwingnormalsdk.utils.AppUtils;
import okhttp3.Cache;

/**
 * Created by Horrarndoo on 2017/9/12.
 * <p>
 */
public class HttpCache
{
    
    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024
            * 1024;
    
    public static Cache getCache()
    {
        return new Cache(
                new File(AppUtils.getContext().getCacheDir().getAbsolutePath()
                        + File.separator + "data/NetCache"),
                HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
}
