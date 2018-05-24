package com.example.lcq.qjump2.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lcq.qjump2.R;
import com.example.lcq.qjump2.utils.CsvUtil;
import com.example.lcq.qjump2.utils.PlayerUtilFromSdcardSimpal;
import com.example.lcq.qjump2.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;    // 请求存储权限
    private Spinner mTestSpinner;
    private EditText mNum;
    private EditText mAge;
    private String mSex;

    public static final String[] TEST_PROGRAM_ARRAY = {
            "男",
            "女"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        PlayerUtilFromSdcardSimpal.instance().ini();

        mNum = (EditText)findViewById(R.id.num) ;
        mAge = (EditText)findViewById(R.id.age);
        mTestSpinner = (Spinner) findViewById(R.id.sex);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TEST_PROGRAM_ARRAY);
        mTestSpinner.setAdapter(adapter);
    }

    public void next(View view){
        switch (mTestSpinner.getSelectedItemPosition()){
            case 0:
                mSex = "男";
                break;
            case 1:
                mSex = "女";
                break;
            default:
                break;
        }
        if (TextUtils.isEmpty(mNum.getText().toString()) || TextUtils.isEmpty(mAge.getText().toString()) || TextUtils.isEmpty(mSex)){
            ToastUtil.showToast(this,"请填写信息后再开始！",Toast.LENGTH_SHORT);
            return;
        }

        CsvUtil.instance().createFile(this,mNum.getText().toString(),mAge.getText().toString(),mSex);

        Intent mIntent = new Intent(this,Experience.class);
        startActivity(mIntent);
        finish();
    }

    private void requestPermission() {
        final int permissionCheckRead = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        final int permissionCheckWrite = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // permission not granted yet -> don't check for registration state now
        if(permissionCheckRead != PackageManager.PERMISSION_GRANTED
                || permissionCheckWrite != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(  MainActivity.this, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_STORAGE);
        }
    }
}
