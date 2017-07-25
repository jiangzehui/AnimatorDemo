package com.example.jiangzehui.valueanimatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Demo1Activity extends AppCompatActivity {
    ProgressView pv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pv = (ProgressView) findViewById(R.id.pv);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Demo1Activity.this,Demo2Activity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        pv.setValue(38.8f);
    }
}
