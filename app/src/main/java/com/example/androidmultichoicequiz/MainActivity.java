package com.example.androidmultichoicequiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.androidmultichoicequiz.Adapter.CategoryAdapter;
import com.example.androidmultichoicequiz.Common.Spacedecoration;
import com.example.androidmultichoicequiz.DBHelper.DBHelper;
import com.example.androidmultichoicequiz.model.Category;

import java.util.ArrayList;

import static com.example.androidmultichoicequiz.DBHelper.DBHelper.getInstance;


public class MainActivity extends AppCompatActivity {

    public Toolbar toolBar;
    RecyclerView recycler_category;

   // @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runtime rt = Runtime.getRuntime();
        long maxMemory = rt.maxMemory();
        Log.v("onCreate", "maxMemory:" + Long.toString(maxMemory));

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("Quiz App made by Jatin");
        setSupportActionBar(toolBar);

        recycler_category = (RecyclerView) findViewById(R.id.recycle_category);
        recycler_category.setHasFixedSize(true);
        recycler_category.setLayoutManager(new GridLayoutManager(this, 2));

        //Get Screen Height
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels /8;


       //

        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this,
                DBHelper.getInstance(this).getAllCategories());

        System.out.println("why111" +DBHelper.getInstance(this).getAllCategories());


        int spaceInPixal = 4;
        recycler_category.addItemDecoration(new Spacedecoration(spaceInPixal));
        recycler_category.setAdapter(adapter);




    }


}
