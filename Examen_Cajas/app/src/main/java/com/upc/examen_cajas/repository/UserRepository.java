package com.upc.examen_cajas.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.upc.examen_cajas.database.HelperDatabase;
import com.upc.examen_cajas.entity.UserEntity;

import java.text.SimpleDateFormat;

public class UserRepository extends HelperDatabase {

    Context context;

    public UserRepository(@Nullable Context context) {
        super(context);
        this.context = context;
    }



    public long createUser(UserEntity userEntity){

        HelperDatabase helperDatabase = new HelperDatabase(context);
        SQLiteDatabase db = helperDatabase.getWritableDatabase();

        long user_id = 0;

        try {

            ContentValues values = new ContentValues();
            values.put("user_name", userEntity.getUser_name());
            values.put("password", userEntity.getPassword());
            values.put("first_name", userEntity.getFirst_name());
            values.put("last_name", userEntity.getLast_name());
            values.put("document_number", userEntity.getDocument_number());
            values.put("age", userEntity.getAge());
            values.put("height", userEntity.getHeight());

            user_id = db.insert(DATABASE_TABLE_USER, null,  values);

        }catch (Exception ex){
            Log.d("message", "Error: " + ex.getMessage());
        }

        return user_id;
    }


}
