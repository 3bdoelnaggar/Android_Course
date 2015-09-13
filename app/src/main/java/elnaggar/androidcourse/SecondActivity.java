package elnaggar.androidcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    Intent intent;
    TextView tv_user,tv_password,tv_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        UserContraller userContraller=new UserContraller(this);
        tv_user= (TextView) findViewById(R.id.tv_userName);
        tv_password= (TextView) findViewById(R.id.tv_password);
        tv_gender= (TextView) findViewById(R.id.tv_gender);
        intent=getIntent();
        if(userContraller.isRemeb()){
            User user=userContraller.getData();
            tv_user.setText(tv_user.getText() + user.getUserName());
            tv_password.setText(tv_password.getText() + user.getPassword());
            tv_gender.setText(tv_gender.getText() + user.getGender());
        }else {
            User user = (User) intent.getSerializableExtra("user");
            tv_user.setText(tv_user.getText() + user.getUserName());
            tv_password.setText(tv_password.getText() + user.getPassword());
            tv_gender.setText(tv_gender.getText() + user.getGender());
        }


    }


}
