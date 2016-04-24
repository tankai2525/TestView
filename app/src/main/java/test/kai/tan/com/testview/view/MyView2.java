package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jiongbull.jlog.JLog;

/**
 * Created by tankai on 2016/4/24.
 */
public class MyView2 extends View {

    private Paint mPaint1;
    private Paint mPaint2;

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        JLog.d("widthMeasureSpec:" + widthMeasureSpec + "--heightMeasureSpec:" + heightMeasureSpec);
//        JLog.d("getMeasuredWidth:" + getMeasuredWidth() + "--getMeasuredHeight:" + getMeasuredHeight());
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        JLog.d("getMeasuredWidth:" + getMeasuredWidth() + "--getMeasuredHeight:" + getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        JLog.d("onDraw");
        super.onDraw(canvas);
        //把整张画布设置成白色
        canvas.drawColor(Color.BLACK);

        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setTextSize(20);
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
        canvas.drawLine(mWidth/2, 0, mWidth/2, mHeight, mPaint2);

        mPaint2.setColor(Color.WHITE);
        mPaint2.setTextAlign(Paint.Align.CENTER);
        //绘制文字
        String text = "android canvas gj";
        canvas.drawText(text, mWidth/2, mHeight/2, mPaint2);

        //绘制弧线
//        RectF mArc = new RectF();

    }

}
