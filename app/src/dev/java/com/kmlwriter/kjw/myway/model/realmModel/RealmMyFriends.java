package com.kmlwriter.kjw.myway.model.realmModel;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class RealmMyFriends extends RealmObject {
    private String _id;
    private String Nick;
    private String App;
    private String AppId;
    private String Profile;
    private String AccessToken;
    private String DecryptValuel;
    private int __v;
    private RealmList<String> Upload_Article;
    private RealmList<RealmFriendPopulated> Agree_Wait_Friends;
    private RealmList<RealmFriendPopulated> Friends;
}
