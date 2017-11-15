package com.kmlwriter.kjw.myway.model;

import com.kmlwriter.kjw.myway.MyWayApplication;
import com.kmlwriter.kjw.myway.R;

/**
 * Created by kjw on 2017. 11. 15..
 */

public class TestModel {
    private String test;

    public TestModel() {
        this.test = MyWayApplication.getContext().getResources().getString(R.string.test_premium);
    }
    public String getTest() {
        return test;
    }
}
