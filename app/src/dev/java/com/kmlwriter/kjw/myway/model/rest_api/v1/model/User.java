package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;
import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class User implements Serializable {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private String Profile;
    private String AccessToken;
    private String DecryptValuel;
    private int __v;
    private ArrayList<String> Upload_Article;
    private ArrayList<String> Agree_Wait_Friends;
    private ArrayList<String> Friends;

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

    public ArrayList<String> getUpload_Article() {
        return Upload_Article;
    }
    public RealmList<String> getUpload_Article(int i) {
        RealmList<String> list = new RealmList<>();
        for(String item : this.Agree_Wait_Friends){
            list.add(item);
        }
        return list;
    }
    public ArrayList<String> getAgree_Wait_Friends() {
        RealmList<String> list = new RealmList<>();
        for(String item : this.Agree_Wait_Friends){
            list.add(item);
        }
        return Agree_Wait_Friends;
    }
    public RealmList<String> getAgree_Wait_Friends(int i) {
        RealmList<String> list = new RealmList<>();
        for(String item : this.Agree_Wait_Friends){
            list.add(item);
        }
        return list;
    }
    public ArrayList<String> getFriends() {
        return Friends;
    }
    public RealmList<String> getFriends(int i) {
        RealmList<String> list = new RealmList<>();
        for(String item : this.Friends){
            list.add(item);
        }
        return list;
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
