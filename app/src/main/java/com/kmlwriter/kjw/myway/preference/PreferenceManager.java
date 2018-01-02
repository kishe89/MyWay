package com.kmlwriter.kjw.myway.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.kmlwriter.kjw.myway.R;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;


/**
 * Created by kjw on 16. 8. 21..
 */
public class PreferenceManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;


    public PreferenceManager(Context context) {
        this.context = context;
        pref=context.getSharedPreferences(context.getString(R.string.app_name),context.MODE_PRIVATE);
        editor = pref.edit();
    }
    public boolean saveUserInfo(User user){
        editor.putString("_id",user.get_id());
        editor.putString("accesstoken",user.getAccessToken());
        editor.putString("Nick",user.getNick());
        return editor.commit();
    }
}
