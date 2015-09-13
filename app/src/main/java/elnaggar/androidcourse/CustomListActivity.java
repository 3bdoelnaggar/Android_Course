package elnaggar.androidcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        Person person=new Person();
        person.setName("3bdo");
        person.setPicId(R.drawable.ic_number1);
        Person person1=new Person();
        person1.setName("Elnaggar");
        person1.setPicId(R.drawable.ic_number2);
        Person person2=new Person();
        person2.setName("Abdalla");
        person2.setPicId(R.drawable.ic_number3);
        Person person3=new Person();
        person3.setName("Android Course");
        person3.setPicId(R.drawable.ic_number4);

        ArrayList<Person>persons=new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);


        listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(new PersonAdapter(this,persons));
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person person= (Person) parent.getItemAtPosition(position);
        Toast.makeText(this,person.getName(),Toast.LENGTH_SHORT).show();

    }
}
