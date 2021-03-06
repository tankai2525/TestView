package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * 绘制两层背景
 * Created by tankai on 2016/4/24.
 */
public class MyTextView1 extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;

    public MyTextView1(Context context) {
        super(context);
        initView(context);
    }

    public MyTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint3 = new Paint();
        mPaint3.setColor(Color.RED);
        mPaint3.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        canvas.translate(50,0);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawText("canvas",0,5,mPaint3);
    }
}
