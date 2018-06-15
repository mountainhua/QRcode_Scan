package mountain_hua.qrcode_scan;

import android.Manifest;
import android.content.Intent;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.zxing.activity.CaptureActivity;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //摄像头权限
        if (Build.VERSION.SDK_INT >= 23) {
            //Manifest.permission.CAMERA
            //如果用户并没有同意该权限
            if (checkSelfPermission(Manifest.permission.CAMERA) != PERMISSION_GRANTED) {
                //申请权限
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
            } else {

            }
        }


        Button toscan=(Button)findViewById(R.id.to_scan);
        toscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,CaptureActivity.class);
                startActivity(intent);
            }
        });
    }

}
