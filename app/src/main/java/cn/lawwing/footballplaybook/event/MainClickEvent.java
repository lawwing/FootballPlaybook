package cn.lawwing.footballplaybook.event;

import cn.lawwing.footballplaybook.entity.MainMenuBean;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainClickEvent
{
    private int poi;
    
    private MainMenuBean mainMenuBean;
    
    public MainClickEvent(int poi, MainMenuBean mainMenuBean)
    {
        this.poi = poi;
        this.mainMenuBean = mainMenuBean;
    }
    
    public int getPoi()
    {
        return poi;
    }
    
    public MainMenuBean getMainMenuBean()
    {
        return mainMenuBean;
    }
}
