package com.qf.csdn.home.my.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qf.csdn.R;
import com.qf.csdn.home.my.bean.MyCollectItem;

public class MycollectItemListAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public MycollectItemListAdapter(Context context,List<T> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.mycollect_item_list, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mycollectItemTitleTv = (TextView) convertView.findViewById(R.id.mycollect_item_title_tv);
            viewHolder.mycollectItemCreateTimeTv = (TextView) convertView.findViewById(R.id.mycollect_item_create_time_tv);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
        MyCollectItem.DataEntity.DataEntityCollect dataEntityCollect = (MyCollectItem.DataEntity.DataEntityCollect) object;
        holder.mycollectItemTitleTv.setText(dataEntityCollect.getTitle()+"");
        //16/02/15 14:37
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm");
        String dateline = dataEntityCollect.getDateline();


        Long value = Long.parseLong(dateline)*1000;
       // Date date = new Date();

        String create_date = sdf.format(value);


        holder.mycollectItemCreateTimeTv.setText(create_date+"");
    }

    protected class ViewHolder {
        private TextView mycollectItemTitleTv;
    private TextView mycollectItemCreateTimeTv;
    }
}
