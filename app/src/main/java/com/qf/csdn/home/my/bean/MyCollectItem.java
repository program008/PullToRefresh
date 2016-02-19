package com.qf.csdn.home.my.bean;

import java.util.List;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public class MyCollectItem {


    /**
     * code : 2000
     * message :
     * data : {"data":[{"id":"9738493","share":"0","title":"PopupWindow弹出窗的简单实现","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1455518232","url":"http://blog.csdn.net/program008/article/details/50579286"},{"id":"9678360","share":"0","title":"天使轮、A轮、B轮\u2026\u2026IPO 创业公司在融资不同阶段是如何估值的？","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454229503","url":"http://geek.csdn.net/news/detail/54143"},{"id":"9676030","share":"0","title":"Java nio 概述","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454194557","url":"http://geek.csdn.net/news/detail/54090"},{"id":"9672507","share":"0","title":"Android内存泄漏相关","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454128899","url":"http://geek.csdn.net/news/detail/53969"},{"id":"9672462","share":"0","title":"Listview控件使用技巧大汇总","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128196","url":"http://blog.csdn.net/yousheng324/article/details/7370911"},{"id":"9672453","share":"0","title":"ListView中的getChildAt(int)的注意事项","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128076","url":"http://blog.csdn.net/maxwell_nc/article/details/49465415"},{"id":"9672454","share":"0","title":"ListView中的getChildAt(int)的注意事项","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128076","url":"http://blog.csdn.net/maxwell_nc/article/details/49465415"},{"id":"9672425","share":"0","title":"ListView设置点击效果","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454127466","url":"http://blog.csdn.net/tody_guo/article/details/7481341"},{"id":"9672421","share":"0","title":"Android ListView批量选择（全选、反选、全不选）","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454127273","url":"http://geek.csdn.net/news/detail/50305"},{"id":"9654877","share":"0","title":"每个架构师都应该研究下康威定律","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1453905504","url":"http://geek.csdn.net/news/detail/53446"}],"success":1}
     * sessionId : SESSIONID-csdn-ST-2871-EzxtGHPb4KoQOa4PRfIm-passport.csdn.net
     * sessionExpired : 1460723200966
     */

    private int code;
    private String message;
    /**
     * data : [{"id":"9738493","share":"0","title":"PopupWindow弹出窗的简单实现","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1455518232","url":"http://blog.csdn.net/program008/article/details/50579286"},{"id":"9678360","share":"0","title":"天使轮、A轮、B轮\u2026\u2026IPO 创业公司在融资不同阶段是如何估值的？","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454229503","url":"http://geek.csdn.net/news/detail/54143"},{"id":"9676030","share":"0","title":"Java nio 概述","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454194557","url":"http://geek.csdn.net/news/detail/54090"},{"id":"9672507","share":"0","title":"Android内存泄漏相关","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454128899","url":"http://geek.csdn.net/news/detail/53969"},{"id":"9672462","share":"0","title":"Listview控件使用技巧大汇总","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128196","url":"http://blog.csdn.net/yousheng324/article/details/7370911"},{"id":"9672453","share":"0","title":"ListView中的getChildAt(int)的注意事项","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128076","url":"http://blog.csdn.net/maxwell_nc/article/details/49465415"},{"id":"9672454","share":"0","title":"ListView中的getChildAt(int)的注意事项","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454128076","url":"http://blog.csdn.net/maxwell_nc/article/details/49465415"},{"id":"9672425","share":"0","title":"ListView设置点击效果","username":"program008","description":"","domain":"blog.csdn.net","dateline":"1454127466","url":"http://blog.csdn.net/tody_guo/article/details/7481341"},{"id":"9672421","share":"0","title":"Android ListView批量选择（全选、反选、全不选）","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1454127273","url":"http://geek.csdn.net/news/detail/50305"},{"id":"9654877","share":"0","title":"每个架构师都应该研究下康威定律","username":"program008","description":"","domain":"geek.csdn.net","dateline":"1453905504","url":"http://geek.csdn.net/news/detail/53446"}]
     * success : 1
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
        private int success;
        /**
         * id : 9738493
         * share : 0
         * title : PopupWindow弹出窗的简单实现
         * username : program008
         * description :
         * domain : blog.csdn.net
         * dateline : 1455518232
         * url : http://blog.csdn.net/program008/article/details/50579286
         */

        private List<DataEntityCollect> data;

        public void setSuccess(int success) {
            this.success = success;
        }

        public void setData(List<DataEntityCollect> data) {
            this.data = data;
        }

        public int getSuccess() {
            return success;
        }

        public List<DataEntityCollect> getData() {
            return data;
        }

        public static class DataEntityCollect {
            private String id;
            private String share;
            private String title;
            private String username;
            private String description;
            private String domain;
            private String dateline;
            private String url;

            public void setId(String id) {
                this.id = id;
            }

            public void setShare(String share) {
                this.share = share;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public String getShare() {
                return share;
            }

            public String getTitle() {
                return title;
            }

            public String getUsername() {
                return username;
            }

            public String getDescription() {
                return description;
            }

            public String getDomain() {
                return domain;
            }

            public String getDateline() {
                return dateline;
            }

            public String getUrl() {
                return url;
            }

            @Override
            public String toString() {
                return "DataEntityCollect{" +
                        "id='" + id + '\'' +
                        ", share='" + share + '\'' +
                        ", title='" + title + '\'' +
                        ", username='" + username + '\'' +
                        ", description='" + description + '\'' +
                        ", domain='" + domain + '\'' +
                        ", dateline='" + dateline + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }
    }
}
