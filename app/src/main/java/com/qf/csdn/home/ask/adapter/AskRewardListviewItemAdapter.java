package com.qf.csdn.home.ask.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import com.qf.csdn.R;
import com.qf.csdn.home.ask.bean.AskAllQuestion;
import com.qf.csdn.home.ask.bean.AskRewardQuestion;
import com.qf.csdn.other.utils.MyAppliction;

public class AskRewardListviewItemAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public AskRewardListviewItemAdapter(Context context, List<T> objects) {
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
            convertView = layoutInflater.inflate(R.layout.ask_reward_listview_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.askRewardItemTitle = (TextView) convertView.findViewById(R.id.ask_reward_item_title);
            viewHolder.askRewardItemTag = (TextView) convertView.findViewById(R.id.ask_reward_item_tag);
            viewHolder.askRewardItemAvatar = (ImageView) convertView.findViewById(R.id.ask_reward_item_avatar);
            viewHolder.askRewardItemUsername = (TextView) convertView.findViewById(R.id.ask_reward_item_username);
            viewHolder.askRewardItemTwTime = (TextView) convertView.findViewById(R.id.ask_reward_item_tw_time);
            viewHolder.askRewardItemReward = (TextView) convertView.findViewById(R.id.ask_reward_item_reward);
            viewHolder.askRewardItemAsk1 = (TextView) convertView.findViewById(R.id.ask_reward_item_ask1);

            convertView.setTag(viewHolder);
        }
        initializeViews((T) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement

        AskRewardQuestion.DataEntity.DataEntityReward entityAll = (AskRewardQuestion.DataEntity.DataEntityReward) object;
        holder.askRewardItemTitle.setText(entityAll.getTitle() + "");

        //设置标签
        String tag = "";
        List<String> tag_list = entityAll.getTag_list();
        if (tag_list.size() != 0) {
            for (String tg : tag_list) {
                tag += tg + " ";
            }
        }

        tag = context.getString(R.string.ask_reward_item_tag_tv, tag);
        holder.askRewardItemTag.setText(tag);
        //设置头像
        String avatar = entityAll.getAvatar();
        MyAppliction.mBitmapUtils.display(holder.askRewardItemAvatar, avatar);

        //设置昵称
        holder.askRewardItemUsername.setText(entityAll.getNickname() + "");

        //设置提问的时间
        String created_at = entityAll.getCreated_at();
        created_at = context.getString(R.string.ask_reward_item_tw_time_tv, created_at);
        holder.askRewardItemTwTime.setText(created_at + "");

        //设置悬赏的数目和回答的数目
        int answer_count = entityAll.getAnswer_count();
        String answer = context.getString(R.string.ask_all_item_ask2, answer_count);
        int c_coin = entityAll.getC_coin();
        String coin = context.getString(R.string.ask_reward_item_reward_tv, c_coin);

        holder.askRewardItemAsk1.setText(answer + "");
        holder.askRewardItemReward.setText(coin + "");

    }

    protected class ViewHolder {
        private TextView askRewardItemTitle;
        private TextView askRewardItemTag;
        private ImageView askRewardItemAvatar;
        private TextView askRewardItemUsername;
        private TextView askRewardItemTwTime;
        private TextView askRewardItemReward;
        private TextView askRewardItemAsk1;
    }
}
