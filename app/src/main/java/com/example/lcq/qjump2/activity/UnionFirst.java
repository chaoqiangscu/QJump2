package com.example.lcq.qjump2.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.lcq.qjump2.R;
import com.example.lcq.qjump2.utils.ClickUtils;
import com.example.lcq.qjump2.utils.CsvUtil;

import java.util.ArrayList;
import java.util.List;

//  参考网址https://blog.csdn.net/antimage08/article/details/51488656

public class UnionFirst extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mLinearLayout;

    private int[] mCounts = new int[8];

    private int[] mRes = {R.id.coreu1,R.id.a, R.id.b, R.id.c,
            R.id.d, R.id.e,R.id.f,R.id.signaloneu1,R.id.signaltwou1};
    private List<ImageButton> mImageButtons = new ArrayList<ImageButton>();
    private boolean mFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union_first);

        for (int i = 0; i < mRes.length; i++) {
            ImageButton imageView = (ImageButton) findViewById(mRes[i]);
            imageView.setOnClickListener(this);
            mImageButtons.add(imageView);
        }

        mLinearLayout = (LinearLayout)findViewById(R.id.intoductionu1);

        ImageButton mSignalOne = (ImageButton)findViewById(R.id.signaloneu1);
        ImageButton mSingnaltwo = (ImageButton)findViewById(R.id.signaltwou1);
        ImageButton mSingnala = (ImageButton)findViewById(R.id.a);
        ImageButton mSingnalb = (ImageButton)findViewById(R.id.b);
        ImageButton mSingnalc = (ImageButton)findViewById(R.id.c);
        ImageButton mSingnald = (ImageButton)findViewById(R.id.d);
        ImageButton mSingnale = (ImageButton)findViewById(R.id.e);
        ImageButton mSingnalf = (ImageButton)findViewById(R.id.f);

        ClickUtils.clickAction(mSignalOne,R.drawable.signaloneup,R.drawable.signalonedown,1);
        ClickUtils.clickAction(mSingnaltwo,R.drawable.signaltwoup,R.drawable.signaltwodown,2);
        ClickUtils.clickAction(mSingnala,R.drawable.aup,R.drawable.adown,3);
        ClickUtils.clickAction(mSingnalb,R.drawable.bup,R.drawable.bdown,4);
        ClickUtils.clickAction(mSingnalc,R.drawable.cup,R.drawable.cdown,5);
        ClickUtils.clickAction(mSingnald,R.drawable.dup,R.drawable.ddown,6);
        ClickUtils.clickAction(mSingnale,R.drawable.eup,R.drawable.edown,7);
        ClickUtils.clickAction(mSingnalf,R.drawable.fup,R.drawable.fdown,8);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coreu1:
                if (mFlag) {
                    //mLinearLayout.setVisibility(View.INVISIBLE);
                    mLinearLayout.setAlpha(0);
                    startAnim();
                } else {
                    closeAnim();
                    //mLinearLayout.setVisibility(View.VISIBLE);
                    mLinearLayout.setAlpha(1);
                }
                break;
            case R.id.signaloneu1:
                mCounts[0]++;
                break;
            case R.id.signaltwou1:
                mCounts[1]++;
                break;
            case R.id.a:
                mCounts[2]++;
                break;
            case R.id.b:
                mCounts[3]++;
                break;
            case R.id.c:
                mCounts[4]++;
                break;
            case R.id.d:
                mCounts[5]++;
                break;
            case R.id.e:
                mCounts[6]++;
                break;
            case R.id.f:
                mCounts[7]++;
                break;
            default:
                break;
        }
    }

    private void startAnim() {
        //动画距离,屏幕宽度的50%
        float distance = getScreenWidth()*0.5f*0.5f;
        //相邻ImageView运动角度式30度、60度
        float angle1 = (float)(30f*Math.PI/180);
        //float angle2 = (float)(60f*Math.PI/180);
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageButtons.get(0),
                "alpha",
                1F,
                0.5F);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageButtons.get(1),
                "TranslationY",
               -distance);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageButtons.get(2),
                "translationX",
                (float)(distance*Math.cos(angle1)));
        ObjectAnimator animator22 = ObjectAnimator.ofFloat(
                mImageButtons.get(2),
                "translationY",
                -(float)(distance*Math.sin(angle1)));

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageButtons.get(3),
                "translationX",
                (float)(distance*Math.cos(angle1)));
        ObjectAnimator animator33 = ObjectAnimator.ofFloat(
                mImageButtons.get(3),
                "translationY",
                (float)(distance*Math.sin(angle1)));

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageButtons.get(4),
                "translationY",
                (float)distance);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(
                mImageButtons.get(5),
                "translationX",
                -(float)(distance*Math.cos(angle1)));
        ObjectAnimator animator55 = ObjectAnimator.ofFloat(
                mImageButtons.get(5),
                "translationY",
                (float)(distance*Math.sin(angle1)));

        ObjectAnimator animator6 = ObjectAnimator.ofFloat(
                mImageButtons.get(6),
                "translationX",
                -(float)(distance*Math.cos(angle1)));
        ObjectAnimator animator66 = ObjectAnimator.ofFloat(
                mImageButtons.get(6),
                "translationY",
                -(float)(distance*Math.sin(angle1)));

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator22,
                animator3,
                animator33,
                animator4,
                animator5,
                animator55,
                animator6,
                animator66);
        set.start();
        mFlag = false;
    }

    private void closeAnim() {
        //动画距离,屏幕宽度的50%
        float distance = getScreenWidth()*0.5f*0.5f;
        //相邻ImageView运动角度式30度
        float angle1 = (float)(30f*Math.PI/180);
        //float angle2 = (float)(135f*Math.PI/180);
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageButtons.get(0),
                "alpha", 0.5F, 1F);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageButtons.get(1),
                "TranslationY",
                -distance,0);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageButtons.get(2),
                "translationX",
                (float)(distance*Math.cos(angle1)),0);
        ObjectAnimator animator22 = ObjectAnimator.ofFloat(
                mImageButtons.get(2),
                "translationY",
                -(float)(distance*Math.sin(angle1)),0);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageButtons.get(3),
                "translationX",
                (float)(distance*Math.cos(angle1)),0);
        ObjectAnimator animator33 = ObjectAnimator.ofFloat(
                mImageButtons.get(3),
                "translationY",
                (float)(distance*Math.sin(angle1)),0);

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageButtons.get(4),
                "translationY",
                (float)distance,0);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(
                mImageButtons.get(5),
                "translationX",
                -(float)(distance*Math.cos(angle1)),0);
        ObjectAnimator animator55 = ObjectAnimator.ofFloat(
                mImageButtons.get(5),
                "translationY",
                (float)(distance*Math.sin(angle1)),0);

        ObjectAnimator animator6 = ObjectAnimator.ofFloat(
                mImageButtons.get(6),
                "translationX",
                -(float)(distance*Math.cos(angle1)),0);
        ObjectAnimator animator66 = ObjectAnimator.ofFloat(
                mImageButtons.get(6),
                "translationY",
                -(float)(distance*Math.sin(angle1)),0);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator22,
                animator3,
                animator33,
                animator4,
                animator5,
                animator55,
                animator6,
                animator66);
        set.start();
        mFlag = true;
    }
    /**
     * 竖屏时获取屏幕宽度，横屏时，获取高度
     * @return
     */
    public int getScreenWidth(){
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int x = outMetrics.widthPixels;
        int y = outMetrics.heightPixels;
        return x>y?y:x;
    }

    public void next(View view){
        CsvUtil.instance().appendUnionFirstResults(mCounts);
        Intent mIntent = new Intent(this,UnionSecond.class);
        startActivity(mIntent);
        finish();
    }

}
