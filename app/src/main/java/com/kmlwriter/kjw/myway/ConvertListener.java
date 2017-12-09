package com.kmlwriter.kjw.myway;

import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import retrofit2.Call;

/**
 * Created by kjw on 2017. 12. 9..
 */

public interface ConvertListener {
    void ConvertSuccess(Call<User> call);
}
