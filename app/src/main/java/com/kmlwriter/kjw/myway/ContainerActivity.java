package com.kmlwriter.kjw.myway;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;

public class ContainerActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, TabLayout.OnTabSelectedListener {

    private TabLayout tab_layout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        viewPager = (ViewPager) findViewById(R.id.pager);

        View tab_layout_view = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.tab_layout_contents, null, false);
        tab_layout = (TabLayout)findViewById(R.id.tab_layout);
        setTab(tab_layout_view);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.addOnTabSelectedListener(this);
    }

    private void setTab(View tab_layout_view) {
        tab_layout.setSelectedTabIndicatorHeight(0);
        tab_layout.addTab(tab_layout.newTab().setCustomView((LottieAnimationView) tab_layout_view.findViewById(R.id.timeLineFragmentButton)));
        tab_layout.addTab(tab_layout.newTab().setCustomView((LottieAnimationView) tab_layout_view.findViewById(R.id.locationSaveFragmentButton)));
        tab_layout.addTab(tab_layout.newTab().setCustomView((LottieAnimationView) tab_layout_view.findViewById(R.id.fileSearchFragmentButton)));
        tab_layout.addTab(tab_layout.newTab().setCustomView((LottieAnimationView) tab_layout_view.findViewById(R.id.moreFragmentButton)));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
