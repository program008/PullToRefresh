package com.qf.csdn.home.headline.adapter;

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
import com.qf.csdn.home.headline.bean.HeadlineListBean2;
import com.qf.csdn.other.utils.MyAppliction;

public class HeadlineItem215Adapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public HeadlineItem215Adapter(Context context,List<T> objects) {
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
            convertView = layoutInflater.inflate(R.layout.headline_item215, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.headlineFt215ItemTitle = (TextView) convertView.findViewById(R.id.headline_ft215_item_title);
            viewHolder.headlineFt215ItemFrom = (TextView) convertView.findViewById(R.id.headline_ft215_item_from);
            viewHolder.headlineFt215ItemUseriv = (ImageView) convertView.findViewById(R.id.headline_ft215_item_useriv);
            viewHolder.headlineFt215ItemUserName = (TextView) convertView.findViewById(R.id.headline_ft215_item_userName);
            viewHolder.headlineFt215ItemSharedtime = (TextView) convertView.findViewById(R.id.headline_ft215_item_sharedtime);
            viewHolder.headlineFt215ItemComment = (TextView) convertView.findViewById(R.id.headline_ft215_item_comment);
            viewHolder.headlineFt215ItemDianzan = (TextView) convertView.findViewById(R.id.headline_ft215_item_dianzan);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
        HeadlineListBean2.DataEntity entity = (HeadlineListBean2.DataEntity) object;
        //设置条目的标题
        holder.headlineFt215ItemTitle.setText( entity.getTitle());
        //设置用户昵称
        String nickName = entity.getNick_name();
        nickName = context.getString(R.string.headline_item_from,nickName);
        holder.headlineFt215ItemUserName.setText(nickName);

        //TODO 设置分享时间,这里还需要细化
        String createtime= entity.getCreated_at();
        createtime = createtime.substring(createtime.lastIndexOf(" ")+1, createtime.length());
        createtime = createtime.substring(0,createtime.lastIndexOf(":"));
        createtime = context.getString(R.string.headline_item_sharetime,createtime);
        holder.headlineFt215ItemSharedtime.setText(createtime);

        //TODO 设置点赞数 这里需要调整数据和图标的距离
        int ups = entity.getUps();
        holder.headlineFt215ItemDianzan.setText(ups+"");

        //TODO 设置点评论数 这里需要调整数据和图标的距离
        int comments = entity.getComments();
        holder.headlineFt215ItemComment.setText(comments+"");

        // TODO: 2016/2/3  设置来自于 这里需要截取有效字段
        String source_url = entity.getSource_url();
        //"source_url": "http://www.wutongwei.com/front/infor_showone.tweb?id=199",
        if (source_url.length()!=0){
            source_url = source_url.substring(0,source_url.lastIndexOf("/"));
        }
        source_url = context.getString(R.string.headline_item_from,source_url);
        holder.headlineFt215ItemFrom.setText(source_url);

        // TODO: 2016/2/3 设置用户头像 设置需要进一步修改头像，成为圆形头像

        String avatar = entity.getAvatar();
        MyAppliction.mBitmapUtils.display(holder.headlineFt215ItemUseriv,avatar);


    }

    protected class ViewHolder {
        private TextView headlineFt215ItemTitle;
    private TextView headlineFt215ItemFrom;
    private ImageView headlineFt215ItemUseriv;
    private TextView headlineFt215ItemUserName;
    private TextView headlineFt215ItemSharedtime;
    private TextView headlineFt215ItemComment;
    private TextView headlineFt215ItemDianzan;
    }
}
