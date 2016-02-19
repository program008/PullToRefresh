package com.qf.csdn.home.my.bean;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public class MyBlogContent {


    /**
     * code : 2000
     * message :
     * data : {"type":"original","id":50585225,"title":"android中信息列表的下拉刷新和下拉加载","username":"program008","is_digged":true,"level":0,"description":"在android的开发中，似乎只要涉及到信息列表都会使用到下拉刷新和下拉加载。可见尤其的重要。一般情况下，我们可以选择第三方库来实现。接下来我们就按部就班来实现我们的这个上拉加载和下拉刷新的功能：\n第一步：准备开发环境\n第三方库：链接地址：http://pan.baidu.com/s/1c0Uvs1E   \n   密码：ujcc\n\n 导入第三方库，将第三方的library，并将其与本运用","can_dig":false,"markdowncontent":null,"articlemore":"","comment_count":0,"tags":"android开发","status":1,"nickname":"program008","is_fav":0,"digg":1,"bury":0,"create_at":"/Date(1453772078000)/","comment_allowed":"true","avatar":"http://avatar.csdn.net/7/0/4/1_program008.jpg","create":"2016-01-26 09:34:38","url":"http://blog.csdn.net/program008/article/details/50585225","articleedittype":0,"content":"","is_buryed":false,"categories":"android开发","markdowndirectory":null,"view_count":9,"channel":0}
     * sessionId : SESSIONID-csdn-ST-11554-IhhF05ZTdHP9lpXDovgt-passport.csdn.net
     * sessionExpired : 1460713202452
     */

    private int code;
    private String message;
    /**
     * type : original
     * id : 50585225
     * title : android中信息列表的下拉刷新和下拉加载
     * username : program008
     * is_digged : true
     * level : 0
     * description : 在android的开发中，似乎只要涉及到信息列表都会使用到下拉刷新和下拉加载。可见尤其的重要。一般情况下，我们可以选择第三方库来实现。接下来我们就按部就班来实现我们的这个上拉加载和下拉刷新的功能：
     第一步：准备开发环境
     第三方库：链接地址：http://pan.baidu.com/s/1c0Uvs1E
     密码：ujcc

     导入第三方库，将第三方的library，并将其与本运用
     * can_dig : false
     * markdowncontent : null
     * articlemore :
     * comment_count : 0
     * tags : android开发
     * status : 1
     * nickname : program008
     * is_fav : 0
     * digg : 1
     * bury : 0
     * create_at : /Date(1453772078000)/
     * comment_allowed : true
     * avatar : http://avatar.csdn.net/7/0/4/1_program008.jpg
     * create : 2016-01-26 09:34:38
     * url : http://blog.csdn.net/program008/article/details/50585225
     * articleedittype : 0
     * content :
     * is_buryed : false
     * categories : android开发
     * markdowndirectory : null
     * view_count : 9
     * channel : 0
     */

    private DataEntity data;
    private String sessionId;
    private String sessionExpired;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionExpired(String sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataEntity getData() {
        return data;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSessionExpired() {
        return sessionExpired;
    }

    public static class DataEntity {
        private String type;
        private int id;
        private String title;
        private String username;
        private boolean is_digged;
        private int level;
        private String description;
        private boolean can_dig;
        private Object markdowncontent;
        private String articlemore;
        private int comment_count;
        private String tags;
        private int status;
        private String nickname;
        private int is_fav;
        private int digg;
        private int bury;
        private String create_at;
        private String comment_allowed;
        private String avatar;
        private String create;
        private String url;
        private int articleedittype;
        private String content;
        private boolean is_buryed;
        private String categories;
        private Object markdowndirectory;
        private int view_count;
        private int channel;

        public void setType(String type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setIs_digged(boolean is_digged) {
            this.is_digged = is_digged;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setCan_dig(boolean can_dig) {
            this.can_dig = can_dig;
        }

        public void setMarkdowncontent(Object markdowncontent) {
            this.markdowncontent = markdowncontent;
        }

        public void setArticlemore(String articlemore) {
            this.articlemore = articlemore;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setIs_fav(int is_fav) {
            this.is_fav = is_fav;
        }

        public void setDigg(int digg) {
            this.digg = digg;
        }

        public void setBury(int bury) {
            this.bury = bury;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public void setComment_allowed(String comment_allowed) {
            this.comment_allowed = comment_allowed;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setArticleedittype(int articleedittype) {
            this.articleedittype = articleedittype;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setIs_buryed(boolean is_buryed) {
            this.is_buryed = is_buryed;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        public void setMarkdowndirectory(Object markdowndirectory) {
            this.markdowndirectory = markdowndirectory;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public String getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getUsername() {
            return username;
        }

        public boolean isIs_digged() {
            return is_digged;
        }

        public int getLevel() {
            return level;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCan_dig() {
            return can_dig;
        }

        public Object getMarkdowncontent() {
            return markdowncontent;
        }

        public String getArticlemore() {
            return articlemore;
        }

        public int getComment_count() {
            return comment_count;
        }

        public String getTags() {
            return tags;
        }

        public int getStatus() {
            return status;
        }

        public String getNickname() {
            return nickname;
        }

        public int getIs_fav() {
            return is_fav;
        }

        public int getDigg() {
            return digg;
        }

        public int getBury() {
            return bury;
        }

        public String getCreate_at() {
            return create_at;
        }

        public String getComment_allowed() {
            return comment_allowed;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getCreate() {
            return create;
        }

        public String getUrl() {
            return url;
        }

        public int getArticleedittype() {
            return articleedittype;
        }

        public String getContent() {
            return content;
        }

        public boolean isIs_buryed() {
            return is_buryed;
        }

        public String getCategories() {
            return categories;
        }

        public Object getMarkdowndirectory() {
            return markdowndirectory;
        }

        public int getView_count() {
            return view_count;
        }

        public int getChannel() {
            return channel;
        }
    }
}
