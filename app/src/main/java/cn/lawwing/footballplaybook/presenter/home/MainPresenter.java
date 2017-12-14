package cn.lawwing.footballplaybook.presenter.home;

import android.support.annotation.NonNull;

import cn.lawwing.footballplaybook.contract.home.MainContract;
import cn.lawwing.footballplaybook.entity.MainMenuBean;
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
    public void loadMainInfo()
    {
        mIView.showMainList(mIModel.getMainMenu());
    }
    
    @Override
    public void onItemClick(int position, MainMenuBean mainMenuBean)
    {
        ToastUtils.showToast("这是第" + position + "个：" + mainMenuBean.getName());
    }
    
    @Override
    public void initMainInfo()
    {
        
    }
}
