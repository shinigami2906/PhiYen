package vn.daikon.myapplication.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import vn.daikon.myapplication.model.Product;


public class ProductRepo extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "product";
    private static final String KEY_IMAGE_ID = "image_id";

    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    public ProductRepo(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s TEXT, %s TEXT , %s TEXT)", TABLE_NAME, KEY_IMAGE_ID,KEY_NAME,KEY_AGE );
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.name);
        values.put(KEY_AGE, product.age);
        values.put(KEY_IMAGE_ID, product.imageID);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public List<Product> getAllProduct() {
        List<Product> studentList = new ArrayList<>();
        String query = " SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Product product = new Product(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            studentList.add(product);
            cursor.moveToNext();
        }
        return studentList;
    }
}
