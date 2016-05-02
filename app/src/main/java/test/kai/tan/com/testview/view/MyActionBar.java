package test.kai.tan.com.testview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import test.kai.tan.com.testview.R;

/**
 * 创建复合控件
 * Created by tankai on 2016/4/24.
 */
public class MyActionBar extends RelativeLayout {

    private TextView mTitleView;
    private Button mLeftbtn;
    private Button mRightBtn;
    private String mLeftText;
    private Drawable mLeftBackground;
    private int mRightTextColor;
    private String mRightText;
    private Drawable mRightBackground;
    private String mTitle;
    private float mTitleTextSize;
    private int mTitleTextColor;
    private int mLeftTextColor;

    private TopBarClickListener mListener;

    public interface TopBarClickListener {
        void leftClick();
        void rightClick();
    }

    public MyActionBar(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public MyActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //将atts.xml中定义的declare-styleable的所有属性的值存储到TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyTopBar);
        //获取定义的属性值
        mLeftTextColor = ta.getColor(R.styleable.MyTopBar_leftTextColor, 0);
        mLeftText = ta.getString(R.styleable.MyTopBar_leftText);
        mLeftBackground = ta.getDrawable(R.styleable.MyTopBar_leftBackground);

        mRightTextColor = ta.getColor(R.styleable.MyTopBar_leftTextColor, 0);
        mRightText = ta.getString(R.styleable.MyTopBar_leftText);
        mRightBackground = ta.getDrawable(R.styleable.MyTopBar_leftBackground);

        mTitle = ta.getString(R.styleable.MyTopBar_titleText);
        mTitleTextSize = ta.getDimension(R.styleable.MyTopBar_titleTextSize, 0);
        mTitleTextColor = ta.getColor(R.styleable.MyTopBar_titleTextColor1, 0);

        ta.recycle();//一定要调用recyle来避免重新创建的时候的错误

        mTitleView = new TextView(context);
        mLeftbtn = new Button(context);
        mRightBtn = new Button(context);

        mTitleView.setText(mTitle);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftbtn.setText(mLeftText);
        mLeftbtn.setTextColor(mLeftTextColor);
        mLeftbtn.setBackground(mLeftBackground);

        mRightBtn.setText(mRightText);
        mRightBtn.setTextColor(mRightTextColor);
        mRightBtn.setBackground(mRightBackground);

        LayoutParams mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftbtn, mLeftParams);

        LayoutParams mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightBtn, mRightParams);

        LayoutParams mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        mLeftbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)mListener.leftClick();
            }
        });

        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)mListener.rightClick();
            }
        });
    }

    public MyActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnTopbarClickListener(TopBarClickListener mListener) {
        this.mListener = mListener;
    }


    public void setButtonVisable(int id, boolean flag) {
        if(flag) {
            if(id == 0){
                mLeftbtn.setVisibility(VISIBLE);
            } else {
                mRightBtn.setVisibility(VISIBLE);
            }
        } else {
            if(id == 0){
                mLeftbtn.setVisibility(GONE);
            } else {
                mRightBtn.setVisibility(GONE);
            }
        }
    }
}
