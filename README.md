# NamanCustomAlertDialogLibrary
NamanCustomAlertDialogLibrary is the customize Android alert dialog library.

Example is available in app module.
# Download
# Gradle:

Add this to your app build.gradle:


```
dependencies {
implementation 'com.rultech.naman.namandialoglibrary:NamanCustomAlertDialogLibrary:0.1.0'
}
```
## Usage
NamanCustomAlertDialogLibrary extends Dialog class, so feel free to use its inherited functions.

**Note:** Default dialog has no title, message or any buttons. Just a close icon on top and you can dismiss the dialog by clicking outside the dialog or on clicking "ok" button.
### Simple Dialog, No Customization:

```
NamanCustomDialog namanCustomDialog = new NamanCustomDialog(MainActivity.this);
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
```

##### Output:

![alt text](https://github.com/mjn1369/PrettyDialog/blob/master/Screenshots/1.png "Simple Dialog, No Customization")

### Change Icon:
- You can set the dialog icon resource:

```
.setIcon(R.drawable.pdlg_icon_info, null, null)
```

- And set a color tint for it:

```
.setIcon(null, R.color.pdlg_color_black, null)

```
- And set background color for it:

```
.setIcon(null, null, R.color.pdlg_color_green);
```
- All in one place
```
.setIcon(R.drawable.ic_setting, R.color.pdlg_color_yellow, R.color.pdlg_color_red)
```

##### Output:

![alt text](https://github.com/mjn1369/PrettyDialog/blob/master/Screenshots/2.png "Customize icon")

### Add Buttons:
- You can add unlimited customized buttons to dialog:there are two types of button one which gets the edittext value and other gives only button click event 

```
// Button with edittext string value.

 .addButtonWithEditetext("Submit", R.color.pdlg_color_black, R.color.pdlg_color_gray, new NamanCustomDialogWithDataCallback() {
                    @Override
                    public void onClickWithData(String firstEditTextValue, String secondEditTextValue, String thirdEditTextValue) {
                        Toast.makeText(MainActivity.this, firstEditTextValue + " " + secondEditTextValue + " " + thirdEditTextValue, Toast.LENGTH_SHORT).show();
                    }
                })
                
  //Simple click event button
                .addButton("Cancel", R.color.pdlg_color_black, R.color.pdlg_color_gray, new NamanCustomDialogCallback() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "close the dialog", Toast.LENGTH_SHORT).show();
                        namanCustomDialog.hide();
                    }
                })
```

##### Output:

![alt text](https://github.com/mjn1369/PrettyDialog/blob/master/Screenshots/3.png "Added custom buttons")

### Add Edit Text max 3:
**Note:** You can add maximum 3 edit text in your dialog just pass the number 3 in setEditText methode along with the hints of edit text you need for example:
**Note:** You can also set the InputType of every edit text for example:

- This will set the first edittext input type as text
```
.setEditTextInputType(1, InputType.TYPE_CLASS_TEXT)
```
- This will set the Second edittext input type as text
```
  .setEditTextInputType(2, InputType.TYPE_TEXT_VARIATION_PASSWORD)

```
- This will set the Third edittext input type as text

```
 .setEditTextInputType(3, InputType.TYPE_TEXT_VARIATION_PASSWORD)
 ```
 - And if you want all your edit text to have same input type For example password then type "4" in idOfEditText

```
 .setEditTextInputType(4, InputType.TYPE_TEXT_VARIATION_PASSWORD)
 ```

```
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
```





**Note:** To Dismiss NamanCustomDialog on a button click, you have to instantiate NamanCustomDialog and keep the variable, then call hide() on the variable inside button's onClickListener method:

```
NamanCustomDialog namanCustomDialog = new NamanCustomDialog(MainActivity.this);
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
```

### Custom Title, Message,Buttons:

**Note:** Typeface applies to all texts inside the dialog.

```
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
                
```

##### Output:

![alt text](https://github.com/mjn1369/PrettyDialog/blob/master/Screenshots/4.png "Custom Title, Message and Typeface")

- Enable/Disable dialog animation:

```
.setAnimationEnabled(true)
```

- Set dialog gravity:

```
.setGravity(Gravity.BOTTOM)
```

## Functions

 |            Functions            |            Description            |            Default            |
 | ------------------------------- | -------------------------------   | --------------------------    |
 | setTitle(String)                      | sets a title for dialog           |  ""                           |
 | setTitleTextColor(Integer color)      | sets title's color                |  #212121 (kinda black)        |
 | setTitleTextSize(float size)          | set the size of title text  |          |
 | setMessage(String)               | sets a message for dialog         |  ""                           |
 | setMessageTextColor(Integer color)  | sets message's color              |  #212121 (kinda black)        |
 | setMessageTextSize(float size)      | sets message's text size          |        |
 | setIcon(Integer icon, Integer iconTint, Integer backgroundColor) | sets the dialog's icon, iconTint, backgroundColor      |  "edit" icon             |
 | setEditText(int numberOfEdittext, String hint1, String hint2, String hint3)    |sets the number of edittext you want max 3, hint of first edittext,hint of second edittext, hint of third edit text, if you need only 1 edittext then pass null in hint2 and hint3|no default value you have to set it |
 | setEditTextInputType(int idOfEdittext, int inputType)     | sets the input type of a particular edittext ids of edit text is 1,2,3  | defalut is text |
 | addButton(String buttonText, Integer buttonTextColor, Integer buttonBackGroundColor, NamanCustomDialogCallback callback)|adds button with text,text color,background color and callback|
 | addButtonWithEditetext(String buttonText, Integer buttonTextColor, Integer buttonBackGroundColor, final NamanCustomDialogWithDataCallback customDialogWithDataCallback) | adds button with text,text color,background color and callback|   |
 | setAnimationEnabled(boolean)       | enables or disables dialog animation| Disables                     |



## License
 
 ```
Copyright 2017 mjn1369

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 
```  