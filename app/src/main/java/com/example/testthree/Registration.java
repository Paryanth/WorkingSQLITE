package com.example.testthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText uname;
    EditText upass ;
    DBHelper dbHelper;
    Button register;
    private static final String dbName="studentdb";
    private static final String tbName="student" ;
    private static final int dbVersion = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        uname = findViewById(R.id.rname) ;
        upass = findViewById(R.id.rpass) ;



        register = findViewById(R.id.r_register) ;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Registration.this, ":"+uname.getText().toString()+":"+mupass, Toast.LENGTH_LONG).show();
                dbHelper = new DBHelper(Registration.this, dbName, null, dbVersion) ;
                long val = dbHelper.adduser(uname.getText().toString(), upass.getText().toString()) ;
                if(val == -1)
                    Toast.makeText(Registration.this, "Error in adding user", Toast.LENGTH_SHORT).show();
                else
                {
                    Toast.makeText(Registration.this, "USER REGISTERED", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(Registration.this, MainActivity.class);
                    startActivity(it);
                }

            }
        });
    }
}