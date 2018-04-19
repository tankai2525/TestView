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
    }

    private void actionOpen(Class c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }

    private void actionOpen(int flag) {
        actionOpen(TestViewActivity.class,flag);
    }

    private void actionOpen(Class c, int flag) {
        Intent intent = new Intent(MainActivity.this, c);
        intent.putExtra("flag", flag);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                actionOpen(0);
                break;
            case R.id.btn2:
                actionOpen(1);
                break;
            case R.id.btn3:
                actionOpen(2);
                break;
            case R.id.btn3_1:
                actionOpen(3);
                break;
            case R.id.btn4:
                actionOpen(4);
                break;
            case R.id.btn5:
                actionOpen(5);
                break;
            case R.id.btn6:
                actionOpen(6);
                break;
            case R.id.btn7:
                actionOpen(7);
                break;
        }
    }
}
