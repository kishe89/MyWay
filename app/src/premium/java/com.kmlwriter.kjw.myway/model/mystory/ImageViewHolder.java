package com.kmlwriter.kjw.myway.model.mystory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmlwriter.kjw.myway.R;

import butterknife.ButterKnife;

/**
 * Created by kjw on 2017. 12. 15..
 */

public class ImageViewHolder extends MyWayViewHolder<String> {
    private int viewType;

    public static ImageViewHolder newInstance(Context mContext, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ImageViewHolder(itemView, mContext, parent);
    }

    public ImageViewHolder(View itemView, Context mContext, ViewGroup parent) {
        super(itemView);
        setViewType(MyStoryViewType.My_IMAGE_VIEW_TYPE.getType());
        ButterKnife.bind(mContext,itemView);
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

    }
}
