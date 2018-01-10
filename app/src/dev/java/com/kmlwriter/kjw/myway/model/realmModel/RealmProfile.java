package com.kmlwriter.kjw.myway.model.realmModel;

import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class RealmProfile extends RealmObject {
    private String Nick;
    private String App;
    private String AppId;
    private String Profile;

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
        return "Profile{" +
                "Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Profile='" + Profile + '\'' +
                '}';
    }
}
