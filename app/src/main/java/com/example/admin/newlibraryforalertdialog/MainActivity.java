package com.example.admin.newlibraryforalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rultech.naman.namandialoglibrary.NamanCustomDialog;
import com.rultech.naman.namandialoglibrary.NamanCustomDialogCallback;
import com.rultech.naman.namandialoglibrary.NamanCustomDialogWithDataCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonSimple, buttonWithSingleEditText, buttonWithThreeEditText, buttonCustomSetting;
    NamanCustomDialog namanCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSimple = (Button) findViewById(R.id.buttonSimple);
        buttonWithSingleEditText = (Button) findViewById(R.id.buttonWithSingleEditText);
        buttonWithThreeEditText = (Button) findViewById(R.id.buttonWithThreeEditText);
        buttonCustomSetting = (Button) findViewById(R.id.buttonCustomSetting);

        buttonSimple.setOnClickListener(this);
        buttonWithSingleEditText.setOnClickListener(this);
        buttonWithThreeEditText.setOnClickListener(this);
        buttonCustomSetting.setOnClickListener(this);
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
                namanCustomDialog.addButtonWithEditetext("Submit", null, R.color.pdlg_color_green, new NamanCustomDialogWithDataCallback() {
                    @Override
                    public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                        Toast.makeText(MainActivity.this, firstEditTextValue, Toast.LENGTH_SHORT).show();
                    }
                });
                namanCustomDialog.addButton("Cancel", null, R.color.pdlg_color_green, new NamanCustomDialogCallback() {
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
                .addButtonWithEditetext("Submit", R.color.pdlg_color_black, R.color.pdlg_color_gray, new NamanCustomDialogWithDataCallback() {
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
                namanCustomDialog.setAnimationEnabled(false);
                namanCustomDialog.show();
                break;
            }
        }
    }
}
