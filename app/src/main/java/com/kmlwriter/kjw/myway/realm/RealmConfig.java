package com.kmlwriter.kjw.myway.realm;

import com.kmlwriter.kjw.myway.MyCustomSchema;
import com.kmlwriter.kjw.myway.const_string.ConstString;

import io.realm.RealmConfiguration;

/**
 * Created by kjw on 2018. 1. 2..
 */

public class RealmConfig {
    private RealmConfiguration myConfig;
    public static RealmConfiguration newInstance(){
        return new RealmConfig().myConfig;
    }
    public RealmConfig() {
        myConfig = new RealmConfiguration.Builder()
                .name(ConstString.REALM_NAME)
                .schemaVersion(1)
                .modules(new MyCustomSchema())
                .build();
    }
}
