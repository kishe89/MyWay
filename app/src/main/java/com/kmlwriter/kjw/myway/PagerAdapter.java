package com.kmlwriter.kjw.myway;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjw on 2017. 12. 6..
 */

public class PagerAdapter extends FragmentPagerAdapter{
    private int mNumOfTabs;
    public PagerAdapter(FragmentManager fm,int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BlankFragment tab1 = new BlankFragment();
                return tab1;
            case 1:
                BlankFragment tab2 = new BlankFragment();
                return tab2;
            case 2:
                BlankFragment tab3 = new BlankFragment();
                return tab3;
            case 3:
                BlankFragment tab4 = new BlankFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
