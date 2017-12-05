package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class Friend_Response implements Serializable {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private ArrayList<FriendPopulated> Friends;

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

    public ArrayList<FriendPopulated> getFriends() {
        return Friends;
    }

    @Override
    public String toString() {
        return "Friend_Response{" +
                "_id='" + _id + '\'' +
                ", Nick='" + Nick + '\'' +
                ", App='" + App + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Friends=" + Friends +
                '}';
    }
}
