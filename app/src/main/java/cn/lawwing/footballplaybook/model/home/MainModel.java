package cn.lawwing.footballplaybook.model.home;

import java.util.ArrayList;

import android.support.annotation.NonNull;

import cn.lawwing.footballplaybook.contract.home.MainContract;
import cn.lawwing.lawwingnormalsdk.base.BaseModel;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainModel extends BaseModel implements MainContract.IMainModel
{
    @NonNull
    public static MainModel newInstance()
    {
        return new MainModel();
    }
    
    @Override
    public ArrayList<String> getMainMenu(ArrayList<String> list)
    {
        return list;
    }
}
