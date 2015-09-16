package elnaggar.androidcourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Elnaggar on 30/08/2015.
 */
public class DatabaseController {
    private final static String DATABASE_NAME = "products";
    private final static String DATABASE_Table = "product";
    private final int DATABASE_VERSION = 1;
    private final String KEY_ID = "_id";
    private final String KEY_NAME = "_name";
    private final String KEY_PRICE = "_price";
    private final Context context;

    SQLiteDatabase sqLiteDatabase;
    DBhelber dBhelber;

    public DatabaseController(Context context) {
        this.context = context;
    }

    private class DBhelber extends SQLiteOpenHelper {

        public DBhelber(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_Table + "(" + KEY_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
                    + " TEXT NOT NULL," + KEY_PRICE + " TEXT NOT NULL);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop Table iF exist" + DATABASE_Table);
            onCreate(db);

        }
    }

    public void open() {
        dBhelber = new DBhelber(context);
        sqLiteDatabase = dBhelber.getWritableDatabase();
    }

    public void insert(Product product) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, product.getName());
        contentValues.put(KEY_PRICE, product.getPrice());
        sqLiteDatabase.insert(DATABASE_Table, null, contentValues);
    }

    public ArrayList<Product> getData() {
        ArrayList<Product> products = new ArrayList<>();
        String[] clumns = {KEY_NAME, KEY_PRICE};
        Cursor cursor = sqLiteDatabase.query(DATABASE_Table, clumns, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Product product = new Product();
            product.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            product.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
            products.add(product);
        }
        return products;
    }

    public Product getProduct(Long rowId) {
        String[] clumns = {KEY_ID, KEY_NAME, KEY_PRICE};
        Cursor cursor = sqLiteDatabase.query(DATABASE_Table, clumns, KEY_ID + "=" + rowId, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            Product product = new Product();
            product.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            product.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
            return product;

        }
        return null;
    }

    public void Update(Long rowId, Product product) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, product.getName());
        contentValues.put(KEY_PRICE, product.getPrice());
        sqLiteDatabase.update(DATABASE_Table, contentValues, KEY_ID + "=" + rowId, null);
    }

    public void remove(Long rowId) {
        sqLiteDatabase.delete(DATABASE_Table, KEY_ID + "=" + rowId, null);
    }


}
