package com.example.jiangzehui.valueanimatordemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import java.text.DecimalFormat;


/**
 * Created by jzh on 16/8/27.
 */
public class ProgressView extends View {


    private int progress = 0;
    private Paint paint;
    private RectF rf;
    Shader shader;

    //当前温度
    private String nowWd = "当前温度";
    private float wd_width ,wd_height;
    private Paint wd_paint;


    //当前温度值
    private float maxValue = 40f;
    private float value = 28.5f;
    private float value_width ,value_height;
    private Paint value_paint;
    private Rect value_rect=new Rect();


    private DecimalFormat df = new DecimalFormat("#.0");



    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化绘制进度条的画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);//在画笔的连接处是圆滑的
        paint.setStrokeCap(Paint.Cap.ROUND);//在画笔的起始处是圆滑的
        paint.setPathEffect(new CornerPathEffect(10));//画笔效果
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);


        wd_paint = new Paint();
        wd_paint.setAntiAlias(true);
        wd_paint.setColor(0xff000000);
        wd_paint.setTextSize(dp_px(16));

        value_paint = new Paint();
        value_paint.setAntiAlias(true);
        value_paint.setColor(0xff000000);
        value_paint.setTextSize(dp_px(22));



    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制进度条
        paint.setAlpha(100);
        canvas.drawArc(rf, 130, 280, false, paint);

        paint.setAlpha(255);
        canvas.drawArc(rf, 130, progress, false, paint);
        canvas.drawText(nowWd,wd_width,wd_height,wd_paint);

        //计算value并绘制
        value_paint.getTextBounds(df.format(value)+"℃",0,(df.format(value)+"℃").length(),value_rect);
        value_width = getWidth()/2-value_rect.width()/2;
        value_height =getHeight()/2-value_rect.height()/2;
        canvas.drawText(df.format(value)+"℃",value_width,value_height,value_paint);

    }

    /**
     * 设置数值
     * @param value
     */
    public void setValue(float value) {
        this.value = value;
        progress = (int) (280/maxValue*value);
        startAnim();
    }


    /**
     * 动画
     */
    private void startAnim() {

        ValueAnimator mNumAnim = ValueAnimator.ofInt(0, progress);
        mNumAnim.setDuration(2000);
        //mNumAnim.setRepeatCount(-1);
        mNumAnim.setInterpolator(new BounceInterpolator());
        mNumAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                progress = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mNumAnim.start();




        ValueAnimator mValAnim = ValueAnimator.ofFloat(0, value);
        mValAnim.setDuration(2000);
        //mValAnim.setRepeatCount(-1);
        mValAnim.setInterpolator(new BounceInterpolator());
        mValAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                value = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mValAnim.start();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Rect rt = new Rect();
        wd_paint.getTextBounds(nowWd,0,nowWd.length(),rt);
        wd_width = getWidth() / 2-rt.width()/2;
        wd_height = getHeight() / 2-2*rt.height();
        rf = new RectF(getPaddingLeft(), getPaddingTop(), getWidth()-getPaddingRight(), getHeight()-getPaddingBottom());


    }

    /**
     * dp转px
     *
     * @param values
     * @return
     */
    public int dp_px(int values)
    {

        float density = getResources().getDisplayMetrics().density;
        return (int) (values * density + 0.5f);
    }


}

