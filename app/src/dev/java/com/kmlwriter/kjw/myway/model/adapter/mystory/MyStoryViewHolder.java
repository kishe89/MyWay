package com.kmlwriter.kjw.myway.model.adapter.mystory;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmlwriter.kjw.myway.R;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kjw on 2017. 12. 8..
 */

public class MyStoryViewHolder extends MyWayViewHolder<Article> {

    @Nullable @BindView(R.id.profile_image_view) CircleImageView profile_image_view;

    private int viewType;
    private Article mArticle;
    public static MyStoryViewHolder newInstance(Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new MyStoryViewHolder(itemView, context, parent);
    }
    public MyStoryViewHolder(View itemView,Context context,ViewGroup parent) {
        super(itemView);
        setViewType(MyStoryViewType.MY_STORY_VIEW_TYPE.getType());
        ButterKnife.bind(context,itemView);
    }

    @Override
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public void bindData(Article item) {
        mArticle = item;
    }
}
