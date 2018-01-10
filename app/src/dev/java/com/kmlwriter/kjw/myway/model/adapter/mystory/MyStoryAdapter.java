package com.kmlwriter.kjw.myway.model.adapter.mystory;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;

import java.util.ArrayList;

/**
 * Created by kjw on 2017. 12. 8..
 */

public class MyStoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Article> mArticles;

    /**
     * @TODO view type 어떻게 처리할지 생각해보기
     * private ArrayList<AddMob> mAddMob;
     * private ArrayList<Object> mList;
     */

    private Context mContext;
    private Bundle ParentsavedInstanceState;
    public MyStoryAdapter(Context mContext, Bundle savedInstanceState) {
        this.mArticles = new ArrayList<>();
        this.mContext = mContext;
        this.ParentsavedInstanceState = savedInstanceState;
    }

    public ArrayList<Article> getmArticles() {
        return mArticles;
    }

    public void setmArticles(ArrayList<Article> mArticles) {
        this.mArticles = mArticles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if(viewType == MyStoryViewType.MY_STORY_VIEW_TYPE.getType()){
            return MyStoryViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }else if(viewType == MyStoryViewType.My_STORY_TOP_LOADER_TYPE.getType()){
            return MyStoryViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }else if(viewType == MyStoryViewType.My_STORY_BOTTOM_LOADER_TYPE.getType()){
            return MyStoryViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }else if(viewType == MyStoryViewType.AD_MOB_VIEW_TYPE.getType()){
            return MyStoryViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }else{
            return MyStoryViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(((MyWayViewHolder)holder).getViewType()==MyStoryViewType.MY_STORY_VIEW_TYPE.getType()){
            ((MyWayViewHolder) holder).bindData(mArticles.get(position));
            ((MyStoryViewHolder) holder).setFileAdapter(mContext, mArticles.get(position));
        } else if(((MyWayViewHolder)holder).getViewType()==MyStoryViewType.My_STORY_TOP_LOADER_TYPE.getType()){
            ((MyWayViewHolder) holder).bindData(mArticles.get(position));

        } else if(((MyWayViewHolder)holder).getViewType()==MyStoryViewType.My_STORY_BOTTOM_LOADER_TYPE.getType()){
            ((MyWayViewHolder) holder).bindData(mArticles.get(position));

        } else if(((MyWayViewHolder)holder).getViewType()==MyStoryViewType.AD_MOB_VIEW_TYPE.getType()){
            ((MyWayViewHolder) holder).bindData(mArticles.get(position));
        } else{
            ((MyWayViewHolder) holder).bindData(mArticles.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mArticles.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

}
