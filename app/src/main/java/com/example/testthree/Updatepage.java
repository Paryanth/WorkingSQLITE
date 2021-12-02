package com.example.testthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatepage extends AppCompatActivity {
    EditText uname;
    EditText upass ;
    DBHelper dbHelper;
    Button update;
    private static final String dbName="studentdb";
    private static final int dbVersion = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepage);
        uname = findViewById(R.id.name) ;
        upass = findViewById(R.id.pass) ;
        update= findViewById(R.id.update);
        String _uname = uname.getText().toString();
        String _upass = upass.getText().toString();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(Updatepage.this, dbName, null, dbVersion) ;
                dbHelper.update(_uname,_upass);
                Intent it = new Intent(Updatepage.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}