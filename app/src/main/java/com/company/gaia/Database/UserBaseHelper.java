package com.company.gaia.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userBase.db";

    public UserBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Function that creates the user database.
     * In the beginning every columns is empty
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(name text primary key, email text, password text, transIndex double)");
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     *
     * Function that drops the user table if we upgrade the version of the user table.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    /**
     * Function that inserts values to the user table when the register button is pressed
     * @param name
     * @param email
     * @param password
     * @return
     *
     * name, email and password come from the register form.
     * Note that we do not insert any carbonIndex.
     * When the register button is pressed a new activity invokes and there users can answer the questions
     * after they have answered they press another confirmation button that invokes a update sql command to the database
     * to update only the columns that had new answers.
     */
    public boolean insert(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        // contentValues.put("transIndex", transIndex);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    /**
     * Function that checks if the name does exist in the database
     * @param name
     * @return
     *
     * The name value is primary key in our registration app. So that it has to be unique.
     * This function checks if the entered email exists in the database.
     */
    public Boolean chkName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM user WHERE name=?", new String[]{name});
        if (c.getCount() > 0) return false;
        else return true;
    }

    /**
     * Function that checks is the name and password are in the database for login
     * @param name
     * @param password
     * @return
     *
     * This is for the login, users have to have their name and password already in the database to log in.
     */
    public Boolean ChknamePassword(String name, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM user WHERE name=? AND password=?", new String[]{name, password});
        if (c.getCount() > 0) return true;
        else return false;
    }

    /**
     * This function is not used right now..
     * But it can be used to show user data in the users page.
     * @return
     */
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users", null);
        return c;
    }

    /**
     * Function that updates user database.
     * Updates for 'new' values in registration process. Values connected to carbonIndex
     */

    public boolean update(double transIndex) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("transIndex", transIndex);

        db.update("user", contentValues, "name = ?", new String[] {String.valueOf(transIndex)});
        return true;
    }

}
