package com.kbu.exam.gsonparsing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageThread extends Thread{
    private Context context;
    private String page;
    private Bitmap bitmap;
    private Handler handler = new Handler();

    public ImageThread(Context context, String page) {
        this.context = context;
        this.page = page;
    }

    @Override
    public void run() {
        util util = new util();
        try {
            URL url = new URL(page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(4000);
            // 주소 잘못되면 이미지가 안뜸, 이미지가 뜨면 제대로 한거임
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.e("TRAMS_IT_ERROR", util.getLogInfo()+e.getMessage());
                }
            });
        }
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
}
