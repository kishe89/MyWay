package com.kmlwriter.kjw.myway;

import android.app.Application;
import android.content.Context;

import com.kmlwriter.kjw.myway.const_string.ConstString;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by kjw on 2017. 11. 15..
 */

public class MyWayApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        byte[] key = new byte[64];
//        new SecureRandom().nextBytes(key);
//
//        Log.i("RealmEncryptionKey", Util.bytesToHex(key));
//        try {
//            KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
//            ks.setKeyEntry("RealmEncryptionKey",key,);
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//        Realm.init(mContext);
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .name(ConstString.REALM_NAME)
//                .encryptionKey(key)
//                .build();
        Realm.init(mContext);

    }
    public static Context getContext() {
        return mContext;
    }
}
