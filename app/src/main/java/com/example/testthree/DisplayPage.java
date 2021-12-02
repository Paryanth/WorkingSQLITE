package com.example.testthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {
    TextView text ;
    DBHelper dbHelper;
    private static final String dbName="studentdb";
    private static final int dbVersion = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);
        text = findViewById(R.id.textView) ;
        dbHelper = new DBHelper(DisplayPage.this, dbName, null, dbVersion);
        String out= dbHelper.display(DisplayPage.this);
        text.setText(out);
    }
}