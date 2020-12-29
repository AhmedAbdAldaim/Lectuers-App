package com.example.lectuers;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class text_font1 extends TextView {
    public text_font1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"GE_SS_TWO_MEDIUM.OTF"));
    }
}
