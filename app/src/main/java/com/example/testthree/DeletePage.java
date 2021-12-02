package com.example.testthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeletePage extends AppCompatActivity {
    private static final String dbName="studentdb";
    private static final int dbVersion = 1 ;
    EditText duname ;
    Button delete ;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_page);
        duname = findViewById(R.id.name) ;
        delete = findViewById(R.id.delete) ;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(DeletePage.this, dbName,null, dbVersion) ;
                dbHelper.delete(duname.getText().toString());
                Intent it = new Intent(DeletePage.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
}