package com.example.lcq.qjump2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lcq.qjump2.R;
import com.example.lcq.qjump2.utils.ClickUtils;

public class Experience extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        ImageButton mSignalOne = (ImageButton)findViewById(R.id.signalonee);
        ImageButton mSingnaltwo = (ImageButton)findViewById(R.id.signaltwoe);

        ClickUtils.clickAction(mSignalOne,R.drawable.signaloneup,R.drawable.signalonedown,1);
        ClickUtils.clickAction(mSingnaltwo,R.drawable.signaltwoup,R.drawable.signaltwodown,2);
    }



    public void next(View view){
        Intent mIntent = new Intent(this,Compare.class);
        startActivity(mIntent);
        finish();
    }
}
