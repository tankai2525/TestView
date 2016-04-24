package test.kai.tan.com.testview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import test.kai.tan.com.testview.R;

/**
 * 了解view的绘制onDraw
 * Created by tankai on 2016/4/24.
 */
public class MyView1 extends View {

    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        //bitmap mutable=false
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //bitmap mutable=true
        bitmap1 = bitmap1.copy(Bitmap.Config.ARGB_8888, true);
        canvas.drawBitmap(bitmap1,0,0,null);//绘制bitmap1
        //这里canvas需要一个mutable=true的bitmap, 否则报错
        Canvas canvas1 = new Canvas(bitmap1);//bitmap1 装载到canvas1上
        canvas1.drawCircle(5, 5, 5, paint);//注意canvas1绘制一个圆

    }
}
