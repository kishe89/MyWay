package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class MyFriends implements Serializable {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private String Profile;
    private String AccessToken;
    private String DecryptValuel;
    private int __v;
    private ArrayList<String> Upload_Article;
    private ArrayList<FriendPopulated> Agree_Wait_Friends;
    private ArrayList<FriendPopulated> Friends;
}
