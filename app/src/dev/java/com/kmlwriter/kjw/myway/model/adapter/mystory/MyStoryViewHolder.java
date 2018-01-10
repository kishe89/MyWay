package com.kmlwriter.kjw.myway.model.adapter.mystory;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kmlwriter.kjw.myway.R;
import com.kmlwriter.kjw.myway.const_string.ConstString;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.BaseObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kjw on 2017. 12. 8..
 */

public class MyStoryViewHolder extends MyWayViewHolder<Article> {
    private static final String TAG = "bindData";
    private RecyclerView file_view;
    @Nullable @BindView(R.id.profile_image_view) CircleImageView profile_image_view;
    @Nullable @BindView(R.id.nick_text_view) TextView nick_text_view;
    @Nullable @BindView(R.id.timestamp_text_view) TextView timestamp_text_view;
    @Nullable @BindView(R.id.contents_text_view) TextView contents_text_view;

    private int viewType;
    private View root;
    private Bundle ParentsavedInstanceState;
    public static MyStoryViewHolder newInstance(Context context, ViewGroup parent, Bundle savedInstanceState) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new MyStoryViewHolder(itemView, context, parent, savedInstanceState);
    }
    public MyStoryViewHolder(View itemView, Context context, ViewGroup parent, Bundle savedInstanceState) {
        super(itemView);
        setViewType(MyStoryViewType.MY_STORY_VIEW_TYPE.getType());
        ButterKnife.bind(this,itemView);
        root = itemView;
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
        Log.e(TAG,item.toString());
        nick_text_view.setText(item.getPostedBy().getNick());
        timestamp_text_view.setText(item.getUpdatedAt().toString());

        /**
         * @TODO dummy data 다시 입력하고 재확인
         */
        Glide.with(root)
                .load(item.getPostedBy().getProfile())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_menu_gallery)
                        .error(R.drawable.ic_menu_camera)
                )
                .thumbnail(ConstString.NORMAL_IMAGE_THUMBNAIL_PERCENTAGE)
                .into(profile_image_view);
    }
}
