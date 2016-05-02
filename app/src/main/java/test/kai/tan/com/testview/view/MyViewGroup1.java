package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

import com.jiongbull.jlog.JLog;

/**
 * 自定义ViewGroup
 * Created by tankai on 2016/4/25.
 */
public class MyViewGroup1 extends ViewGroup {

    private Scroller mScroller;
    private int mWidth;
    private int mHeight;
    private int mWidth1;
    private int mHeight1;

    public MyViewGroup1(Context context) {
        super(context);
        init(context);
    }

    public MyViewGroup1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyViewGroup1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        //获取屏幕宽高，有几种方法
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        //第一种方法
        mWidth = wm.getDefaultDisplay().getWidth();
        mHeight = wm.getDefaultDisplay().getHeight();
        JLog.d("第一种方法:" + mWidth + "-" + mHeight);

        //第二种方法
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mWidth1 = dm.widthPixels;
        mHeight1 = dm.heightPixels;
        JLog.d("第二种方法:" + mWidth1 + "-" + mHeight1);

        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //设置ViewGroup的高度
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mHeight * childCount;
        //在relativilayout中无效
        setLayoutParams(mlp);
        JLog.d("onLayout：" + getHeight());
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                child.layout(l, i * mHeight, r, (i + 1) * mHeight);
            }
        }
    }

    int mStart = 0;
    int mLastY = 0;
    int mEnd = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        JLog.d("onTouchEvent");
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                JLog.d("action_down：" + mLastY + "-" + mStart);
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = mEnd - mStart;
                if (dScrollY > 0) {
                    if (dScrollY < mHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, mHeight - dScrollY);
                    }
                } else {
                    if (-dScrollY < mHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, mHeight - dScrollY);
                    }else {
                        mScroller.startScroll(0,getScrollY(),0,-mHeight - dScrollY);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mHeight) {
                    dy = 0;
                }
                JLog.d("action_move：" + dy + "-" + getScrollY() + "-" + getHeight());
                scrollBy(0, dy);
                mLastY = y;
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}