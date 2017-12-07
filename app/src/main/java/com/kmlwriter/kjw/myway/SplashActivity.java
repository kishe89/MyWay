package com.kmlwriter.kjw.myway;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(),3000);
    }
    private class splashhandler implements Runnable{
        public void run() {
            Intent intent = new Intent(context,MainActivity.class);
            context.startActivity(intent);
            context.finish();
        }
    }
}
