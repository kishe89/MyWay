package com.kmlwriter.kjw.myway.model.realmModel;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class RealmFriend extends RealmObject{
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private RealmList<String> Friends;
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

    public RealmList<String> getFriends() {
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
