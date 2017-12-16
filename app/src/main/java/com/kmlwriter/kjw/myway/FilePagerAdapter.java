package com.kmlwriter.kjw.myway;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kjw on 2017. 12. 6..
 */

public class FilePagerAdapter extends FragmentPagerAdapter{
    private int mNumOfTabs;
    public FilePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BlankFragment tab1 = BlankFragment.newInstance("dd","dd");
                return tab1;
            case 1:
                BlankFragment tab2 = BlankFragment.newInstance("dd","dd");
                return tab2;
            case 2:
                BlankFragment tab3 = BlankFragment.newInstance("dd","dd");
                return tab3;
            case 3:
                BlankFragment tab4 = BlankFragment.newInstance("dd","dd");
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
