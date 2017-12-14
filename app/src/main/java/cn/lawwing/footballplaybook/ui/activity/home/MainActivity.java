package cn.lawwing.footballplaybook.ui.activity.home;

import java.util.ArrayList;

import org.greenrobot.eventbus.Subscribe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import cn.lawwing.footballplaybook.R;
import cn.lawwing.footballplaybook.adapter.MainAdapter;
import cn.lawwing.footballplaybook.common.FPBApp;
import cn.lawwing.footballplaybook.contract.home.MainContract;
import cn.lawwing.footballplaybook.event.MainClickEvent;
import cn.lawwing.footballplaybook.presenter.home.MainPresenter;
import cn.lawwing.lawwingnormalsdk.base.BasePresenter;
import cn.lawwing.lawwingnormalsdk.base.activity.BaseMVPCompatActivity;

public class MainActivity extends
        BaseMVPCompatActivity<MainContract.MainPresenter, MainContract.IMainModel>
        implements MainContract.IMainView
{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    
    private MainAdapter adapter;
    
    @NonNull
    @Override
    public BasePresenter initPresenter()
    {
        return MainPresenter.newInstance();
    }
    
    @Override
    protected void initView(Bundle savedInstanceState)
    {
        // recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<String> list = new ArrayList<String>();
        list.add("战术板1");
        list.add("战术板2");
        list.add("战术板3");
        mPresenter.loadMainInfo(list);
        
        FPBApp.getEventBus().register(this);
    }
    
    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_main;
    }
    
    @Override
    public void showMainList(ArrayList<String> list)
    {
        adapter = new MainAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
    }
    
    @Override
    protected void onDestroy()
    {
        FPBApp.getEventBus().unregister(this);
        super.onDestroy();
    }
    
    @Subscribe
    public void onMainMenuClick(MainClickEvent event)
    {
        if (event != null)
        {
            mPresenter.onItemClick(event.getPoi(), event.getMenuName());
        }
    }
}
