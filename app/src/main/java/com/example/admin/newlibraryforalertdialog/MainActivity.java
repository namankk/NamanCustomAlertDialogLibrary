package com.example.admin.newlibraryforalertdialog;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rultech.naman.namandialoglibrary.NamanCustomDialog;
import com.rultech.naman.namandialoglibrary.NamanCustomDialogCallback;
import com.rultech.naman.namandialoglibrary.NamanCustomDialogWithDataCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonSimple, buttonWithSingleEditText, buttonWithThreeEditText, buttonCustomSetting, buttonSizeChange, buttonTextStyleChange;
    NamanCustomDialog namanCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSimple = (Button) findViewById(R.id.buttonSimple);
        buttonWithSingleEditText = (Button) findViewById(R.id.buttonWithSingleEditText);
        buttonWithThreeEditText = (Button) findViewById(R.id.buttonWithThreeEditText);
        buttonCustomSetting = (Button) findViewById(R.id.buttonCustomSetting);
        buttonSizeChange = (Button) findViewById(R.id.buttonSizeChange);
        buttonTextStyleChange = (Button) findViewById(R.id.buttonTextStyleChange);

        buttonSimple.setOnClickListener(this);
        buttonWithSingleEditText.setOnClickListener(this);
        buttonWithThreeEditText.setOnClickListener(this);
        buttonCustomSetting.setOnClickListener(this);
        buttonSizeChange.setOnClickListener(this);
        buttonTextStyleChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.buttonSimple: {
                namanCustomDialog = new NamanCustomDialog(MainActivity.this);
                namanCustomDialog.setTitle("Request Send").setIcon(null, null, null);
                namanCustomDialog.setMessage("Changes will appear after some time");
                namanCustomDialog.addButton("OK", null, null, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        namanCustomDialog.hide();
                    }
                });
                namanCustomDialog.setAnimationEnabled(true);
                namanCustomDialog.show();
                break;
            }
            case R.id.buttonWithSingleEditText: {
                namanCustomDialog = new NamanCustomDialog(MainActivity.this);
                namanCustomDialog.setTitle("Forgot Password ?").setIcon(null, null, R.color.pdlg_color_green);
                namanCustomDialog.setEditText(1, "Enter your email", null, null);
                namanCustomDialog.addButtonWithEditetext("Submit", null, R.color.pdlg_color_green,new NamanCustomDialogWithDataCallback() {
                    @Override
                    public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                        Toast.makeText(MainActivity.this, firstEditTextValue, Toast.LENGTH_SHORT).show();
                    }
                });
                namanCustomDialog.addButton("Cancel", null, R.color.pdlg_color_green,new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "close the dialog", Toast.LENGTH_SHORT).show();
                        namanCustomDialog.hide();
                    }
                });
                namanCustomDialog.setAnimationEnabled(true);
                namanCustomDialog.show();
                break;
            }
            case R.id.buttonWithThreeEditText: {
                namanCustomDialog = new NamanCustomDialog(MainActivity.this);
                namanCustomDialog.setTitle("Change Password ?").setIcon(null, R.color.pdlg_color_black, R.color.pdlg_color_gray)
                        .setEditText(3, "Current Password", "New Password", "Confirm Password")
                        .setEditTextInputType(1, InputType.TYPE_CLASS_TEXT)
                        .setEditTextInputType(2, InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        .setEditTextInputType(3, InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .addButtonWithEditetext("Submit", R.color.pdlg_color_black, R.color.pdlg_color_gray,new NamanCustomDialogWithDataCallback() {
                    @Override
                    public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                        Toast.makeText(MainActivity.this, firstEditTextValue + " " + secondEditTextValue + " " + thirdEditTextValue, Toast.LENGTH_SHORT).show();
                    }
                })
                .addButton("Cancel", R.color.pdlg_color_black, R.color.pdlg_color_gray, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "close the dialog", Toast.LENGTH_SHORT).show();
                        namanCustomDialog.hide();
                    }
                })
                .setAnimationEnabled(true)
                .show();
                break;
            }
            case R.id.buttonCustomSetting: {
                namanCustomDialog = new NamanCustomDialog(MainActivity.this);
                namanCustomDialog.setIcon(R.drawable.ic_setting, R.color.pdlg_color_yellow, R.color.pdlg_color_red)
                        .setTitle("Action")
                        .setTitleTextColor(R.color.pdlg_color_red)
                        .setMessage("Changes will appear after some time")
                        .setMessageTextColor(R.color.pdlg_color_blue);
                namanCustomDialog.addButton("Submit", null, R.color.pdlg_color_red, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                    }
                });
                namanCustomDialog.addButton("Submit", null, R.color.pdlg_color_green, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                    }
                });
                namanCustomDialog.addButton("Cancel", null, R.color.pdlg_color_blue, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                        namanCustomDialog.hide();
                    }
                });
                /*namanCustomDialog.setButtonsBackgroundImage(R.drawable.button_rectangle);*/

                namanCustomDialog.setAnimationEnabled(false);
                namanCustomDialog.show();
                break;
            }
            case R.id.buttonSizeChange:{
                namanCustomDialog=new NamanCustomDialog(this);
                namanCustomDialog.setIcon(null,null,null)
                        .setTitle("Button size change")
                        .setMessage("change button height and button text size")
                        .addButton("Submit", null, null, new NamanCustomDialogCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addButton("Submit", null, null, new NamanCustomDialogCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setButtonsHeight(50)
                        .show();
                break;
            }
            case R.id.buttonTextStyleChange: {
                namanCustomDialog = new NamanCustomDialog(this);
                namanCustomDialog.setIcon(null, null, null)
                        .setTitle("Change font of dialog")
                        .setMessage("change front style of the dialog")
                        .setEditText(1, "demo", null, null)
                        .addButtonWithEditetext("Submit", null, null, new NamanCustomDialogWithDataCallback() {
                            @Override
                            public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                                Toast.makeText(MainActivity.this, firstEditTextValue, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addButton("Cancel", null, null, new NamanCustomDialogCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addButton("Cancel", null, null, new NamanCustomDialogCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC))
                        .setButtonsBackgroundImage(R.drawable.button_background)
                        .setButtonsHeight(40)
                        .show();
                break;
            }
        }
    }
}
