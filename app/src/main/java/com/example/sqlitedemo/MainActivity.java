package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name_txt);
        contact = findViewById(R.id.contact_txt);
        dob = findViewById(R.id.dob_txt);
        insert = findViewById(R.id.button_new_data);
        update = findViewById(R.id.button_update);
        delete = findViewById(R.id.button_delete);
        view = findViewById(R.id.button_view_data);

        DB = new DBHelper(this);
        // break until 2:00 pm

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String dobTxt = dob.getText().toString();
                Boolean checkinsertData = DB.insertuserdata(nameTxt,contactTxt,dobTxt);

                if(checkinsertData){
                    Toast.makeText(MainActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(MainActivity.this,"New Entry NOT Inserted",Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Update pressed",Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Delete pressed",Toast.LENGTH_SHORT).show();


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"view pressed",Toast.LENGTH_SHORT).show();


            }
        });
    }
}