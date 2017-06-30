package com.example.lamejokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamejoke);
        Bundle bundle = getIntent().getExtras();
        String e = bundle.getString(EXTRA_MESSAGE, "error");

        TextView tv = (TextView) findViewById(R.id.lame_joke_text_view);
        tv.setText(e);
    }
}
