package com.android.media;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.tv_time);
        long l1 = getIntent().getLongExtra("time", 0);
        long l2 = System.currentTimeMillis();
        tv.setText("打开页面耗时（ms）：" + (l2 - l1));
    }


}
