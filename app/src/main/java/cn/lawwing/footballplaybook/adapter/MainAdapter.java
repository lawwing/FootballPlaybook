package cn.lawwing.footballplaybook.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.lawwing.footballplaybook.R;
import cn.lawwing.footballplaybook.common.FPBApp;
import cn.lawwing.footballplaybook.entity.MainMenuBean;
import cn.lawwing.footballplaybook.event.MainClickEvent;
import cn.lawwing.lawwingnormalsdk.utils.ScreenUtils;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder>
{
    private LayoutInflater inflater;
    
    private Activity activity;
    
    private ArrayList<MainMenuBean> datas;
    
    private int itemHeight = 100;
    
    private int itemWidth = 100;
    
    public MainAdapter(Activity activity, ArrayList<MainMenuBean> datas)
    {
        this.activity = activity;
        this.datas = datas;
        inflater = LayoutInflater.from(activity);
        int screemHeight = ScreenUtils.getScreenHeight(activity);
        int screemWidth = ScreenUtils.getScreenWidth(activity);
        
        itemHeight = screemHeight / 2;
        itemWidth = screemWidth / 3;
    }
    
    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.item_main_layout, parent, false);
        view.getLayoutParams().height = itemHeight;
        view.getLayoutParams().width = itemWidth;
        return new MainHolder(view);
    }
    
    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder,
            final int position)
    {
        MainMenuBean bean = datas.get(position);
        if (bean != null)
        {
            holder.textView.setText(bean.getName());
            holder.textView.setTextColor(bean.getTextcolor());
            holder.textView.setBackgroundColor(bean.getBgcolor());
            holder.textView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    FPBApp.getEventBus().post(
                            new MainClickEvent(position, datas.get(position)));
                }
            });
        }
    }
    
    @Override
    public int getItemCount()
    {
        return datas != null ? datas.size() : 0;
    }
    
    public class MainHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        
        LinearLayout bossLayout;
        
        public MainHolder(View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.menu_name);
            bossLayout = (LinearLayout) itemView.findViewById(R.id.bossLayout);
        }
    }
}
