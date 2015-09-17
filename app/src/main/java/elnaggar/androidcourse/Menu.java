package elnaggar.androidcourse;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Elnaggar on 24/08/2015.
 */
public class Menu extends ListActivity {
    String []classes={"elnaggar.androidcourse.MainActivity","elnaggar.androidcourse.LoginActivity"
            ,"elnaggar.androidcourse.ProductActivity","elnaggar.androidcourse.ActionMenuActivity"
            ,"elnaggar.androidcourse.NotificationActivity","elnaggar.androidcourse.CustomListActivity"
            ,"elnaggar.androidcourse.HttpConnectionActivity","elnaggar.androidcourse.DrawerActivity"};
    String []names={"Dialog","Login Activity","Product Activity","Action Menu","Notification","ListView","Http Connection","Navigation Drawer"};

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
            Class aClass=Class.forName(classes[position]);
            Intent intent=new Intent(this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
    }
}
