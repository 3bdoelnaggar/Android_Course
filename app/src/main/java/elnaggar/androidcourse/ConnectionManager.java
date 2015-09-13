package elnaggar.androidcourse;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Elnaggar on 11/09/2015.
 */
public class ConnectionManager {
    public static boolean isIntenetConectted(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null)
            return true;
        return false;
    }

    public static HttpURLConnection openConnection(String link) throws IOException {
        URL url=new URL(link);
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
       // httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        return httpURLConnection;
    }
     public static String getResult(HttpURLConnection httpURLConnection) throws IOException {
         if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
             InputStream inputStream = httpURLConnection.getInputStream();
             StringBuilder stringBuilder = new StringBuilder();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             String line;
             while ((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line);
             }
             return stringBuilder.toString();
         }else
             return "something wrong";


     }
}
