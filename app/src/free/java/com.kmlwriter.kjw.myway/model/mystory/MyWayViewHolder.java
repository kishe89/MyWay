package com.kmlwriter.kjw.myway.model.mystory;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kjw on 2017. 12. 8..
 */

public abstract class MyWayViewHolder<T> extends RecyclerView.ViewHolder {
    public MyWayViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void setViewType(int viewType);
    public abstract int getViewType();
    public abstract void bindData(T item);

}
