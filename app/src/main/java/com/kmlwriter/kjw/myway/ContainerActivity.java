package com.kmlwriter.kjw.myway;

import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class ContainerActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, TabLayout.OnTabSelectedListener, ValueAnimator.AnimatorUpdateListener {

    private TabLayout tab_layout;
    private ViewPager viewPager;
    private LottieAnimationView timeLineFragmentButton;
    private LottieAnimationView locationSaveFragmentButton;
    private LottieAnimationView fileSearchFragmentButton;
    private LottieAnimationView moreFragmentButton;
    private ArrayList<LottieAnimationView> AnimationButtonArray;
    private LottieAnimationView currentAnimationView;
    private RelativeLayout timeLineFragmentButton_Container;
    private RelativeLayout locationSaveFragmentButton_Container;
    private RelativeLayout fileSearchFragmentButton_Container;
    private RelativeLayout moreFragmentButton_Container;

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
        AnimationButtonArray = new ArrayList<>();

        timeLineFragmentButton_Container = (RelativeLayout) tab_layout_view.findViewById(R.id.timeLineFragmentButton_Container);
        locationSaveFragmentButton_Container = (RelativeLayout) tab_layout_view.findViewById(R.id.locationSaveFragmentButton_Container);
        fileSearchFragmentButton_Container = (RelativeLayout) tab_layout_view.findViewById(R.id.fileSearchFragmentButton_Container);
        moreFragmentButton_Container = (RelativeLayout) tab_layout_view.findViewById(R.id.moreFragmentButton_Container);

        timeLineFragmentButton = (LottieAnimationView) tab_layout_view.findViewById(R.id.timeLineFragmentButton);
        locationSaveFragmentButton = (LottieAnimationView) tab_layout_view.findViewById(R.id.locationSaveFragmentButton);
        fileSearchFragmentButton = (LottieAnimationView) tab_layout_view.findViewById(R.id.fileSearchFragmentButton);
        moreFragmentButton = (LottieAnimationView) tab_layout_view.findViewById(R.id.moreFragmentButton);

        locationSaveFragmentButton.setProgress(0.5f);

        AnimationButtonArray.add(timeLineFragmentButton);
        AnimationButtonArray.add(locationSaveFragmentButton);
        AnimationButtonArray.add(fileSearchFragmentButton);
        AnimationButtonArray.add(moreFragmentButton);

        tab_layout.setSelectedTabIndicatorHeight(6);
        tab_layout.addTab(tab_layout.newTab().setCustomView(timeLineFragmentButton_Container));
        tab_layout.addTab(tab_layout.newTab().setCustomView(locationSaveFragmentButton_Container));
        tab_layout.addTab(tab_layout.newTab().setCustomView(fileSearchFragmentButton_Container));
        tab_layout.addTab(tab_layout.newTab().setCustomView(moreFragmentButton_Container));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        float animation_end_position = 1.0f;

        /**
         * this if is before animated currentAnimationView's status check
         */
        if(currentAnimationView != null){
            if(currentAnimationView.isAnimating()){
                currentAnimationView.cancelAnimation();
            }
            if(currentAnimationView.getId()==R.id.locationSaveFragmentButton){
                currentAnimationView.setProgress(0.5f);
            }else{
                currentAnimationView.setProgress(0.0f);
            }
        }

        currentAnimationView = AnimationButtonArray.get(position);
        if (currentAnimationView.isAnimating()) {
            // Do something.
            currentAnimationView.cancelAnimation();
        }else{
            currentAnimationView.setProgress(0.0f);

            ValueAnimator animator = ValueAnimator.ofFloat(0.0f, animation_end_position)
                    .setDuration(1000);
            animator.addUpdateListener(this);
            animator.start();
        }
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        if(currentAnimationView != null){
            currentAnimationView.setProgress((Float) animation.getAnimatedValue());
            if(currentAnimationView.getId()==R.id.locationSaveFragmentButton){
                if(currentAnimationView.getProgress()==1.0)currentAnimationView.setProgress(0.5f);
            }
        }
    }
}
