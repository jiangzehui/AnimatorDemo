package com.example.jiangzehui.valueanimatordemo;

import android.animation.TypeEvaluator;

/**
 * Created by jiangzehui on 17/7/25.
 */

public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float time, Point start, Point end) {

        float x = start.getX()+((end.getX()-start.getX())*time);
        float y = start.getY()+((end.getY()-start.getY())*time);
        return new Point(x,y);
    }
}
