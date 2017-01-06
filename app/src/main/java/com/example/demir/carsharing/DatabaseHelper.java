package com.example.demir.carsharing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Demir on 19.12.2016..
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="carsharing.db";
    private static final String TABLE_NAME="user";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_UNAME="uname";
    private static final String COLUMN_PASS="pass";
    SQLiteDatabase sqLiteDatabase;
    private static final String TABLE_CREATE = "create table user(id integer primary key not null  ,"
            +"name text not null, email text not null, uname text not null, pass text not null)";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase=sqLiteDatabase;
    }

    public void insertContact(Contact c)
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from user";
        Cursor cursor=sqLiteDatabase.rawQuery(query, null);
        int count = cursor.getCount();



        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }



    public String searchPass(String uname)
    {
        sqLiteDatabase = this.getReadableDatabase();
            String query = "select * from user";
        Cursor cursor =sqLiteDatabase.rawQuery(query, null);
        String a,b = null; // a->username, b->password
        b="not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }
            return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String  query  = "DROP TABLE IF EXIST"+ TABLE_NAME;
        sqLiteDatabase .execSQL(query);
        this.onCreate(sqLiteDatabase);
    }
}
