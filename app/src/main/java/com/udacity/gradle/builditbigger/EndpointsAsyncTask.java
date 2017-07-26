package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.andrew.myapplication.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Andrew on 6/30/17.
 * Taken from:
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 * <p>
 *
 * TODO: Unit test
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static final String rootGceUrl = "https://coral-theme-125214.appspot.com/_ah/api/";
    private static MyApi myApiService = null;

    /*--------------------------------------------
        Interface method
     -------------------------------------------*/
    private Callback mCallbackCaller;

    public void setCallbackCaller(Callback callbackCaller) {
        mCallbackCaller = callbackCaller;
    }

    public interface Callback {
        void requestResponse(String joke);
    }
    /*------------------------------------------*/

    @Override
    protected String doInBackground(Void... p) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(rootGceUrl);
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mCallbackCaller.requestResponse(result);
    }

}
