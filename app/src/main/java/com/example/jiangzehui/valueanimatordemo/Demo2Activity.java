package com.example.jiangzehui.valueanimatordemo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
    }



    public void click(View view){
        //eg1
        ObjectAnimator.ofFloat(view,"rotationX",0f,360f).setDuration(2000).start();
        ObjectAnimator.ofFloat(view,"rotationY",0f,360f).setDuration(2000).start();
        ObjectAnimator.ofFloat(view,"alpha",1f,0f,1f).setDuration(2000).start();


        //eg2
//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
//        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
//        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
//        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(200).start();
    }
}
