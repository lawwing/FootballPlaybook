package cn.lawwing.footballplaybook.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.lawwing.footballplaybook.R;
import cn.lawwing.footballplaybook.common.FPBApp;
import cn.lawwing.footballplaybook.event.MainClickEvent;

/**
 * Created by lawwing on 2017/12/13.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder>
{
    private LayoutInflater inflater;
    
    private Activity activity;
    
    private ArrayList<String> datas;
    
    public MainAdapter(Activity activity, ArrayList<String> datas)
    {
        this.activity = activity;
        this.datas = datas;
        inflater = LayoutInflater.from(activity);
    }
    
    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MainHolder(
                inflater.inflate(R.layout.item_main_layout, parent, false));
    }
    
    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder,
            final int position)
    {
        holder.textView.setText(datas.get(position));
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
    
    @Override
    public int getItemCount()
    {
        return datas != null ? datas.size() : 0;
    }
    
    public class MainHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        
        public MainHolder(View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.menu_name);
        }
    }
}
