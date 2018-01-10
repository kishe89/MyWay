package com.kmlwriter.kjw.myway.model.realmModel;

import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 15..
 */

public class RealmPostedByUser extends RealmObject {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
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

    public String getProfile() {
        return Profile;
    }

    @Override
    public String toString() {
        return "PostedBy{" +
                "_id='" + _id + '\'' +
                ", Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Profile='" + Profile + '\'' +
                '}';
    }
}
