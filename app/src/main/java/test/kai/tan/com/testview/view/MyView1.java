package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jiongbull.jlog.JLog;

/**
 * 绘制文字，圆，直线，弧线，
 * Created by tankai on 2016/4/24.
 */
public class MyView1 extends View {

    private Paint mPaint0;
    private Paint mPaint1;
    private Paint mPaint2;

    //new一个控件时候调用
    public MyView1(Context context) {
        super(context);
    }

    //layout布局中调用，attrs封装了所有属性
    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        JLog.d("onDraw");
        super.onDraw(canvas);
        //把整张画布设置成白色
        canvas.drawColor(Color.BLACK);
        mPaint0 = new Paint();
        mPaint0.setColor(Color.WHITE);
        mPaint0.setStyle(Paint.Style.STROKE);
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setTextSize(60);
        mPaint2.setStyle(Paint.Style.FILL);

        JLog.d("getMeasuredWidth:" + getMeasuredWidth() + "--getMeasuredHeight:" + getMeasuredHeight());
        int mWidth = getMeasuredWidth();
        int mHeight = getMeasuredHeight();

        //绘制实心圆
        float mRadius = mWidth / 4;
        //参数cx cy 是指圆心相对于父容器左上角的坐标（以父容器为原点）
        canvas.drawCircle(mWidth / 2, mHeight / 2, mRadius, mPaint1);
        //绘制水平基线
        canvas.drawLine(0, mHeight / 2, mWidth, mHeight / 2, mPaint2);
        //绘制垂直基线
        canvas.drawLine(mWidth / 2, 0, mWidth / 2, mHeight, mPaint2);

        mPaint2.setColor(Color.WHITE);
//        mPaint2.setTextAlign(Paint.Align.CENTER);

        //绘制文字
        String text = "android canvas gj";
        Rect mArc = new Rect();
        Log.d("tag", "rect1:" + mArc.left + "-" + mArc.top + "-" + mArc.right + "-" + mArc.bottom);
        mPaint2.getTextBounds(text, 0, text.length(), mArc);
        Log.d("tag", "rect2:" + mArc.left + "-" + mArc.top + "-" + mArc.right + "-" + mArc.bottom);
//        canvas.drawText(text, 0, 0, mPaint2);
        canvas.drawText(text, mWidth / 2, mHeight / 2, mPaint2);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawRect(mArc, mPaint0);
//        canvas.drawRect(10,10,20,20,mPaint0);
//        mPaint2.setColor(Color.YELLOW);
        //绘制矩形
//        canvas.drawRect(10,20,100,100, mPaint2);

        //

    }

}
