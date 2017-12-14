package cn.lawwing.footballplaybook.model.home;

import java.util.ArrayList;

import android.graphics.Color;
import android.support.annotation.NonNull;

import cn.lawwing.footballplaybook.contract.home.MainContract;
import cn.lawwing.footballplaybook.entity.MainMenuBean;
import cn.lawwing.footballplaybook.ui.activity.home.GuideActivity;
import cn.lawwing.lawwingnormalsdk.base.BaseModel;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainModel extends BaseModel implements MainContract.IMainModel
{
    private String[] names = { "即时战术", "录制战术", "播放战术", "阵型管理", "关于我们", "设置" };
    
    private int[] bgcolors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY,
            Color.GREEN, Color.RED };
    
    private int[] textcolors = { Color.WHITE, Color.WHITE, Color.WHITE,
            Color.BLUE, Color.WHITE, Color.WHITE };
    
    @NonNull
    public static MainModel newInstance()
    {
        return new MainModel();
    }
    
    @Override
    public ArrayList<MainMenuBean> getMainMenu()
    {
        ArrayList<MainMenuBean> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++)
        {
            MainMenuBean bean = new MainMenuBean();
            bean.setName(names[i]);
            bean.setBgcolor(bgcolors[i]);
            bean.setTextcolor(textcolors[i]);
            bean.setUpdatetime(0);
            bean.setGotoActivity(GuideActivity.class);
            list.add(bean);
        }
        return list;
    }
}
