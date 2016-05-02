package test.kai.tan.com.testview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.jiongbull.jlog.JLog;

/**
 * 了解view的测量onMeasure
 * Created by tankai on 2016/4/24.
 */
public class MyViewOnMeasure extends View {

    public MyViewOnMeasure(Context context) {
        super(context);
    }

    public MyViewOnMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewOnMeasure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        //告诉系统画一个多大的view
        JLog.d("widthMeasureSpec:" + widthMeasureSpec + "--heightMeasureSpec:" + heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        /*
        android提供了一个短小精悍却强大的类——MeasureSpec类，来帮助我们测量View
        MeasureSpec是一个32位的int值，其中高2位为测量模式，低30位为测量大小。
        测量模式有三种
        1 EXACTLY ：宽高为match_parent或指定具体数值的时候，系统会使用这种模式
        2 AT_MOST ：宽高为wrap_content的时候
        3 UNSPECIFIED
         */

        int result = 0;
        //拿到测量模式
        int specMode = MeasureSpec.getMode(measureSpec);
        //拿到测量大小
        int specSize = MeasureSpec.getSize(measureSpec);
        JLog.d("specMode:" + specMode + "--specSize:" + specSize);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {

        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        JLog.d("specMode:" + specMode + "--specSize:" + specSize);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }


}
