package com.example.lcq.qjump2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lcq.qjump2.R;
import com.example.lcq.qjump2.utils.ClickUtils;
import com.example.lcq.qjump2.utils.CsvUtil;
import com.example.lcq.qjump2.utils.ToastUtil;

public class Compare extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private String mSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        ImageButton mSignalOne = (ImageButton)findViewById(R.id.signalonec);
        ImageButton mSingnaltwo = (ImageButton)findViewById(R.id.signaltwoc);
        mRadioGroup = (RadioGroup)findViewById(R.id.select);

        ClickUtils.clickAction(mSignalOne,R.drawable.signaloneup,R.drawable.signalonedown,1);
        ClickUtils.clickAction(mSingnaltwo,R.drawable.signaltwoup,R.drawable.signaltwodown,2);
    }

    public void next(View view){
        switch (mRadioGroup.getCheckedRadioButtonId()){
            case R.id.onejump:{
                mSelection = "1更Q弹";
                break;
            }
            case R.id.twojump:{
                mSelection = "2更Q弹";
                break;
            }
            default:
                break;
        }
        if (TextUtils.isEmpty(mSelection)){
            ToastUtil.showToast(this,"请选择后再继续！",Toast.LENGTH_SHORT);
            return;
        }

        CsvUtil.instance().appendSelection(mSelection);

        Intent mIntent = new Intent(this,UnionFirst.class);
        startActivity(mIntent);
        finish();
    }
}
