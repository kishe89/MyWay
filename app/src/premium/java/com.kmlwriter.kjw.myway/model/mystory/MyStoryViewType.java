package com.kmlwriter.kjw.myway.model.mystory;

/**
 * Created by kjw on 2017. 12. 8..
 */

public enum MyStoryViewType {
    MY_STORY_VIEW_TYPE(1),
    My_STORY_TOP_LOADER_TYPE(2),
    My_STORY_BOTTOM_LOADER_TYPE(3),
    My_IMAGE_VIEW_TYPE(4),
    My_MAP_VIEW_TYPE(5),
    AD_MOB_VIEW_TYPE(6)
    ;

    private int type;

    MyStoryViewType() {
    }

    MyStoryViewType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
