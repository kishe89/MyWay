package com.kmlwriter.kjw.myway.model.mystory;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmlwriter.kjw.myway.R;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.BaseObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kjw on 2017. 12. 8..
 */

public class MyStoryViewHolder extends MyWayViewHolder<Article> {

    private RecyclerView file_view;
    @Nullable @BindView(R.id.profile_image_view) CircleImageView profile_image_view;
    @Nullable @BindView(R.id.nick_text_view) TextView nick_text_view;
    @Nullable @BindView(R.id.timestamp_text_view) TextView timestamp_text_view;
    @Nullable @BindView(R.id.contents_text_view) TextView contents_text_view;

    private int viewType;
    private Bundle ParentsavedInstanceState;
    public static MyStoryViewHolder newInstance(Context context, ViewGroup parent, Bundle savedInstanceState) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new MyStoryViewHolder(itemView, context, parent, savedInstanceState);
    }
    public MyStoryViewHolder(View itemView, Context context, ViewGroup parent, Bundle savedInstanceState) {
        super(itemView);
        setViewType(MyStoryViewType.MY_STORY_VIEW_TYPE.getType());
        ButterKnife.bind(context,itemView);
        file_view =(RecyclerView)itemView.findViewById(R.id.file_view);
        this.ParentsavedInstanceState = savedInstanceState;
    }

    public void setFileAdapter(Context context, Article article){
        file_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        FileAdapter fileAdapter = new FileAdapter(context, article.getFilesURI(),ParentsavedInstanceState);
        file_view.setAdapter(fileAdapter);
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
        Log.e("bindData",item.toString());
        Log.e("bindData",item.getPostedBy().toString());
        nick_text_view.setText(item.getPostedBy().getNick());
    }
}
