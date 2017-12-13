package cn.lawwing.footballplaybook.contract.home;

import java.util.ArrayList;

import cn.lawwing.lawwingnormalsdk.base.BasePresenter;
import cn.lawwing.lawwingnormalsdk.base.IBaseActivity;
import cn.lawwing.lawwingnormalsdk.base.IBaseModel;

/**
 * Created by lawwing on 2017/12/13.
 */

public interface MainContract
{
    interface IMainView extends IBaseActivity
    {
        /**
         * 显示电影详情
         *
         * @param bean 电影详情bean
         */
        void showMainList(ArrayList<String> list);
        
    }
    
    interface IMainModel extends IBaseModel
    {
        /**
         * 获取电影详情
         *
         * @param id 电影id
         * @return 电影详情
         */
        ArrayList<String> getMainMenu(ArrayList<String> list);
    }
    
    abstract class MainPresenter extends BasePresenter<IMainModel, IMainView>
    {
        /**
         * 加载电影详情
         *
         * @param id 电影id
         */
        public abstract void loadMainInfo(ArrayList<String> list);
        
        /**
         * item点击事件
         *
         * @param position position
         * @param item item
         */
        public abstract void onItemClick(int position, String name);
        
    }
    
}
