package com.kmlwriter.kjw.myway.model.realmModel;

import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class RealmFriendPopulated extends RealmObject {
    private String Nick;
    private String App;
    private String AppId;

    public String getNick() {
        return Nick;
    }

    public String getApp() {
        return App;
    }

    public String getAppId() {
        return AppId;
    }

    public RealmFriendPopulated setNick(String nick) {
        Nick = nick;
        return this;
    }

    public RealmFriendPopulated setApp(String app) {
        App = app;
        return this;
    }

    public RealmFriendPopulated setAppId(String appId) {
        AppId = appId;
        return this;
    }

    @Override
    public String toString() {
        return "RealmFriendPopulated{" +
                "Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                '}';
    }
}
