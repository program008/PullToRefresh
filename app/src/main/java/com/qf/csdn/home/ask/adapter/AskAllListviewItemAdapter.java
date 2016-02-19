package com.qf.csdn.home.ask.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import com.qf.csdn.R;
import com.qf.csdn.home.ask.bean.AskAllQuestion;
import com.qf.csdn.other.utils.MyAppliction;

public class AskAllListviewItemAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public AskAllListviewItemAdapter(Context context,List<T> objects) {
        this.objects = objects;
        this.context = context;
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
            convertView = layoutInflater.inflate(R.layout.ask_all_listview_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.askAllItemTitle = (TextView) convertView.findViewById(R.id.ask_all_item_title);
            viewHolder.askAllItemTag = (TextView) convertView.findViewById(R.id.ask_all_item_tag);
            viewHolder.askAllItemAvatar = (ImageView) convertView.findViewById(R.id.ask_all_item_avatar);
            viewHolder.askAllItemUsername = (TextView) convertView.findViewById(R.id.ask_all_item_username);
            viewHolder.askAllItemTwTime = (TextView) convertView.findViewById(R.id.ask_all_item_tw_time);
            viewHolder.askAllItemReward = (TextView) convertView.findViewById(R.id.ask_all_item_reward);
            viewHolder.askAllItemAsk2 = (TextView) convertView.findViewById(R.id.ask_all_item_ask2);
            viewHolder.askAllItemAsk1 = (TextView) convertView.findViewById(R.id.ask_all_item_ask1);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
        AskAllQuestion.DataEntity.DataEntityAll entityAll = (AskAllQuestion.DataEntity.DataEntityAll) object;
        holder.askAllItemTitle.setText(entityAll.getTitle() + "");

        //设置标签
        String tag = "";
        List<String> tag_list = entityAll.getTag_list();
        if(tag_list.size()!=0){
            for(String tg :tag_list){
                tag += tg+" ";
            }
        }

        tag = context.getString(R.string.ask_all_item_tag_tv,tag);
        holder.askAllItemTag.setText(tag);
        //设置头像
        String avatar = entityAll.getAvatar();
        MyAppliction.mBitmapUtils.display(holder.askAllItemAvatar,avatar);

        //设置昵称
        holder.askAllItemUsername.setText(entityAll.getNickname()+"");

        //设置提问的时间
        String created_at = entityAll.getCreated_at();
        created_at = context.getString(R.string.ask_all_item_tw_time_tv,created_at);
        holder.askAllItemTwTime.setText(created_at + "");

        //设置悬赏的数目和回答的数目
        int answer_count = entityAll.getAnswer_count();
        String answer = context.getString(R.string.ask_all_item_ask2, answer_count);
        int c_coin = entityAll.getC_coin();
        String coin = context.getString(R.string.ask_reward_item_reward_tv,c_coin);
        if(c_coin==0){
            holder.askAllItemReward.setVisibility(View.GONE);
            holder.askAllItemAsk2.setVisibility(View.VISIBLE);
            holder.askAllItemAsk1.setVisibility(View.GONE);
            holder.askAllItemAsk2.setText(answer+"");
        } else {
            holder.askAllItemReward.setVisibility(View.VISIBLE);
            holder.askAllItemAsk2.setVisibility(View.GONE);
            holder.askAllItemAsk1.setVisibility(View.VISIBLE);
            holder.askAllItemAsk1.setText(answer+"");
            holder.askAllItemReward.setText(coin+"");
        }




    }

    protected class ViewHolder {
        private TextView askAllItemTitle;
    private TextView askAllItemTag;
    private ImageView askAllItemAvatar;
    private TextView askAllItemUsername;
    private TextView askAllItemTwTime;
    private TextView askAllItemReward;
    private TextView askAllItemAsk2;
    private TextView askAllItemAsk1;
    }
}
