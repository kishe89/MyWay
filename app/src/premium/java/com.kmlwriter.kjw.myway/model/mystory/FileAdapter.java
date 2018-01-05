package com.kmlwriter.kjw.myway.model.mystory;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by kjw on 2017. 12. 15..
 */

public class FileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mItems;
    private Bundle ParentsavedInstanceState;
    public FileAdapter(Context mContext, ArrayList<String> mItems, Bundle savedInstanceState) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.ParentsavedInstanceState = savedInstanceState;
    }

    public ArrayList<String> getmItems() {
        return mItems;
    }

    public void setmItems(ArrayList<String> mItems) {
        this.mItems = mItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == MyStoryViewType.My_MAP_VIEW_TYPE.getType()){
            return MapViewHolder.newInstance(mContext,parent,ParentsavedInstanceState);
        }else if(viewType == MyStoryViewType.My_IMAGE_VIEW_TYPE.getType()) {
            return ImageViewHolder.newInstance(mContext, parent);
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
