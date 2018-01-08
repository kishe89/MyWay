package com.kmlwriter.kjw.myway.model.realmModel;

/**
 * Created by kjw on 2017. 12. 8..
 */

public class BaseObject{
    private int viewType;

    public BaseObject() {
    }

    public BaseObject(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }
}
