package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class Friend implements Serializable{
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private ArrayList<String>Friends;
    private int MyFriend;
    private String Profile;

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

    public ArrayList<String> getFriends() {
        return Friends;
    }

    public int getMyFriend() {
        return MyFriend;
    }

    public String getProfile() {
        return Profile;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "_id='" + _id + '\'' +
                ", Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Friends=" + Friends +
                ", MyFriend=" + MyFriend +
                ", Profile='" + Profile + '\'' +
                '}';
    }
}
