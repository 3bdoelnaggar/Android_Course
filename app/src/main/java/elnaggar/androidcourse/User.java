package elnaggar.androidcourse;

import java.io.Serializable;

/**
 * Created by Elnaggar on 25/08/2015.
 */
public class User implements Serializable{
   private  String userName;
    private String password;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
