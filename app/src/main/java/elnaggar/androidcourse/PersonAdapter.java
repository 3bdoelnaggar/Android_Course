package elnaggar.androidcourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Elnaggar on 09/09/2015.
 */
public class PersonAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<Person> persons;

    public PersonAdapter(Context context,ArrayList<Person> persons){
       this.inflater= LayoutInflater.from(context);
        this.persons=persons;

    }
    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(R.layout.custom_item,parent,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView_item);
        TextView textView= (TextView) view.findViewById(R.id.textView_item);
        imageView.setImageResource(persons.get(position).picId);
        textView.setText(persons.get(position).getName());
        return view;
    }
}
