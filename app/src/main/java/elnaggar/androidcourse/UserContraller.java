package elnaggar.androidcourse;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Elnaggar on 29/08/2015.
 */
public class UserContraller {
    private static final String FOLDERNAME ="user" ;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String remember="rember";
    private String password="pas";
    private String userName="username";
    private String gender="gender";

    public UserContraller(Context context){
        sharedPreferences=context.getSharedPreferences(FOLDERNAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }
    public void saveDate(User user){
        editor.putBoolean(remember,true);
        editor.putString(userName, user.getUserName());
        editor.putString(password, user.getPassword());
        editor.putString(gender, user.getGender());
        editor.commit();

    }
    public boolean isRemeb(){
        if(sharedPreferences.getBoolean(remember,false)){
            return true;
        }
        else
            return false;
    }
    public User getData(){
        User user=new User();
        user.setUserName(sharedPreferences.getString(userName,"none"));
        user.setPassword(sharedPreferences.getString(password,"none"));
        user.setGender(sharedPreferences.getString(gender,"none"));
        return user;
    }
}
