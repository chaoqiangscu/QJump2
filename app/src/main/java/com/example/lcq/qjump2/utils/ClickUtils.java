package com.example.lcq.qjump2.utils;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

@SuppressLint("ClickableViewAccessibility")

public class ClickUtils {
    public static void clickAction(ImageButton v, final int up, final int down, final int musicNum) {
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        PlayerUtilFromSdcardSimpal.instance().releaseAll();
                        switch (musicNum) {
                            case 1:
                                PlayerUtilFromSdcardSimpal.instance().play1();
                                break;
                            case 2:
                                PlayerUtilFromSdcardSimpal.instance().play2();
                                break;
                            case 3:
                                PlayerUtilFromSdcardSimpal.instance().play3();
                                break;
                            case 4:
                                PlayerUtilFromSdcardSimpal.instance().play4();
                                break;
                            case 5:
                                PlayerUtilFromSdcardSimpal.instance().play5();
                                break;
                            case 6:
                                PlayerUtilFromSdcardSimpal.instance().play6();
                                break;
                            case 7:
                                PlayerUtilFromSdcardSimpal.instance().play7();
                                break;
                            case 8:
                                PlayerUtilFromSdcardSimpal.instance().play8();
                                break;
                            case 9:
                                PlayerUtilFromSdcardSimpal.instance().play9();
                                break;
                            case 10:
                                PlayerUtilFromSdcardSimpal.instance().play10();
                                break;
                            case 11:
                                PlayerUtilFromSdcardSimpal.instance().play11();
                                break;
                            case 12:
                                PlayerUtilFromSdcardSimpal.instance().play12();
                                break;
                            case 13:
                                PlayerUtilFromSdcardSimpal.instance().play13();
                                break;
                            case 14:
                                PlayerUtilFromSdcardSimpal.instance().play14();
                                break;
                            default:
                                break;
                        }
                        v.setBackgroundResource(down);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.setBackgroundResource(up);
                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
