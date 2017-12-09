package com.kmlwriter.kjw.myway.loading_view;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.kmlwriter.kjw.myway.R;

/**
 * Created by kjw on 2017. 12. 9..
 */

public class Loading_wait_dialog extends Dialog {

    private Context mContext;

    public Loading_wait_dialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public Loading_wait_dialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Loading_wait_dialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//        lpWindow.dimAmount = 1.0f;
        lpWindow.alpha = 1.0f;
        lpWindow.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lpWindow.width = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lpWindow);
        getWindow().setBackgroundDrawableResource(R.drawable.loading_dialog_background);
        setContentView(R.layout.file_save_loading_view);
    }
}
