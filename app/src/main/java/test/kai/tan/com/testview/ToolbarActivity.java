package test.kai.tan.com.testview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import test.kai.tan.com.testview.view.MyToolBar;

/**
 * 组合控件 + 自定义属性
 */
public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        MyToolBar toolBar = (MyToolBar) findViewById(R.id.topbar);
        toolBar.setOnTopbarClickListener(new MyToolBar.TopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(ToolbarActivity.this, "左边", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(ToolbarActivity.this, "右边", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
