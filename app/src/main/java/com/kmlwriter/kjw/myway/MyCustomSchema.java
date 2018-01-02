package com.kmlwriter.kjw.myway;

import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import io.realm.annotations.RealmModule;

/**
 * Created by kjw on 2018. 1. 2..
 */
@RealmModule(classes = {Article.class,User.class})
public class MyCustomSchema {
}
