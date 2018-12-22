package com.rultech.naman.namandialoglibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NamanCustomDialogButton extends LinearLayout {
    Context context;
    Resources resources;
    NamanCustomDialogCallback callback;
    /*PrettyDialog.BUTTON_TYPE background_type = PrettyDialog.BUTTON_TYPE.BORDER;*/
    Integer default_background_color = R.color.colorPrimary;
    Integer default_text_color = R.color.pdlg_color_white;
    String text;
    TextView tv;
    LinearLayout ll_button;
    ImageView iv;
    Typeface tf;
    Integer buttonTextColor,buttonBackGroundColor,buttonTextSize,buttonHeight;
    NamanCustomDialogWithDataCallback dataCallback;
    String firstEditTextValue,secondEditTextValue,thirdEditTextValue;

    public NamanCustomDialogButton(Context context,
                                   String buttonText,
                                   Integer buttonTextColor,
                                   Integer buttonBackGroundColor,
                                   Typeface tf,
                                   NamanCustomDialogCallback callback) {
        super(context);
        this.context = context;
        resources = context.getResources();
        this.text = buttonText;
        /*this.text_color = textColor;*/
        /*this.background_color = background_color;*/
        this.tf = tf;
        /*this.background_type = type;*/
        this.callback = callback;
        this.buttonTextColor=buttonTextColor;
        this.buttonBackGroundColor=buttonBackGroundColor;
        init();
    }
    public NamanCustomDialogButton(Context context,
                                   String buttonText,
                                   Integer buttonTextColor,
                                   Integer buttonBackGroundColor,
                                   Typeface tf,
                                   NamanCustomDialogWithDataCallback customDialogWithDataCallback) {
        super(context);
        this.context = context;
        resources = context.getResources();
        this.text = buttonText;
        /*this.text_color = textColor;*/
        /*this.background_color = background_color;*/
        this.tf = tf;
        /*this.background_type = type;*/
        this.buttonTextColor=buttonTextColor;
        this.buttonBackGroundColor=buttonBackGroundColor;
        this.dataCallback = customDialogWithDataCallback;

        initWithData();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.pdlg_button, this);
        }
        tv = (TextView) findViewById(R.id.tv_button);
        ll_button=(LinearLayout)findViewById(R.id.ll_button);

//        ll_button.setBackgroundColor(context.getColor(buttonBackGroundColor==null?default_background_color:buttonBackGroundColor));
     /*   if (buttonHeight!=null){
            int margin = resources.getDimensionPixelSize(R.dimen.pdlg_space_1_0x);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,80);
            lp.setMargins(margin, margin, margin, 0);
            ll_button.setLayoutParams(lp);
        }*/

        /*ll_button.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 80));*/
        tv.setText(text);
       /* if (buttonTextSize!=null){
            tv.setTextSize(buttonTextSize);
        }*/
        tv.setTextColor(context.getColor(buttonTextColor==null?default_text_color:buttonTextColor));
        setBackground();
        if(tf != null)
            tv.setTypeface(tf);
        /*setBackground();*/
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback!=null) {
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            callback.onClick();
                        }
                    }, 150);
                }
            }
        });
    }
    private void initWithData() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.pdlg_button, this);
        }
        tv = (TextView) findViewById(R.id.tv_button);
        ll_button=(LinearLayout)findViewById(R.id.ll_button);
//        ll_button.setBackgroundColor(context.getColor(buttonBackGroundColor==null?default_background_color:buttonBackGroundColor));
        tv.setText(text);
        tv.setTextColor(context.getColor(buttonTextColor==null?default_text_color:buttonTextColor));
     /*   if (buttonTextSize!=null){
            tv.setTextSize(buttonTextSize);
        }
        if (buttonHeight!=null){
            int margin = resources.getDimensionPixelSize(R.dimen.pdlg_space_1_0x);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,80);
            lp.setMargins(margin, margin, margin, 0);
            ll_button.setLayoutParams(lp);
        }*/
        setBackground();
        if(tf != null)
            tv.setTypeface(tf);
        /*setBackground();*/
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dataCallback!=null) {
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dataCallback.onClickWithData(null,null,null);
                        }
                    }, 150);
                }
            }
        });
    }
    public void setTypeface(Typeface tf){
        this.tf = tf;
        tv.setTypeface(tf);
    }

    public void setButtonHeight(Integer Height){
        this.buttonHeight = Height;
        int margin = resources.getDimensionPixelSize(R.dimen.pdlg_space_1_0x);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,buttonHeight);
        lp.setMargins(margin, margin, margin, 0);
        ll_button.setLayoutParams(lp);
    }

    public void setButtonTextSize(Integer TextSize){
        this.buttonTextSize = TextSize;
        tv.setTextSize(buttonTextSize);
    }
    private void setBackground() {
        ll_button.setBackground(makeSelector(context.getColor(buttonBackGroundColor==null?default_background_color:buttonBackGroundColor)));
    }
    private int getLightenColor(int color){
        double fraction = 0.2;
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = (int)Math.min(red + (red * fraction), 255);
        green = (int)Math.min(green + (green * fraction), 255);
        blue = (int)Math.min(blue + (blue * fraction), 255);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, red, green, blue);
    }

    private StateListDrawable makeSelector(int color) {
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(150);
        GradientDrawable pressed_drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[] {getLightenColor(color),getLightenColor(color)});
        pressed_drawable.setCornerRadius(resources.getDimensionPixelSize(R.dimen.pdlg_corner_radius));
        GradientDrawable default_drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[] {color,color});
        default_drawable.setCornerRadius(resources.getDimensionPixelSize(R.dimen.pdlg_corner_radius));
        res.addState(new int[]{android.R.attr.state_pressed}, pressed_drawable);
        res.addState(new int[]{}, default_drawable);
        return res;
    }
}
