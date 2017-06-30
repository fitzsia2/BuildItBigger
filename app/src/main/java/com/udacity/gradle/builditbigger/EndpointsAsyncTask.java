package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.andrew.myapplication.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Andrew on 6/30/17.
 * Taken from:
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;


    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://coral-theme-125214.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        mContext = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, com.example.lamejokeactivity.MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, result);
        mContext.startActivity(intent);
    }
}
