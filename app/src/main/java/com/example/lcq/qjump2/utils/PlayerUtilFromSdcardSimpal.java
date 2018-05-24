package com.example.lcq.qjump2.utils;

/**
 * Created by Administrator on 2018/3/12.
 */

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Environment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PlayerUtilFromSdcardSimpal {

    public SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    public Map<String, Integer> map = new HashMap<String, Integer>();

    private File mFilePath = new File(Environment.getExternalStorageDirectory(),"AAC-QJump2" + File.separator + "信号");
    private String mBasePath = mFilePath.getPath();

    private String mFirstPath = mBasePath + File.separator + "1.wav";
    private String mSecondPath = mBasePath + File.separator + "2.wav";
    private String mThirdPath = mBasePath + File.separator + "3.wav";
    private String mFourthPath = mBasePath + File.separator + "4.wav";
    private String mFifthPath = mBasePath + File.separator + "5.wav";
    private String mSixthPath = mBasePath + File.separator + "6.wav";
    private String mSevenPath = mBasePath + File.separator + "7.wav";
    private String mEightPath = mBasePath + File.separator + "8.wav";
    private String mNinePath = mBasePath + File.separator + "9.wav";
    private String mTenPath = mBasePath + File.separator + "10.wav";
    private String mElevenPath = mBasePath + File.separator + "11.wav";
    private String mTwelvePath = mBasePath + File.separator + "12.wav";
    private String mThirteenPath = mBasePath + File.separator + "13.wav";
    private String mFourteenPath = mBasePath + File.separator + "14.wav";

    private static PlayerUtilFromSdcardSimpal instance = null;
    public static PlayerUtilFromSdcardSimpal instance() {
        if(null == instance) {
            instance = new PlayerUtilFromSdcardSimpal();
        }
        return instance;
    }

    private PlayerUtilFromSdcardSimpal() {
    }

    /*public void ini(){
        map1.put("11", soundPool1.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"1.wav", 1));
        map1.put("21", soundPool1.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"2.wav", 1));
        map2.put("3", soundPool2.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"3.wav", 1));
        map2.put("4", soundPool2.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"4.wav", 1));
        map3.put("5", soundPool3.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"5.wav", 1));
        map3.put("6", soundPool3.load(Environment.getExternalStorageDirectory()+File.separator+"AAC-WAV"+File.separator+"6.wav", 1));
    }*/
    public void ini(){
        map.put("1", soundPool.load(mFirstPath, 1));
        map.put("2", soundPool.load(mSecondPath, 1));
        map.put("3", soundPool.load(mThirdPath, 1));
        map.put("4", soundPool.load(mFourthPath, 1));
        map.put("5", soundPool.load(mFifthPath, 1));
        map.put("6", soundPool.load(mSixthPath, 1));
        map.put("7", soundPool.load(mSevenPath, 1));
        map.put("8", soundPool.load(mEightPath, 1));
        map.put("9", soundPool.load(mNinePath, 1));
        map.put("10", soundPool.load(mTenPath, 1));
        map.put("11", soundPool.load(mElevenPath, 1));
        map.put("12", soundPool.load(mTwelvePath, 1));
        map.put("13", soundPool.load(mThirteenPath, 1));
        map.put("14", soundPool.load(mFourteenPath, 1));
    }

    public void play1(){
        //map.put("1", soundPool.load(MyApplication.getContext(), R.raw.first, 1));
        soundPool.play(map.get("1"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play2(){
        //map.put("2", soundPool.load(MyApplication.getContext(), R.raw.second, 1));
        soundPool.play(map.get("2"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play3(){
        //map.put("3", soundPool.load(MyApplication.getContext(), R.raw.third, 1));
        soundPool.play(map.get("3"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play4(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("4"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play5(){
        //map.put("3", soundPool.load(MyApplication.getContext(), R.raw.third, 1));
        soundPool.play(map.get("5"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play6(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("6"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play7(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("7"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play8(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play9(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play10(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play11(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play12(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play13(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void play14(){
        //map.put("4", soundPool.load(MyApplication.getContext(), R.raw.forth, 1));
        soundPool.play(map.get("8"), 1.0f, 1.0f, 0, 0, 1);
    }

    public void releaseAll(){
        soundPool.stop(map.get("1"));
        soundPool.stop(map.get("2"));
        soundPool.stop(map.get("3"));
        soundPool.stop(map.get("4"));
        soundPool.stop(map.get("5"));
        soundPool.stop(map.get("6"));
        soundPool.stop(map.get("7"));
        soundPool.stop(map.get("8"));
        soundPool.stop(map.get("9"));
        soundPool.stop(map.get("10"));
        soundPool.stop(map.get("11"));
        soundPool.stop(map.get("12"));
        soundPool.stop(map.get("13"));
        soundPool.stop(map.get("14"));
    }


}
