package cn.lawwing.footballplaybook.event;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainClickEvent
{
    private int poi;
    
    private String menuName;
    
    public MainClickEvent(int poi, String menuName)
    {
        this.poi = poi;
        this.menuName = menuName;
    }
    
    public int getPoi()
    {
        return poi;
    }
    
    public String getMenuName()
    {
        return menuName;
    }
}
