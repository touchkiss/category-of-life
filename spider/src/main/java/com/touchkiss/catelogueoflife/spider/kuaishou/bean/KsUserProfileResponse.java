package com.touchkiss.catelogueoflife.spider.kuaishou.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 2020/07/24 15:34
 *
 * @author Touchkiss
 */
public class KsUserProfileResponse {

    /**
     * result : 1
     * shareInfo : {"shareTitle":"分享了@快√手⇒518 的快手主页，一起来看！","shareSubTitle":"感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我","shareId":"213000175705","docId":"3","groupName":"","shareType":"3"}
     * host-name : sd-bjpg-rs383.yz02
     * userProfile : {"userSettingOption":{"privacy_location":"0","message_deny":"1","comment_deny":"1","download_deny":"1","auto_save_to_local":"0","not_recommend_to_contacts":"0","not_recommend_to_qq_friends":"0","photo_share_add_watermark":"1","privacy_news":"0","photo_download_deny":"1","missu_deny":"0","privacy_user":"0","wifi_preupload_deny":"0","acquaintance_deny":"0","gift_unfollow":"0","hide_follow_fans_count":"0","show_same_follow_deny":"0","disable_screenshot_feedback":"0","disable_im_online_status":"0","not_share_live_stream_fragment":"0","not_public_collect":"0","show_story_entrance":"0","allow_others_reward_me":"1","not_allow_find_me_by_mobile":"0"},"ownerCount":{"fan":17276,"like":0,"photo":387,"article_public":0,"follow":830,"photo_public":387,"photo_private":0,"collect":0,"moment":2},"showPhotoCollectTab":true,"cityName":"云南 昆明市","cityCode":"530100","constellation":"水瓶座","enableMoment":true,"profile":{"user_name":"快√手⇒518","verified":false,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"bigHeadUrls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"user_profile_bg_urls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"visitorBeFollowed":false,"user_sex":"M","user_profile_bg_url":"https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg","user_id":555258693,"user_text":"感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我","kwaiId":"QQ552310885"},"isSubscribe":false,"isFriend":false,"isFollowing":false,"isFavorited":false,"showCount":true}
     */

    private int result;
    private ShareInfoBean shareInfo;
    @SerializedName("host-name")
    private String hostname;
    private UserProfileBean userProfile;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public ShareInfoBean getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(ShareInfoBean shareInfo) {
        this.shareInfo = shareInfo;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public UserProfileBean getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileBean userProfile) {
        this.userProfile = userProfile;
    }

    public static class ShareInfoBean {
        /**
         * shareTitle : 分享了@快√手⇒518 的快手主页，一起来看！
         * shareSubTitle : 感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我
         * shareId : 213000175705
         * docId : 3
         * groupName :
         * shareType : 3
         */

        private String shareTitle;
        private String shareSubTitle;
        private String shareId;
        private String docId;
        private String groupName;
        private String shareType;

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public String getShareSubTitle() {
            return shareSubTitle;
        }

        public void setShareSubTitle(String shareSubTitle) {
            this.shareSubTitle = shareSubTitle;
        }

        public String getShareId() {
            return shareId;
        }

        public void setShareId(String shareId) {
            this.shareId = shareId;
        }

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getShareType() {
            return shareType;
        }

        public void setShareType(String shareType) {
            this.shareType = shareType;
        }
    }

    public static class UserProfileBean {
        /**
         * userSettingOption : {"privacy_location":"0","message_deny":"1","comment_deny":"1","download_deny":"1","auto_save_to_local":"0","not_recommend_to_contacts":"0","not_recommend_to_qq_friends":"0","photo_share_add_watermark":"1","privacy_news":"0","photo_download_deny":"1","missu_deny":"0","privacy_user":"0","wifi_preupload_deny":"0","acquaintance_deny":"0","gift_unfollow":"0","hide_follow_fans_count":"0","show_same_follow_deny":"0","disable_screenshot_feedback":"0","disable_im_online_status":"0","not_share_live_stream_fragment":"0","not_public_collect":"0","show_story_entrance":"0","allow_others_reward_me":"1","not_allow_find_me_by_mobile":"0"}
         * ownerCount : {"fan":17276,"like":0,"photo":387,"article_public":0,"follow":830,"photo_public":387,"photo_private":0,"collect":0,"moment":2}
         * showPhotoCollectTab : true
         * cityName : 云南 昆明市
         * cityCode : 530100
         * constellation : 水瓶座
         * enableMoment : true
         * profile : {"user_name":"快√手⇒518","verified":false,"headurl":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","headurls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"isFavorited":false,"bigHeadUrls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"user_profile_bg_urls":[{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"visitorBeFollowed":false,"user_sex":"M","user_profile_bg_url":"https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg","user_id":555258693,"user_text":"感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我","kwaiId":"QQ552310885"}
         * isSubscribe : false
         * isFriend : false
         * isFollowing : false
         * isFavorited : false
         * showCount : true
         */

        private UserSettingOptionBean userSettingOption;
        private OwnerCountBean ownerCount;
        private boolean showPhotoCollectTab;
        private String cityName;
        private String cityCode;
        private String constellation;
        private boolean enableMoment;
        private ProfileBean profile;
        private boolean isSubscribe;
        private boolean isFriend;
        private boolean isFollowing;
        private boolean isFavorited;
        private boolean showCount;

        public UserSettingOptionBean getUserSettingOption() {
            return userSettingOption;
        }

        public void setUserSettingOption(UserSettingOptionBean userSettingOption) {
            this.userSettingOption = userSettingOption;
        }

        public OwnerCountBean getOwnerCount() {
            return ownerCount;
        }

        public void setOwnerCount(OwnerCountBean ownerCount) {
            this.ownerCount = ownerCount;
        }

        public boolean isShowPhotoCollectTab() {
            return showPhotoCollectTab;
        }

        public void setShowPhotoCollectTab(boolean showPhotoCollectTab) {
            this.showPhotoCollectTab = showPhotoCollectTab;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public boolean isEnableMoment() {
            return enableMoment;
        }

        public void setEnableMoment(boolean enableMoment) {
            this.enableMoment = enableMoment;
        }

        public ProfileBean getProfile() {
            return profile;
        }

        public void setProfile(ProfileBean profile) {
            this.profile = profile;
        }

        public boolean isIsSubscribe() {
            return isSubscribe;
        }

        public void setIsSubscribe(boolean isSubscribe) {
            this.isSubscribe = isSubscribe;
        }

        public boolean isIsFriend() {
            return isFriend;
        }

        public void setIsFriend(boolean isFriend) {
            this.isFriend = isFriend;
        }

        public boolean isIsFollowing() {
            return isFollowing;
        }

        public void setIsFollowing(boolean isFollowing) {
            this.isFollowing = isFollowing;
        }

        public boolean isIsFavorited() {
            return isFavorited;
        }

        public void setIsFavorited(boolean isFavorited) {
            this.isFavorited = isFavorited;
        }

        public boolean isShowCount() {
            return showCount;
        }

        public void setShowCount(boolean showCount) {
            this.showCount = showCount;
        }

        public static class UserSettingOptionBean {
            /**
             * privacy_location : 0
             * message_deny : 1
             * comment_deny : 1
             * download_deny : 1
             * auto_save_to_local : 0
             * not_recommend_to_contacts : 0
             * not_recommend_to_qq_friends : 0
             * photo_share_add_watermark : 1
             * privacy_news : 0
             * photo_download_deny : 1
             * missu_deny : 0
             * privacy_user : 0
             * wifi_preupload_deny : 0
             * acquaintance_deny : 0
             * gift_unfollow : 0
             * hide_follow_fans_count : 0
             * show_same_follow_deny : 0
             * disable_screenshot_feedback : 0
             * disable_im_online_status : 0
             * not_share_live_stream_fragment : 0
             * not_public_collect : 0
             * show_story_entrance : 0
             * allow_others_reward_me : 1
             * not_allow_find_me_by_mobile : 0
             */

            private String privacy_location;
            private String message_deny;
            private String comment_deny;
            private String download_deny;
            private String auto_save_to_local;
            private String not_recommend_to_contacts;
            private String not_recommend_to_qq_friends;
            private String photo_share_add_watermark;
            private String privacy_news;
            private String photo_download_deny;
            private String missu_deny;
            private String privacy_user;
            private String wifi_preupload_deny;
            private String acquaintance_deny;
            private String gift_unfollow;
            private String hide_follow_fans_count;
            private String show_same_follow_deny;
            private String disable_screenshot_feedback;
            private String disable_im_online_status;
            private String not_share_live_stream_fragment;
            private String not_public_collect;
            private String show_story_entrance;
            private String allow_others_reward_me;
            private String not_allow_find_me_by_mobile;

            public String getPrivacy_location() {
                return privacy_location;
            }

            public void setPrivacy_location(String privacy_location) {
                this.privacy_location = privacy_location;
            }

            public String getMessage_deny() {
                return message_deny;
            }

            public void setMessage_deny(String message_deny) {
                this.message_deny = message_deny;
            }

            public String getComment_deny() {
                return comment_deny;
            }

            public void setComment_deny(String comment_deny) {
                this.comment_deny = comment_deny;
            }

            public String getDownload_deny() {
                return download_deny;
            }

            public void setDownload_deny(String download_deny) {
                this.download_deny = download_deny;
            }

            public String getAuto_save_to_local() {
                return auto_save_to_local;
            }

            public void setAuto_save_to_local(String auto_save_to_local) {
                this.auto_save_to_local = auto_save_to_local;
            }

            public String getNot_recommend_to_contacts() {
                return not_recommend_to_contacts;
            }

            public void setNot_recommend_to_contacts(String not_recommend_to_contacts) {
                this.not_recommend_to_contacts = not_recommend_to_contacts;
            }

            public String getNot_recommend_to_qq_friends() {
                return not_recommend_to_qq_friends;
            }

            public void setNot_recommend_to_qq_friends(String not_recommend_to_qq_friends) {
                this.not_recommend_to_qq_friends = not_recommend_to_qq_friends;
            }

            public String getPhoto_share_add_watermark() {
                return photo_share_add_watermark;
            }

            public void setPhoto_share_add_watermark(String photo_share_add_watermark) {
                this.photo_share_add_watermark = photo_share_add_watermark;
            }

            public String getPrivacy_news() {
                return privacy_news;
            }

            public void setPrivacy_news(String privacy_news) {
                this.privacy_news = privacy_news;
            }

            public String getPhoto_download_deny() {
                return photo_download_deny;
            }

            public void setPhoto_download_deny(String photo_download_deny) {
                this.photo_download_deny = photo_download_deny;
            }

            public String getMissu_deny() {
                return missu_deny;
            }

            public void setMissu_deny(String missu_deny) {
                this.missu_deny = missu_deny;
            }

            public String getPrivacy_user() {
                return privacy_user;
            }

            public void setPrivacy_user(String privacy_user) {
                this.privacy_user = privacy_user;
            }

            public String getWifi_preupload_deny() {
                return wifi_preupload_deny;
            }

            public void setWifi_preupload_deny(String wifi_preupload_deny) {
                this.wifi_preupload_deny = wifi_preupload_deny;
            }

            public String getAcquaintance_deny() {
                return acquaintance_deny;
            }

            public void setAcquaintance_deny(String acquaintance_deny) {
                this.acquaintance_deny = acquaintance_deny;
            }

            public String getGift_unfollow() {
                return gift_unfollow;
            }

            public void setGift_unfollow(String gift_unfollow) {
                this.gift_unfollow = gift_unfollow;
            }

            public String getHide_follow_fans_count() {
                return hide_follow_fans_count;
            }

            public void setHide_follow_fans_count(String hide_follow_fans_count) {
                this.hide_follow_fans_count = hide_follow_fans_count;
            }

            public String getShow_same_follow_deny() {
                return show_same_follow_deny;
            }

            public void setShow_same_follow_deny(String show_same_follow_deny) {
                this.show_same_follow_deny = show_same_follow_deny;
            }

            public String getDisable_screenshot_feedback() {
                return disable_screenshot_feedback;
            }

            public void setDisable_screenshot_feedback(String disable_screenshot_feedback) {
                this.disable_screenshot_feedback = disable_screenshot_feedback;
            }

            public String getDisable_im_online_status() {
                return disable_im_online_status;
            }

            public void setDisable_im_online_status(String disable_im_online_status) {
                this.disable_im_online_status = disable_im_online_status;
            }

            public String getNot_share_live_stream_fragment() {
                return not_share_live_stream_fragment;
            }

            public void setNot_share_live_stream_fragment(String not_share_live_stream_fragment) {
                this.not_share_live_stream_fragment = not_share_live_stream_fragment;
            }

            public String getNot_public_collect() {
                return not_public_collect;
            }

            public void setNot_public_collect(String not_public_collect) {
                this.not_public_collect = not_public_collect;
            }

            public String getShow_story_entrance() {
                return show_story_entrance;
            }

            public void setShow_story_entrance(String show_story_entrance) {
                this.show_story_entrance = show_story_entrance;
            }

            public String getAllow_others_reward_me() {
                return allow_others_reward_me;
            }

            public void setAllow_others_reward_me(String allow_others_reward_me) {
                this.allow_others_reward_me = allow_others_reward_me;
            }

            public String getNot_allow_find_me_by_mobile() {
                return not_allow_find_me_by_mobile;
            }

            public void setNot_allow_find_me_by_mobile(String not_allow_find_me_by_mobile) {
                this.not_allow_find_me_by_mobile = not_allow_find_me_by_mobile;
            }
        }

        public static class OwnerCountBean {
            /**
             * fan : 17276
             * like : 0
             * photo : 387
             * article_public : 0
             * follow : 830
             * photo_public : 387
             * photo_private : 0
             * collect : 0
             * moment : 2
             */

            private int fan;
            private int like;
            private int photo;
            private int article_public;
            private int follow;
            private int photo_public;
            private int photo_private;
            private int collect;
            private int moment;

            public int getFan() {
                return fan;
            }

            public void setFan(int fan) {
                this.fan = fan;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getPhoto() {
                return photo;
            }

            public void setPhoto(int photo) {
                this.photo = photo;
            }

            public int getArticle_public() {
                return article_public;
            }

            public void setArticle_public(int article_public) {
                this.article_public = article_public;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getPhoto_public() {
                return photo_public;
            }

            public void setPhoto_public(int photo_public) {
                this.photo_public = photo_public;
            }

            public int getPhoto_private() {
                return photo_private;
            }

            public void setPhoto_private(int photo_private) {
                this.photo_private = photo_private;
            }

            public int getCollect() {
                return collect;
            }

            public void setCollect(int collect) {
                this.collect = collect;
            }

            public int getMoment() {
                return moment;
            }

            public void setMoment(int moment) {
                this.moment = moment;
            }
        }

        public static class ProfileBean {
            /**
             * user_name : 快√手⇒518
             * verified : false
             * headurl : https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg
             * headurls : [{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_s.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}]
             * isFavorited : false
             * bigHeadUrls : [{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}]
             * user_profile_bg_urls : [{"cdn":"tx2.a.yximgs.com","url":"https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg"},{"cdn":"js2.a.yximgs.com","url":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg","urlPattern":"https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}]
             * visitorBeFollowed : false
             * user_sex : M
             * user_profile_bg_url : https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg
             * user_id : 555258693
             * user_text : 感谢快手官方给予绿色平台！让我认识了很多朋友也学到了很多知识，谢谢。想学私信给我
             * kwaiId : QQ552310885
             */

            private String user_name;
            private boolean verified;
            private String headurl;
            private boolean isFavorited;
            private boolean visitorBeFollowed;
            private String user_sex;
            private String user_profile_bg_url;
            private int user_id;
            private String user_text;
            private String kwaiId;
            private List<HeadurlsBean> headurls;
            private List<BigHeadUrlsBean> bigHeadUrls;
            private List<UserProfileBgUrlsBean> user_profile_bg_urls;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public boolean isVerified() {
                return verified;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public String getHeadurl() {
                return headurl;
            }

            public void setHeadurl(String headurl) {
                this.headurl = headurl;
            }

            public boolean isIsFavorited() {
                return isFavorited;
            }

            public void setIsFavorited(boolean isFavorited) {
                this.isFavorited = isFavorited;
            }

            public boolean isVisitorBeFollowed() {
                return visitorBeFollowed;
            }

            public void setVisitorBeFollowed(boolean visitorBeFollowed) {
                this.visitorBeFollowed = visitorBeFollowed;
            }

            public String getUser_sex() {
                return user_sex;
            }

            public void setUser_sex(String user_sex) {
                this.user_sex = user_sex;
            }

            public String getUser_profile_bg_url() {
                return user_profile_bg_url;
            }

            public void setUser_profile_bg_url(String user_profile_bg_url) {
                this.user_profile_bg_url = user_profile_bg_url;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUser_text() {
                return user_text;
            }

            public void setUser_text(String user_text) {
                this.user_text = user_text;
            }

            public String getKwaiId() {
                return kwaiId;
            }

            public void setKwaiId(String kwaiId) {
                this.kwaiId = kwaiId;
            }

            public List<HeadurlsBean> getHeadurls() {
                return headurls;
            }

            public void setHeadurls(List<HeadurlsBean> headurls) {
                this.headurls = headurls;
            }

            public List<BigHeadUrlsBean> getBigHeadUrls() {
                return bigHeadUrls;
            }

            public void setBigHeadUrls(List<BigHeadUrlsBean> bigHeadUrls) {
                this.bigHeadUrls = bigHeadUrls;
            }

            public List<UserProfileBgUrlsBean> getUser_profile_bg_urls() {
                return user_profile_bg_urls;
            }

            public void setUser_profile_bg_urls(List<UserProfileBgUrlsBean> user_profile_bg_urls) {
                this.user_profile_bg_urls = user_profile_bg_urls;
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

            public static class BigHeadUrlsBean {
                /**
                 * cdn : tx2.a.yximgs.com
                 * url : https://tx2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg
                 * urlPattern : https://js2.a.yximgs.com/uhead/AB/2019/05/23/16/BMjAxOTA1MjMxNjMyMDhfNTU1MjU4NjkzXzJfaGQ4ODNfMzgy_b.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate
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

            public static class UserProfileBgUrlsBean {
                /**
                 * cdn : tx2.a.yximgs.com
                 * url : https://tx2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg
                 * urlPattern : https://js2.a.yximgs.com/uhead/AC/2019/04/29/16/BMjAxOTA0MjkxNjAzMzhfNTU1MjU4NjkzXzJfYmc=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate
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
}
