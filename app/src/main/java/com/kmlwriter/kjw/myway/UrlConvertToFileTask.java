package com.kmlwriter.kjw.myway;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.facebook.Profile;
import com.kmlwriter.kjw.myway.const_string.ConstString;
import com.kmlwriter.kjw.myway.loading_view.Account_Save_WaitDialog;
import com.kmlwriter.kjw.myway.model.rest_api.v1.UsersAPI;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by kjw on 2017. 12. 9..
 */

public class UrlConvertToFileTask extends AsyncTask<Void,Void,Void> {

    private Activity self;
    private Profile profile;
    private UsersAPI UserApi;
    private URL url;
    private File profile_File;
    private ConvertListener listener;
    private Account_Save_WaitDialog wait_dialog;
    public UrlConvertToFileTask(Activity self,Profile profile,URL url,ConvertListener listener) {
        this.self = self;
        this.profile = profile;
        this.url = url;
        this.listener = listener;
        this.wait_dialog = new Account_Save_WaitDialog(self);
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            InputStream profile_input_stream = url.openConnection().getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            String path=createDirectory();
            profile_File= new File(path,"profile.jpg");
            FileOutputStream writer = new FileOutputStream(profile_File);

            while ((len = profile_input_stream.read(buffer)) > 0) {
                writer.write(buffer, 0, len);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.e("isfinishing",self.isFinishing()+"");
        if(!wait_dialog.isShowing()&& !self.isFinishing()){
            wait_dialog.dismiss();
            wait_dialog.show();
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Handler hd = new Handler();
        hd.postDelayed(new WaitDialogHandler(),3000);
        UserApi = ServiceGenerator.createRetrofitService(UsersAPI.class);
        RequestBody Nick = RequestBody.create(MultipartBody.FORM, profile.getName());
        RequestBody App = RequestBody.create(MultipartBody.FORM, ConstString.Authorization_FACEBOOK);
        RequestBody AppId = RequestBody.create(MultipartBody.FORM, profile.getId());
        RequestBody Profile = RequestBody.create(MediaType.parse("image/*"),profile_File);
        MultipartBody.Part body = MultipartBody.Part.createFormData("Profile", profile_File.getName(), Profile);
        Call<User> call = UserApi.SignUp(Nick, App, AppId, body);
        if(listener!=null){
            listener.ConvertSuccess(call);
        }else{
            Toast.makeText(self,"예기치 않은 오류 발생. 재시작 해주세요.",Toast.LENGTH_SHORT).show();
            self.finish();
            return;
        }

    }
    private String createDirectory(){
        String sdcard= Environment.getExternalStorageDirectory().getAbsolutePath();
        String dirPath = sdcard+"/MyWay";
        File dir = new File(dirPath);
        if( !dir.exists() ) dir.mkdirs();
        else {
            int result = deleteDir(dirPath);
            dir.mkdirs();
        }
        return dirPath;
    }
    public int deleteDir(String a_path){
        File file = new File(a_path);
        if(file.exists()){
            File[] childFileList = file.listFiles();
            for(File childFile : childFileList){
                if(childFile.isDirectory()){
                    deleteDir(childFile.getAbsolutePath());
                }
                else{
                    Log.e("DeleteFile",childFile.getAbsolutePath());
                    childFile.delete();
                }
            }
            file.delete();
            return 1;
        }else{
            return 0;
        }
    }

    private class WaitDialogHandler implements Runnable {
        @Override
        public void run() {
            if(wait_dialog.isShowing()&& !self.isFinishing())
            wait_dialog.dismiss();
        }
    }

    public boolean waitDialog_isShowing(){
        return wait_dialog.isShowing();
    }
    public void waitDialog_dismiss(){
        if(wait_dialog != null)
        wait_dialog.dismiss();
    }
}
