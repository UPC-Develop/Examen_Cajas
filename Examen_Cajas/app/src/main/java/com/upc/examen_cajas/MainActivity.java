package com.upc.examen_cajas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.upc.examen_cajas.database.HelperDatabase;

public class MainActivity extends AppCompatActivity {

    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = findViewById(R.id.CreateButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelperDatabase helperDatabase = new HelperDatabase(MainActivity.this);

                SQLiteDatabase db = helperDatabase.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "¡La db se creo satisfactoriamente!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "¡Error al crear La db!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}