package com.example.jiangzehui.valueanimatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

    }



    public void click(final View view){
        
        Point p1=new Point(0,0);
        Point p2=new Point(300,300);
        Point p3=new Point(0,0);
        ValueAnimator valueAnimator=ValueAnimator.ofObject(new PointEvaluator(),p1,p2,p3);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point point = (Point) valueAnimator.getAnimatedValue();
                view.setTranslationX(point.getX());
                view.setTranslationY(point.getY());
                //view.postInvalidate();
            }
        });
        valueAnimator.start();


        //旋转
//        ObjectAnimator.ofFloat(view,"rotation",0f,360f,0f).setDuration(2000).start();
//        ObjectAnimator.ofFloat(view,"rotationX",0f,360f,0f).setDuration(2000).start();
//        ObjectAnimator.ofFloat(view,"rotationY",0f,360f,0f).setDuration(2000).start();
//
//        //缩放
//        ObjectAnimator.ofFloat(view,"scaleY",1f,0f,1f).setDuration(2000).start();
//        ObjectAnimator.ofFloat(view,"scaleX",1f,0f,1f).setDuration(2000).start();
//
//        //透明度
//        ObjectAnimator.ofFloat(view,"alpha",1f,0f,1f).setDuration(2000).start();

        //ObjectAnimator.ofFloat(view,"alpha",1f,0f,1f).setDuration(2000).start();

        //平移
        //float x = view.getTranslationX();
//ObjectAnimator.ofFloat(view,"translationX",x,-500f,x).setDuration(2000).start();

        //组合动画
//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
//        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
//        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
//        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(200).start();


//        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", -500f, 0f);
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(rotate).with(fadeInOut).after(moveIn);
//        animSet.setDuration(5000);
//        animSet.start();
    }
}
