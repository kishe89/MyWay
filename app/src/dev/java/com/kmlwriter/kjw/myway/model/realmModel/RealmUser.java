package com.kmlwriter.kjw.myway.model.realmModel;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class RealmUser extends RealmObject {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private String Profile;
    private String AccessToken;
    private String DecryptValuel;
    private int __v;
    private RealmList<String> Upload_Article;
    private RealmList<String> Agree_Wait_Friends;
    private RealmList<String> Friends;

    public RealmUser set_id(String _id) {
        this._id = _id;
        return this;
    }

    public RealmUser setNick(String nick) {
        Nick = nick;
        return this;
    }

    public RealmUser setApp(String app) {
        App = app;
        return this;
    }

    public RealmUser setAppId(String appId) {
        AppId = appId;
        return this;
    }

    public RealmUser setProfile(String profile) {
        Profile = profile;
        return this;
    }

    public RealmUser setAccessToken(String accessToken) {
        AccessToken = accessToken;
        return this;
    }

    public RealmUser setDecryptValuel(String decryptValuel) {
        DecryptValuel = decryptValuel;
        return this;
    }

    public RealmUser set__v(int __v) {
        this.__v = __v;
        return this;
    }

    public RealmUser setUpload_Article(RealmList<String> upload_Article) {
        Upload_Article = upload_Article;
        return this;
    }

    public RealmUser setAgree_Wait_Friends(RealmList<String> agree_Wait_Friends) {
        Agree_Wait_Friends = agree_Wait_Friends;
        return this;
    }

    public RealmUser setFriends(RealmList<String> friends) {
        Friends = friends;
        return this;
    }

    public String get_id() {
        return _id;
    }

    public String getNick() {
        return Nick;
    }

    public String getApp() {
        return App;
    }

    public String getAppId() {
        return AppId;
    }

    public String getProfile() {
        return Profile;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public String getDecryptValuel() {
        return DecryptValuel;
    }

    public int get__v() {
        return __v;
    }

    public RealmList<String> getUpload_Article() {
        return Upload_Article;
    }

    public RealmList<String> getAgree_Wait_Friends() {
        return Agree_Wait_Friends;
    }

    public RealmList<String> getFriends() {
        return Friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Profile='" + Profile + '\'' +
                ", AccessToken='" + AccessToken + '\'' +
                ", DecryptValuel='" + DecryptValuel + '\'' +
                ", __v=" + __v +
                ", Upload_Article=" + Upload_Article +
                ", Agree_Wait_Friends=" + Agree_Wait_Friends +
                ", Friends=" + Friends +
                '}';
    }
}
