package test.kai.tan.com.testview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import test.kai.tan.com.testview.view.MyActionBar;

public class TestViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra("flag",-1);
        switch (flag){
            case 0:
                //测试onMeasure
                setContentView(R.layout.activity_my_view_on_measure);
                break;
            case 1:
                //测试onDraw
                setContentView(R.layout.activity_my_view_on_draw);
                break;
            case 2:
                //绘制两层背景TextView
                setContentView(R.layout.activity_my_text_view_1);
                break;
            case 3:
                //TextView文字闪动效果
                setContentView(R.layout.activity_my_text_view_2);
                break;
            case 4:
                setContentView(R.layout.activity_my_action_bar);
                MyActionBar toolBar = findViewById(R.id.topbar);
                toolBar.setOnTopbarClickListener(new MyActionBar.TopBarClickListener() {
                    @Override
                    public void leftClick() {
                        Toast.makeText(TestViewActivity.this, "左边", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void rightClick() {
                        Toast.makeText(TestViewActivity.this, "右边", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 5:
                //绘制文字，圆，直线，弧线
                setContentView(R.layout.activity_my_view_1);
                break;
            case 6:
                //ViewGroup
                setContentView(R.layout.activity_my_view_group_1);
                break;
            case 7:
                setContentView(R.layout.activity_my_view);
                break;
        }
    }
}
