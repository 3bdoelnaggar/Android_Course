package elnaggar.androidcourse;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Elnaggar on 12/09/2015.
 */
public class httpTask extends AsyncTask<String,Void,String> {
    private final Context context;
    public httpTask(Context context){
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String s=null;
        try {
           HttpURLConnection httpURLConnection= ConnectionManager.openConnection(params[0]);
             s=ConnectionManager.getResult(httpURLConnection);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson=new Gson();
        JSONUser jsonUser=gson.fromJson(s,JSONUser.class);

        Toast.makeText(context,jsonUser.getEmail(),Toast.LENGTH_LONG).show();
    }
}
