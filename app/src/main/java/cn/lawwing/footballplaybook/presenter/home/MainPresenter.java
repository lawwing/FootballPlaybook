package cn.lawwing.footballplaybook.presenter.home;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import cn.lawwing.footballplaybook.contract.home.MainContract;
import cn.lawwing.footballplaybook.model.home.MainModel;
import cn.lawwing.lawwingnormalsdk.utils.ToastUtils;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainPresenter extends MainContract.MainPresenter
{
    @NonNull
    public static MainPresenter newInstance()
    {
        return new MainPresenter();
    }
    
    @Override
    public MainContract.IMainModel getModel()
    {
        return MainModel.newInstance();
    }
    
    @Override
    public void onStart()
    {
        
    }
    
    @Override
    public void loadMainInfo(ArrayList<String> list)
    {
        mIView.showMainList(mIModel.getMainMenu(list));
    }
    
    @Override
    public void onItemClick(int position, String name)
    {
        ToastUtils.showToast("这是第" + position + "个：" + name);
    }
}
