package com.qf.csdn.home.my.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public class MyBlogItem {

    /**
     * code : 2000
     * message :
     * data : [{"blogId":5600505,"articleId":50585225,"title":"android中信息列表的下拉刷新和下拉加载","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"在android的开发中，似乎只要涉及到信息列表都会使用到下拉刷新和下拉加载。可见尤其的重要。一般情况下，我们可以选择第三方库来实现。接下来我们就按部就班来实现我们的这个上拉加载和下拉刷新的功能：第一步：准备开发环境第三方库：链接地址：http://pan.baidu.com/s/1c0Uvs1E     密码：ujcc 导入第三方库，将第三方的library，并将其与本运用","viewCount":9,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453772078000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50579286,"title":"PopupWindow弹出窗的简单实现","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"PopupWindow这个类用来实现一个弹出框，可以使用任意布局的View作为其内容，这个弹出框是悬浮在当前activity之上的。那么想学习吗？如果想的话，那咋们一起来学习弹出窗的具体的实现步骤吧！","viewCount":14,"digg":0,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453696840000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50569971,"title":"android高级框架xUtils之HttpUtils","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"xUtils简介：\r\rxUtils 是一个工具类的集合体，其中包含许多实用的Android工具，主要包含四大模块： \r1、\rViewUtils的模块（点击进入）\r2、 HttpUtils的模块 \r3、 \rBitmap的模块（点击进入）\r\r4、DbUtils的模块（点击进入）\r\r\r现在开始学习HttpUtils，同样咋们还是以三部曲的方式来阐述这个问题：\r一、添加权","viewCount":15,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453534508000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50569762,"title":"android高级框架xUtils之BitmapUtils","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"xutils简介：xUtils 是一个工具类的集合体，其中包含许多实用的Android工具，主要包含四大模块： 1、ViewUtils的模块2、 HttpUtils的模块 3、 BitmapUtils的模块 4、 DBUtils的模块现在我们来正式学习BitmapUtils，同样我们也通过三个步骤来学习：一、添加权限二、创建Bitmap","viewCount":19,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453531722000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50569617,"title":"android高级框架xUtils之DbUtils","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"android高级框架之xUtils之DbUtils，将我们对数据库的操作变得更加简便。减少了我们写数据库操作的语句","viewCount":13,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453529714000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50569145,"title":"android高级框架xUtils之ViewUtils","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"xUtils 是一个工具类的集合体，其中包含许多实用的Android工具，使用这些工具将给我们的编程带来很多方便","viewCount":12,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453520475000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50568965,"title":"android高级之图片二次采样","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"默认情况下，bitmap每个像素点占用4个字节（ARGB_8888），比如一张3543×3503的图片差不多在内存中占用47M，安卓系统给每个应用分配的内存都是有限的，可以使用Runtime.getRuntime().maxMemory()来获取。内存有限空间，默认情况下图片存储又需要大量的空间，于是就容易产生OOM（内存溢出），所有我们不得不对图片进行处理，这样便可以减少图片占用的内存空间","viewCount":14,"digg":0,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453517638000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50568462,"title":"android高级控件之Volley","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"2013年GoogleI/O大会上推出了一个新的网络通信框架\u2014\u2014Volley，它的设计目标就是非常适合去进行数据量不大，但通信频繁的网络操作。","viewCount":14,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453512514000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50564176,"title":"android高级技术之相机的前后摄像头切换","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"android高级技术之相机的前后摄像头切换，赶快做一个自己开发的相机自拍吧","viewCount":15,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453466931000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50563944,"title":"编码和加密算法的使用（MD5、Base64、DES、RSA）","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"编码和加密算法的使用和简介（MD5、Base64、DES、RSA）","viewCount":16,"digg":0,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453463107000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50563853,"title":"NavigationView和DrawerLayout实现侧滑菜单栏","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"android高级之NavigationView和DrawerLayout实现侧滑菜单栏(抽屉）","viewCount":14,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453461430000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50557533,"title":"android开发之二维码","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"生活中二维码扫描的例子并不少见，比如微信，QQ，支付宝，还有很多社交网站和购物网站，都会加入二维码扫描技术。可想而知这个技术是那么的重要。下面是笔者在学习中的一些总结。","viewCount":13,"digg":0,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453379981000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50557296,"title":"android开发之Camera（相机）","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"android高级中的一个很重要的技术，关于相机的开发，笔者认真的学习，将具体的开发过程步骤与诸君共享之","viewCount":14,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453377029000)/","url":null,"channelId":0},{"blogId":5600505,"articleId":50553669,"title":"Android高级Picasso","userName":"program008","nickname":"program008","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","description":"Picasso不仅实现了图片异步加载的功能，还解决了android中加载图片时需要解决的一些常见问题：  1.在adapter中需要取消已经不在视野范围的ImageView图片资源的加载，否则会导致图片错位，Picasso已经解决了这个问题。  2.使用复杂的","viewCount":15,"digg":1,"bury":0,"commentCount":0,"tags":"","postTime":"/Date(1453344387000)/","url":null,"channelId":0}]
     * sessionId :
     * sessionExpired : 1455508685257
     */

    private int code;
    private String message;
    private String sessionId;
    private String sessionExpired;
    /**
     * blogId : 5600505
     * articleId : 50585225
     * title : android中信息列表的下拉刷新和下拉加载
     * userName : program008
     * nickname : program008
     * avatar : http://avatar.csdn.net/7/0/4/1_program008.jpg
     * description : 在android的开发中，似乎只要涉及到信息列表都会使用到下拉刷新和下拉加载。可见尤其的重要。一般情况下，我们可以选择第三方库来实现。接下来我们就按部就班来实现我们的这个上拉加载和下拉刷新的功能：第一步：准备开发环境第三方库：链接地址：http://pan.baidu.com/s/1c0Uvs1E     密码：ujcc 导入第三方库，将第三方的library，并将其与本运用
     * viewCount : 9
     * digg : 1
     * bury : 0
     * commentCount : 0
     * tags :
     * postTime : /Date(1453772078000)/
     * url : null
     * channelId : 0
     */

    private List<DataEntity> data;

    public static MyBlogItem objectFromData(String str) {

        return new Gson().fromJson(str, MyBlogItem.class);
    }

    public static MyBlogItem objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), MyBlogItem.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<MyBlogItem> arrayMyBlogItemFromData(String str) {

        Type listType = new TypeToken<ArrayList<MyBlogItem>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<MyBlogItem> arrayMyBlogItemFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<MyBlogItem>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionExpired(String sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSessionExpired() {
        return sessionExpired;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private int blogId;
        private int articleId;
        private String title;
        private String userName;
        private String nickname;
        private String avatar;
        private String description;
        private int viewCount;
        private int digg;
        private int bury;
        private int commentCount;
        private String tags;
        private String postTime;
        private Object url;
        private int channelId;

        public static DataEntity objectFromData(String str) {

            return new Gson().fromJson(str, DataEntity.class);
        }

        public static DataEntity objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataEntity.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataEntity> arrayDataEntityFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataEntity>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataEntity> arrayDataEntityFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataEntity>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public void setBlogId(int blogId) {
            this.blogId = blogId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public void setDigg(int digg) {
            this.digg = digg;
        }

        public void setBury(int bury) {
            this.bury = bury;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public void setPostTime(String postTime) {
            this.postTime = postTime;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getBlogId() {
            return blogId;
        }

        public int getArticleId() {
            return articleId;
        }

        public String getTitle() {
            return title;
        }

        public String getUserName() {
            return userName;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getDescription() {
            return description;
        }

        public int getViewCount() {
            return viewCount;
        }

        public int getDigg() {
            return digg;
        }

        public int getBury() {
            return bury;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public String getTags() {
            return tags;
        }

        public String getPostTime() {
            return postTime;
        }

        public Object getUrl() {
            return url;
        }

        public int getChannelId() {
            return channelId;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "blogId=" + blogId +
                    ", articleId=" + articleId +
                    ", title='" + title + '\'' +
                    ", userName='" + userName + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", description='" + description + '\'' +
                    ", viewCount=" + viewCount +
                    ", digg=" + digg +
                    ", bury=" + bury +
                    ", commentCount=" + commentCount +
                    ", tags='" + tags + '\'' +
                    ", postTime='" + postTime + '\'' +
                    ", url=" + url +
                    ", channelId=" + channelId +
                    '}';
        }
    }
}
