package com.touchkiss.catelogueoflife.spider.kuaishou.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 2020/07/24 15:30
 *
 * @author Touchkiss
 */
public class KsSearchUserResponse {

    /**
     * result : 1
     * pcursor : 1
     * host-name : sd-bjpg-rs768.yz02
     * ussid : MzAwXzgzNDUzNjI1OF8xNTk1NTc1Nzg3ODM1X18zMjE0
     * users : [{"kwaiId":"QQ552310885","following":false,"verified":false,"visitorBeFollowed":false,"user_id":555258693,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我","user_name":"快√手⇒518"},{"kwaiId":"hhh882028","following":false,"verified":false,"visitorBeFollowed":false,"user_id":1033252925,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/06/26/09/BMjAxOTA2MjYwOTUyNTVfMTAzMzI1MjkyNV8yX2hkNTQ1Xzk3OQ==_s.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/06/26/09/BMjAxOTA2MjYwOTUyNTVfMTAzMzI1MjkyNV8yX2hkNTQ1Xzk3OQ==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/06/26/09/BMjAxOTA2MjYwOTUyNTVfMTAzMzI1MjkyNV8yX2hkNTQ1Xzk3OQ==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/06/26/09/BMjAxOTA2MjYwOTUyNTVfMTAzMzI1MjkyNV8yX2hkNTQ1Xzk3OQ==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"🙏️感谢快手提供绿色平台🙏️\n🙏️爱官方   求热门🙏️🙏️\n 💦️每天更新作品💦️\n💦️余生请多指教💦️\n   关注了就是我的人了！\n     爱你们吆\nVV:ZHANG11161105","user_name":"🕶️🕶阳光早上好👄"},{"following":false,"verified":false,"privacy":true,"visitorBeFollowed":false,"user_id":811095823,"headurl":"https://static.yximgs.com/s1/i/def/head_f.png","user_sex":"F","headurls":[{"cdn":"static.yximgs.com","url":"https://static.yximgs.com/s1/i/def/head_f.png"}],"isFavorited":false,"user_text":"快手官方","user_name":"梅子早上好"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":1420711775,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/07/12/20/BMjAxOTA3MTIyMDExMTdfMTQyMDcxMTc3NV8yX2hkOTExXzM1NA==_s.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/07/12/20/BMjAxOTA3MTIyMDExMTdfMTQyMDcxMTc3NV8yX2hkOTExXzM1NA==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/07/12/20/BMjAxOTA3MTIyMDExMTdfMTQyMDcxMTc3NV8yX2hkOTExXzM1NA==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/07/12/20/BMjAxOTA3MTIyMDExMTdfMTQyMDcxMTc3NV8yX2hkOTExXzM1NA==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"早上好5508"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":1102884789,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/06/18/17/BMjAxOTA2MTgxNzIxMDJfMTEwMjg4NDc4OV8yX2hkMTI3XzYyOA==_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/06/18/17/BMjAxOTA2MTgxNzIxMDJfMTEwMjg4NDc4OV8yX2hkMTI3XzYyOA==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/06/18/17/BMjAxOTA2MTgxNzIxMDJfMTEwMjg4NDc4OV8yX2hkMTI3XzYyOA==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/06/18/17/BMjAxOTA2MTgxNzIxMDJfMTEwMjg4NDc4OV8yX2hkMTI3XzYyOA==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"朋友，早上好，"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":1257971437,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/02/18/19/BMjAxOTAyMTgxOTQ1NThfMTI1Nzk3MTQzN18yX2hkODg5XzUxNw==_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/02/18/19/BMjAxOTAyMTgxOTQ1NThfMTI1Nzk3MTQzN18yX2hkODg5XzUxNw==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/02/18/19/BMjAxOTAyMTgxOTQ1NThfMTI1Nzk3MTQzN18yX2hkODg5XzUxNw==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/02/18/19/BMjAxOTAyMTgxOTQ1NThfMTI1Nzk3MTQzN18yX2hkODg5XzUxNw==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"早上好一天好心情"},{"following":false,"verified":false,"privacy":true,"visitorBeFollowed":false,"user_id":978630125,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/12/27/23/BMjAxOTEyMjcyMzM0MTdfOTc4NjMwMTI1XzJfaGQyM18xMjA=_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/12/27/23/BMjAxOTEyMjcyMzM0MTdfOTc4NjMwMTI1XzJfaGQyM18xMjA=_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/12/27/23/BMjAxOTEyMjcyMzM0MTdfOTc4NjMwMTI1XzJfaGQyM18xMjA=_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/12/27/23/BMjAxOTEyMjcyMzM0MTdfOTc4NjMwMTI1XzJfaGQyM18xMjA=_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"小孩子学校:","user_name":"我想你早上好"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":584962279,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2017/07/17/18/BMjAxNzA3MTcxODM1MTNfNTg0OTYyMjc5XzJfaGQ3NTZfOTQw.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2017/07/17/18/BMjAxNzA3MTcxODM1MTNfNTg0OTYyMjc5XzJfaGQ3NTZfOTQw.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2017/07/17/18/BMjAxNzA3MTcxODM1MTNfNTg0OTYyMjc5XzJfaGQ3NTZfOTQw.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2017/07/17/18/BMjAxNzA3MTcxODM1MTNfNTg0OTYyMjc5XzJfaGQ3NTZfOTQw.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"早上好086"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":148574903,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2017/07/10/12/BMjAxNzA3MTAxMjE5MjlfMTQ4NTc0OTAzXzJfaGQxODhfMjg4.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2017/07/10/12/BMjAxNzA3MTAxMjE5MjlfMTQ4NTc0OTAzXzJfaGQxODhfMjg4.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2017/07/10/12/BMjAxNzA3MTAxMjE5MjlfMTQ4NTc0OTAzXzJfaGQxODhfMjg4.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2017/07/10/12/BMjAxNzA3MTAxMjE5MjlfMTQ4NTc0OTAzXzJfaGQxODhfMjg4.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"[早上好]1"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":941343175,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2018/06/23/20/BMjAxODA2MjMyMDU3MjdfOTQxMzQzMTc1XzJfaGQ3NV80NQ==_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2018/06/23/20/BMjAxODA2MjMyMDU3MjdfOTQxMzQzMTc1XzJfaGQ3NV80NQ==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2018/06/23/20/BMjAxODA2MjMyMDU3MjdfOTQxMzQzMTc1XzJfaGQ3NV80NQ==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2018/06/23/20/BMjAxODA2MjMyMDU3MjdfOTQxMzQzMTc1XzJfaGQ3NV80NQ==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"没什么好说的","user_name":"早上好，你和世界🎈"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":134090405,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/03/19/18/BMjAxOTAzMTkxODUwMDlfMTM0MDkwNDA1XzFfaGQ5MjBfNDE0_s.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/03/19/18/BMjAxOTAzMTkxODUwMDlfMTM0MDkwNDA1XzFfaGQ5MjBfNDE0_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/03/19/18/BMjAxOTAzMTkxODUwMDlfMTM0MDkwNDA1XzFfaGQ5MjBfNDE0_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/03/19/18/BMjAxOTAzMTkxODUwMDlfMTM0MDkwNDA1XzFfaGQ5MjBfNDE0_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"海就像蓝天白云","user_name":"ＡＡＡ早上好☀️"},{"kwaiId":"kanhua1314521","following":false,"verified":false,"visitorBeFollowed":false,"user_id":311004815,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2018/12/08/11/BMjAxODEyMDgxMTIwMjVfMzExMDA0ODE1XzJfaGQ1ODlfNDY=_s.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2018/12/08/11/BMjAxODEyMDgxMTIwMjVfMzExMDA0ODE1XzJfaGQ1ODlfNDY=_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2018/12/08/11/BMjAxODEyMDgxMTIwMjVfMzExMDA0ODE1XzJfaGQ1ODlfNDY=_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2018/12/08/11/BMjAxODEyMDgxMTIwMjVfMzExMDA0ODE1XzJfaGQ1ODlfNDY=_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"胖妹早上好"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":1208841487,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/01/28/19/BMjAxOTAxMjgxOTI2MTVfMTIwODg0MTQ4N18yX2hkODA3XzQ2Nw==_s.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/01/28/19/BMjAxOTAxMjgxOTI2MTVfMTIwODg0MTQ4N18yX2hkODA3XzQ2Nw==_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/01/28/19/BMjAxOTAxMjgxOTI2MTVfMTIwODg0MTQ4N18yX2hkODA3XzQ2Nw==_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/01/28/19/BMjAxOTAxMjgxOTI2MTVfMTIwODg0MTQ4N18yX2hkODA3XzQ2Nw==_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"我没有什么介绍的，就是个什么都爱好。喜欢快乐开心，谈论事情的定意！","user_name":"早上好7752"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":651066277,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/06/30/18/BMjAxOTA2MzAxODAyMTRfNjUxMDY2Mjc3XzFfaGQ0NjdfNDYz_s.jpg","user_sex":"F","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/06/30/18/BMjAxOTA2MzAxODAyMTRfNjUxMDY2Mjc3XzFfaGQ0NjdfNDYz_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/06/30/18/BMjAxOTA2MzAxODAyMTRfNjUxMDY2Mjc3XzFfaGQ0NjdfNDYz_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/06/30/18/BMjAxOTA2MzAxODAyMTRfNjUxMDY2Mjc3XzFfaGQ0NjdfNDYz_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"","user_name":"_小小早上好"},{"following":false,"verified":false,"visitorBeFollowed":false,"user_id":2956199,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2014/12/19/04/BMjAxNDEyMTkwNDEyMDFfMjk1NjE5OV8yX2hkOTE=.jpg","user_sex":"M","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2014/12/19/04/BMjAxNDEyMTkwNDEyMDFfMjk1NjE5OV8yX2hkOTE=.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2014/12/19/04/BMjAxNDEyMTkwNDEyMDFfMjk1NjE5OV8yX2hkOTE=.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2014/12/19/04/BMjAxNDEyMTkwNDEyMDFfMjk1NjE5OV8yX2hkOTE=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"user_text":"世事可畏 有米无炊","user_name":"早上好一鸣君"}]
     */

    private int result;
    private String pcursor;
    @SerializedName("host-name")
    private String hostname;
    private String ussid;
    private List<UsersBean> users;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getPcursor() {
        return pcursor;
    }

    public void setPcursor(String pcursor) {
        this.pcursor = pcursor;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUssid() {
        return ussid;
    }

    public void setUssid(String ussid) {
        this.ussid = ussid;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public static class UsersBean {
        /**
         * kwaiId : QQ552310885
         * following : false
         * verified : false
         * visitorBeFollowed : false
         * user_id : 555258693
         * headurl : https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg
         * user_sex : M
         * headurls : [{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}]
         * isFavorited : false
         * user_text : 感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我
         * user_name : 快√手⇒518
         * privacy : true
         */

        private String kwaiId;
        private boolean following;
        private boolean verified;
        private boolean visitorBeFollowed;
        private int user_id;
        private String headurl;
        private String user_sex;
        private boolean isFavorited;
        private String user_text;
        private String user_name;
        private boolean privacy;
        private List<HeadurlsBean> headurls;

        public String getKwaiId() {
            return kwaiId;
        }

        public void setKwaiId(String kwaiId) {
            this.kwaiId = kwaiId;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public boolean isVisitorBeFollowed() {
            return visitorBeFollowed;
        }

        public void setVisitorBeFollowed(boolean visitorBeFollowed) {
            this.visitorBeFollowed = visitorBeFollowed;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getHeadurl() {
            return headurl;
        }

        public void setHeadurl(String headurl) {
            this.headurl = headurl;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public boolean isIsFavorited() {
            return isFavorited;
        }

        public void setIsFavorited(boolean isFavorited) {
            this.isFavorited = isFavorited;
        }

        public String getUser_text() {
            return user_text;
        }

        public void setUser_text(String user_text) {
            this.user_text = user_text;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public boolean isPrivacy() {
            return privacy;
        }

        public void setPrivacy(boolean privacy) {
            this.privacy = privacy;
        }

        public List<HeadurlsBean> getHeadurls() {
            return headurls;
        }

        public void setHeadurls(List<HeadurlsBean> headurls) {
            this.headurls = headurls;
        }

        public static class HeadurlsBean {
            /**
             * cdn : tx2.a.yximgs.com
             * url : https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg
             * urlPattern : https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate
             */

            private String cdn;
            private String url;
            private String urlPattern;

            public String getCdn() {
                return cdn;
            }

            public void setCdn(String cdn) {
                this.cdn = cdn;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrlPattern() {
                return urlPattern;
            }

            public void setUrlPattern(String urlPattern) {
                this.urlPattern = urlPattern;
            }
        }
    }
}
