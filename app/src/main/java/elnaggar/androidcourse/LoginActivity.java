package elnaggar.androidcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LoginActivity extends Activity {
    EditText userName, password;
    Spinner gender;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserContraller userContraller=new UserContraller(this);
        if(userContraller.isRemeb()){
            startActivity(new Intent(this,SecondActivity.class));
        }
        checkBox = (CheckBox) findViewById(R.id.checkBox_remeber);
        userName = (EditText) findViewById(R.id.ed_userName);
        password = (EditText) findViewById(R.id.ed_password);
        gender
                = (Spinner) findViewById(R.id.spin_gender);
    }


    public void onClick(View view) {
        User user = new User();
        user.setUserName(userName.getText().toString());
        user.setPassword(password.getText().toString());
        TextView textView = (TextView) gender.getSelectedView();
        user.setGender(textView.getText().toString());
        if (checkBox.isChecked()) {
            UserContraller userContraller = new UserContraller(this);
            userContraller.saveDate(user);
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

    }
}
