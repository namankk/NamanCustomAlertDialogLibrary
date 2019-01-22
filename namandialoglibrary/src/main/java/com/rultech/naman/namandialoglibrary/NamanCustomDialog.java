package com.rultech.naman.namandialoglibrary;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatDialog;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NamanCustomDialog extends AppCompatDialog {
    NamanCustomDialog thisDialog;
    Resources resources;
    LinearLayout ll_buttons;
    RelativeLayout llRoot;
    TextView tv_message, tv_title;
    Typeface typeface;
    Context context;
    EditText et_first, et_second, et_third;
    ImageView imgIcon;
    RotateAnimation close_rotation_animation;
    int widthOfDialog;

    public NamanCustomDialog(Context context) {
        super(context);
        this.context = context;
        thisDialog = this;
        resources = context.getResources();
        setContentView(R.layout.dialog_naman_custom);
        setCancelable(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        autoHideKeyboard(this.getWindow().getDecorView().getRootView(), context);
        setupViews_Base();

    }

    private void setupViews_Base() {

        ll_buttons = (LinearLayout) findViewById(R.id.ll_buttons);
        llRoot = (RelativeLayout) findViewById(R.id.linear_main_view);
     /*   LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMarginStart(20);
        layoutParams.setMarginEnd(20);
        llRoot.setLayoutParams(layoutParams);*/
       /* FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(20, 0, 20, 0);
        llRoot.setLayoutParams(lp);*/

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setVisibility(View.GONE);
        tv_message = (TextView) findViewById(R.id.tv_message);
        tv_message.setVisibility(View.GONE);
        et_first = (EditText) findViewById(R.id.et_first);
        et_second = (EditText) findViewById(R.id.et_second);
        et_third = (EditText) findViewById(R.id.et_third);

        et_first.setVisibility(View.GONE);
        et_second.setVisibility(View.GONE);
        et_third.setVisibility(View.GONE);

        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        Drawable drawable = context.getDrawable(R.drawable.dialogbox_oval_shape);
        drawable.setTint(context.getColor(R.color.colorPrimaryDark));
        imgIcon.setBackground(drawable);

        close_rotation_animation = new RotateAnimation(0, 180,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        close_rotation_animation.setDuration(300);
        close_rotation_animation.setRepeatCount(Animation.ABSOLUTE);
        close_rotation_animation.setInterpolator(new DecelerateInterpolator());
        close_rotation_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                thisDialog.dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /************************************* Add Button to Dialog ***********************************/
    public NamanCustomDialog addButton(String buttonText, Integer buttonTextColor, Integer buttonBackGroundColor, NamanCustomDialogCallback callback) {
        NamanCustomDialogButton button = new NamanCustomDialogButton(context, buttonText, buttonTextColor, buttonBackGroundColor, typeface,callback);
        int margin = resources.getDimensionPixelSize(R.dimen.pdlg_space_1_0x);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(margin, margin, margin, 0);
        button.setLayoutParams(lp);
        ll_buttons.addView(button);
        return this;
    }

    public NamanCustomDialog addButtonWithEditetext(String buttonText, Integer buttonTextColor, Integer buttonBackGroundColor,  final NamanCustomDialogWithDataCallback customDialogWithDataCallback) {
        NamanCustomDialogButton button = new NamanCustomDialogButton(context, buttonText, buttonTextColor, buttonBackGroundColor, typeface, new NamanCustomDialogWithDataCallback() {
            @Override
            public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                customDialogWithDataCallback.onClickWithData(et_first.getText().toString(), et_second.getText().toString(), et_third.getText().toString());
            }
        });
        int margin = resources.getDimensionPixelSize(R.dimen.pdlg_space_1_0x);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(margin, margin, margin, 0);
        button.setLayoutParams(lp);
        ll_buttons.addView(button);
        return this;
    }

    /*************************** Set Text ,Icon ,TypeFace To Fields *******************************/
    public NamanCustomDialog setEditText(int numberOfEdittext, String hint1, String hint2, String hint3) {
        switch (numberOfEdittext) {
            case 1: {
                et_first.setVisibility(View.VISIBLE);
                et_first.setHint(hint1);
                break;
            }
            case 2: {
                et_first.setVisibility(View.VISIBLE);
                et_second.setVisibility(View.VISIBLE);

                et_first.setHint(hint1);
                et_second.setHint(hint2);
                break;
            }
            case 3: {
                et_first.setVisibility(View.VISIBLE);
                et_second.setVisibility(View.VISIBLE);
                et_third.setVisibility(View.VISIBLE);

                et_first.setHint(hint1);
                et_second.setHint(hint2);
                et_third.setHint(hint3);
                break;
            }
        }
        return this;
    }

    public NamanCustomDialog setTitle(String text) {
        if (text.trim().length() > 0) {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        } else {
            tv_title.setVisibility(View.GONE);
        }
        return this;
    }

    public NamanCustomDialog setMessage(String text) {
        if (text.trim().length() > 0) {
            tv_message.setVisibility(View.VISIBLE);
            tv_message.setText(text);
        } else {
            tv_message.setVisibility(View.GONE);
        }
        return this;
    }

    public NamanCustomDialog setTypeface(Typeface tf) {
        typeface = tf;
        tv_title.setTypeface(tf);
        tv_message.setTypeface(tf);
        et_first.setTypeface(tf);
        et_second.setTypeface(tf);
        et_third.setTypeface(tf);

        for (int i = 0; i < ll_buttons.getChildCount(); i++) {
            NamanCustomDialogButton button = (NamanCustomDialogButton) ll_buttons.getChildAt(i);
            button.setTypeface(tf);
            button.requestLayout();
        }

        return this;
    }
    public NamanCustomDialog setButtonsHeight(Integer buttonHeight) {

        for (int i = 0; i < ll_buttons.getChildCount(); i++) {
            NamanCustomDialogButton button = (NamanCustomDialogButton) ll_buttons.getChildAt(i);
            final float scale = getContext().getResources().getDisplayMetrics().density;
            int pixels = (int) (buttonHeight * scale + 0.5f);
           button.setButtonHeight(pixels);
            button.requestLayout();
        }

        return this;
    }
    public NamanCustomDialog setButtonsTextSize(Integer buttonsTextSize) {

        for (int i = 0; i < ll_buttons.getChildCount(); i++) {
            NamanCustomDialogButton button = (NamanCustomDialogButton) ll_buttons.getChildAt(i);
            button.setButtonTextSize(buttonsTextSize);
            button.requestLayout();
        }

        return this;
    }
    public NamanCustomDialog setButtonsBackgroundImage(int drawableID) {

        for (int i = 0; i < ll_buttons.getChildCount(); i++) {
            NamanCustomDialogButton button = (NamanCustomDialogButton) ll_buttons.getChildAt(i);
            /*button.setBackground(drawableID);*/
            button.setButtonBackGroundImage(drawableID);
            button.requestLayout();
        }
    /*   FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(40, 0, 40, 0);
        llRoot.setLayoutParams(lp);*/
        return this;
    }

    public NamanCustomDialog setIcon(Integer icon, Integer iconTint, Integer backgroundColor) {
        /*icon_animation = false;*/
        imgIcon.setImageResource(icon == null ? R.drawable.ic_edit : icon);
        if (iconTint == null) {
            imgIcon.setColorFilter(null);
        } else {
            imgIcon.setColorFilter(context.getColor(iconTint), PorterDuff.Mode.MULTIPLY);
        }
        if (backgroundColor == null) {
            Drawable drawable = context.getDrawable(R.drawable.dialogbox_oval_shape);
            drawable.setTint(context.getColor(R.color.colorPrimaryDark));
            imgIcon.setBackground(drawable);
        } else {
            Drawable drawable = context.getDrawable(R.drawable.dialogbox_oval_shape);
            drawable.setTint(context.getColor(backgroundColor));
            imgIcon.setBackground(drawable);
        }

        return this;
    }

    /*************************************  Change Text Color *************************************/
    public NamanCustomDialog setTitleTextColor(Integer color) {
        if (color != null) {
            tv_title.setTextColor(context.getColor(color));
        } else {
            tv_title.setTextColor(context.getColor(R.color.pdlg_color_black));
        }
        return this;
    }

    public NamanCustomDialog setMessageTextColor(Integer color) {
        if (color != null) {
            tv_message.setTextColor(context.getColor(color));
        } else {
            tv_message.setTextColor(context.getColor(R.color.pdlg_color_black));
        }
        return this;
    }

    /*************************************  Change Text Size *************************************/
    public NamanCustomDialog setTitleTextSize(float size) {
        if (size > 0) {
            tv_title.setTextSize(size);
        } else {
            tv_title.setTextSize(20);
        }
        return this;
    }

    public NamanCustomDialog setMessageTextSize(float size) {
        if (size > 0) {
            tv_message.setTextSize(size);
        } else {
            tv_message.setTextSize(15);
        }
        return this;
    }

    /*********************************  Change EditText InputType *********************************/
    public NamanCustomDialog setEditTextInputType(int idOfEdittext, int inputType) {
        switch (idOfEdittext) {
            case 1: {
                if (inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                    et_first.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et_first.setInputType(inputType);
                }
                break;
            }
            case 2: {
                if (inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                    et_second.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et_second.setInputType(inputType);
                }

                break;
            }
            case 3: {
                if (inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                    et_third.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et_third.setInputType(inputType);
                }

                break;
            }
            case 4: {
                if (inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                    et_first.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    et_second.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    et_third.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et_first.setInputType(inputType);
                    et_second.setInputType(inputType);
                    et_third.setInputType(inputType);
                }

                break;
            }
            default: {
                et_first.setInputType(InputType.TYPE_CLASS_TEXT);
                et_second.setInputType(InputType.TYPE_CLASS_TEXT);
                et_third.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            }
        }
        return this;
    }

    /***************************************** Animation ******************************************/
    public NamanCustomDialog setAnimationEnabled(boolean enabled) {
        if (enabled) {
            getWindow().getAttributes().windowAnimations = R.style.pdlg_default_animation;
        } else {
            getWindow().getAttributes().windowAnimations = R.style.pdlg_no_animation;
        }
        return this;
    }

    /************************** Hide Keyboard on touch  *******************************************/
    private void autoHideKeyboard(View view, final Context context) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (context != null) {
                        hideSoftKeyboard(context, v);
                        v.clearFocus();
                    } else {
                        Log.d("Util ..>>", "Setup UI Activity is null");
                    }

                    return false;
                }
            });
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); ++i) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                autoHideKeyboard(innerView, context);
            }
        }

    }

    private void hideSoftKeyboard(Context context, View v) {
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

    }

    /************************************* End Of The Code ****************************************/
}
