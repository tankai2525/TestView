package test.kai.tan.com.testview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiongbull.jlog.JLog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        JLog.init(this).setDebug(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
    }

    private void actionOpen(Class c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                actionOpen(MyViewActivity.class);
                break;
            case R.id.btn2:
                actionOpen(MyView1Activity.class);
                break;
            case R.id.btn3:
                actionOpen(MyTextViewActivity.class);
                break;
            case R.id.btn4:
                actionOpen(ToolbarActivity.class);
                break;
            case R.id.btn5:
                actionOpen(MyView2Activity.class);
                break;
            case R.id.btn6:
                actionOpen(ToolbarActivity.class);
                break;
        }
    }
}
