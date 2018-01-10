package com.kmlwriter.kjw.myway;

import com.kmlwriter.kjw.myway.model.realmModel.RealmFriendPopulated;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.FriendPopulated;

import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Created by kjw on 2018. 1. 9..
 */

public class Converter {
    public RealmList FromStringArrayList(ArrayList<String> list){
        RealmList<String> result = new RealmList<>();
        for(String item : list){
            result.add(item);
        }
        return result;
    }
    public RealmList FromPopulatedFriendArray(ArrayList<FriendPopulated> list){
        RealmList<RealmFriendPopulated> result = new RealmList<>();
        for(FriendPopulated item : list){
            result.add(new RealmFriendPopulated()
                    .setApp(item.getApp())
                    .setAppId(item.getAppId())
                    .setNick(item.getNick())
            );
        }
        return result;
    }
}
