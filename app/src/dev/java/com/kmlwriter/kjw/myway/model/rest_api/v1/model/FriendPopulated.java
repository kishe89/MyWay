package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class FriendPopulated implements Serializable {
    private String Nick;
    private String App;
    private String AppId;

    public FriendPopulated setNick(String nick) {
        Nick = nick;
        return this;
    }

    public FriendPopulated setApp(String app) {
        App = app;
        return this;
    }

    public FriendPopulated setAppId(String appId) {
        AppId = appId;
        return this;
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

    @Override
    public String toString() {
        return "FriendPopulated{" +
                "Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                '}';
    }
}
