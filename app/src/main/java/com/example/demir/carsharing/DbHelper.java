package com.example.demir.carsharing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;


public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME="carsharing.db";
    public static final int DB_VERSION =1;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

    public static final String RES_TABLE = "reservation";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_START = "start";
    public static final String COLUMN_DESTINATION = "destination";



    /*
 create table users(
     id integer primary key autoincrement,
     email text,
     password text);
  */
    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public static final String CREATE_RES_TABLE = "CREATE TABLE " + RES_TABLE + "("
            + COLUMN_NAME + " TEXT,"
            + COLUMN_SURNAME + " TEXT,"
            + COLUMN_ADDRESS + " TEXT,"
            + COLUMN_PHONE + " TEXT,"
            + COLUMN_START + " TEXT,"
            + COLUMN_DESTINATION + " TEXT);";



    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_RES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+USER_TABLE);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXIST"+RES_TABLE);
        onCreate(db);
    }



    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public boolean getUser(String email, String pass){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + COLUMN_PASS + " = " + "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }


    // method for  inserting data from method reservation
    public void addReservation(String name,String surname,String address,String phone,String start,String destination)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SURNAME, surname);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_START, start);
        values.put(COLUMN_DESTINATION, destination);

        long a = db.insert(RES_TABLE,null,values);
        db.close();

        Log.e(TAG,"Data insetred"+a);
    }

    public boolean getData(String name,String surname,String address,String phone, String start, String destination){
        String query = "select * from  " + RES_TABLE + " where " +
                COLUMN_NAME + " = " + "'"+name+"'" + " , " + COLUMN_SURNAME + " = " + "'"+surname+"'";
    }


}

