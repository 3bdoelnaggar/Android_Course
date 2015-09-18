package elnaggar.androidcourse;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrawerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        listView= (ListView) findViewById(R.id.drawer);
        drawerLayout= (DrawerLayout) findViewById(R.id.navigation_drawer);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"First Fragment"
                , "Second Fragment", "Third Fragment"}));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
               fragmentManager = getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new FirstFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();


                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new SecondFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();



                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new ThirdFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();




                break;
        }
    }
}
