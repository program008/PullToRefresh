package com.qf.csdn.home.my.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qf.csdn.R;
import com.qf.csdn.home.my.bean.MyBlogItem;

public class MyblogItemAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public MyblogItemAdapter(Context context,List<T> objects) {
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
            convertView = layoutInflater.inflate(R.layout.myblog_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.myblogListviewItemTitle = (TextView) convertView.findViewById(R.id.myblog_listview_item_title);
            viewHolder.myblogListviewItemComment = (TextView) convertView.findViewById(R.id.myblog_listview_item_comment);
            viewHolder.myblogListviewItemDianzan = (TextView) convertView.findViewById(R.id.myblog_listview_item_dianzan);
            viewHolder.myblogListviewItemViews = (TextView) convertView.findViewById(R.id.myblog_listview_item_views);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
        MyBlogItem.DataEntity entity = (MyBlogItem.DataEntity) object;
        holder.myblogListviewItemTitle.setText(entity.getTitle());
        holder.myblogListviewItemViews.setText(entity.getViewCount()+"");
        holder.myblogListviewItemDianzan.setText(entity.getDigg()+"");
        holder.myblogListviewItemComment.setText(entity.getCommentCount()+"");

    }

    protected class ViewHolder {
        private TextView myblogListviewItemTitle;
    private TextView myblogListviewItemComment;
    private TextView myblogListviewItemDianzan;
    private TextView myblogListviewItemViews;
    }
}
