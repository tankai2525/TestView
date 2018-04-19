package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 了解view的绘制流程
 */
public class MyView extends View {

    public MyView(Context context) {
        super(context);
        log("MyView(Context context)");
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        log("MyView(Context context, AttributeSet attrs)");
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        log("MyView(Context context, AttributeSet attrs, int defStyleAttr)");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log("onMeasure:" + widthMeasureSpec + "#" + heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        log("onSizeChanged:" + w + "#" + h + "##" + oldw + "#" + oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        log("onLayout:" + changed + "#" + left + "##" + top + "#" + right + "#" + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        log("onDraw");
    }

    private void log(String text) {
        Log.d("MyView", "---" + text);
    }
}
