package test.kai.tan.com.testview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.jiongbull.jlog.JLog;

/**
 * 了解view的测量onMeasure
 * Created by tankai on 2016/4/24.
 */
public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        JLog.d("widthMeasureSpec:" + widthMeasureSpec + "--heightMeasureSpec:" + heightMeasureSpec);
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        //提取测量模式
        int specMode = MeasureSpec.getMode(measureSpec);
        //提取测量大小
        int specSize = MeasureSpec.getSize(measureSpec);
        JLog.d("specMode:" + specMode + "--specSize:" + specSize);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        //提取测量模式
        int specMode = MeasureSpec.getMode(measureSpec);
        //提取测量大小
        int specSize = MeasureSpec.getSize(measureSpec);

        JLog.d("specMode:" + specMode + "--specSize:" + specSize);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }


}
