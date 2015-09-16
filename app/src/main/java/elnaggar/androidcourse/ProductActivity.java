package elnaggar.androidcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends Activity {
    EditText name,price,id;
    TextView show;
    DatabaseController databaseController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        name= (EditText) findViewById(R.id.ed_name);
        price= (EditText) findViewById(R.id.ed_price);
        show= (TextView) findViewById(R.id.tv_show_data);
        id= (EditText) findViewById(R.id.ed_id);
        databaseController=new DatabaseController(this);
        databaseController.open();
    }


    public void onAddClick(View view) {
        Product product=new Product();
        product.setName(name.getText().toString());
        product.setPrice(price.getText().toString());

        databaseController.insert(product);
    }

    public void onGetAllCilck(View view) {
        show.setText("");
        ArrayList<Product>products=databaseController.getData();
        for (int i=0;i<products.size();i++){
            Product product=products.get(i);
            show.setText(show.getText()+product.getName()+"   "+product.getPrice()+"\n");
        }
    }

    public void onGetProductClick(View view) {
        Product product=databaseController.getProduct(Long.valueOf(id.getText().toString()));
        if(product!=null) {
            show.setText(product.getName() + "   " + product.getPrice() + "\n");
        }else{
            Toast.makeText(this,"wrong row id",Toast.LENGTH_SHORT).show();
        }
    }

    public void onUpdateProductClick(View view) {

        Product product=new Product();
        product.setName(name.getText().toString());
        product.setPrice(price.getText().toString());
        databaseController.Update(Long.valueOf(id.getText().toString()),product);
    }

    public void onRemoveClick(View view) {
        databaseController.remove(Long.valueOf(id.getText().toString()));

    }
}
