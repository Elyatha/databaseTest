package com.example.databasetest;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MyDBAdabter myDB;
    EditText name, id, mark;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new MyDBAdabter(this);
        name = (EditText) findViewById(R.id.editNAME);
        id = (EditText) findViewById(R.id.editID);
        mark = (EditText) findViewById(R.id.editMARK);
        add = (Button) findViewById(R.id.button);

    }

    public void enterAdd(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insertValues = myDB.insertCol(name.getText().toString(), id.getText().toString(),
                        mark.getText().toString());
                if(insertValues)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
