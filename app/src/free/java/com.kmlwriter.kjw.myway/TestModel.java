package com.kmlwriter.kjw.myway;

/**
 * Created by kjw on 2017. 11. 15..
 */

public class TestModel {
    private String test;

    public TestModel() {
        this.test = MyWayApplication.getContext().getResources().getString(R.string.test_free);
    }
    public String getTest() {
        return test;
    }
}