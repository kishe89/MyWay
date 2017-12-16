package com.kmlwriter.kjw.myway.model.adapter.mystory;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.kmlwriter.kjw.myway.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kjw on 2017. 12. 15..
 */

public class MapViewHolder extends MyWayViewHolder<String> implements OnMapReadyCallback {

    @Nullable @BindView(R.id.map_view) MapView map_view;

    private int viewType;
    private GoogleMap map;
    private Bundle ParentsavedInstanceState;
    public MapViewHolder(View itemView, Context mContext, ViewGroup parent, Bundle savedInstanceState) {
        super(itemView);
        setViewType(MyStoryViewType.My_MAP_VIEW_TYPE.getType());
        ButterKnife.bind(mContext,itemView);
        this.ParentsavedInstanceState = savedInstanceState;
        map_view.onCreate(ParentsavedInstanceState);


    }

    @Override
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getViewType() {
        return this.viewType;
    }

    @Override
    public void bindData(String item) {
        map_view.getMapAsync(this);
    }

    public static MapViewHolder newInstance(Context mContext, ViewGroup parent, Bundle savedInstanceState) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new MapViewHolder(itemView, mContext, parent, savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
