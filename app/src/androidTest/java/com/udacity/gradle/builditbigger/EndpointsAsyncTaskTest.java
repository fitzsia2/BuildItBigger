package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Andrew on 7/1/17.
 * Test EndpointAsyncTask class.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.Callback {
    private boolean mComplete;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public final void testExecute() {
        EndpointsAsyncTask eat = new EndpointsAsyncTask();
        eat.setCallbackCaller(this);
        mComplete = false;
        eat.execute();
        while(!mComplete) {}
    }

    @Override
    public void requestResponse(String joke) {
        assert !joke.isEmpty();
        mComplete = true;
    }
}