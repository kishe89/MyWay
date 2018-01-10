package com.kmlwriter.kjw.myway;

import com.kmlwriter.kjw.myway.model.realmModel.RealmArticle;
import com.kmlwriter.kjw.myway.model.realmModel.RealmPostedByUser;
import com.kmlwriter.kjw.myway.model.realmModel.RealmUser;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.BaseObject;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import io.realm.annotations.RealmModule;

/**
 * Created by kjw on 2018. 1. 2..
 */
@RealmModule(classes = {RealmArticle.class,RealmUser.class, RealmPostedByUser.class})
public class MyCustomSchema {
}
