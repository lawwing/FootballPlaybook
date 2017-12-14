package cn.lawwing.footballplaybook.ui.activity.home;

import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.lawwing.footballplaybook.R;
import cn.lawwing.lawwingnormalsdk.helper.RxHelper;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class GuideActivity extends AppCompatActivity
{
    private boolean mIsCancle = false;
    
    private int mTime = 3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initCountDown();
    }
    
    private void initCountDown()
    {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(3)// 计时次数
                .map(new Function<Long, Long>()
                {
                    @Override
                    public Long apply(Long aLong) throws Exception
                    {
                        return mTime - aLong;// 3-0 3-2 3-1
                    }
                })
                .compose(RxHelper.<Long> rxSchedulerHelper())
                .subscribe(new Observer<Long>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                    }
                    
                    @Override
                    public void onNext(Long value)
                    {
                        // Logger.e("value = " + value);
                        // tvCountDown.setText(String.valueOf(value));
                    }
                    
                    @Override
                    public void onError(Throwable e)
                    {
                    }
                    
                    @Override
                    public void onComplete()
                    {
                        if (!mIsCancle)
                        {
                            startActivity(new Intent(GuideActivity.this,
                                    MainActivity.class));
                            finish();
                        }
                    }
                });
    }
}
