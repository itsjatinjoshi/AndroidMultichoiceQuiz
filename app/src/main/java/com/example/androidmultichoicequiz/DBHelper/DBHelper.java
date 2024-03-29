package com.example.androidmultichoicequiz.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidmultichoicequiz.model.Category;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import static okhttp3.internal.Internal.instance;


public class DBHelper extends SQLiteAssetHelper {

    private static String DB_NAME = "EDMTQuiz2019.db";
    private static int DB_VER = 1;

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;

    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Category> getAllCategories() {
        SQLiteDatabase db = instance.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Category", null);
        List<Category> categories = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                Category category = new Category(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("Image")));
                categories.add(category);

                //    System.out.println("hellooooooooooooooooooooooooo"+category);

            }
            cursor.close();
            db.close();
        }
        return categories;
    }
}
