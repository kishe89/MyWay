package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;

import io.realm.RealmModel;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class FriendPopulated implements Serializable,RealmModel {
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

    @Override
    public String toString() {
        return "FriendPopulated{" +
                "Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                '}';
    }
}
