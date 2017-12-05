package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class Profile implements Serializable {
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
