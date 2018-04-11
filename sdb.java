package com.example.gauri.officialmentor;

import android.provider.BaseColumns;

/**
 * Created by Gauri on 4/13/2016.
 */
public class Db
{
    public Db()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String Name = "name";
        public static final String User_Name = "username";
        public static final String Contact_Number = "cno";
        public static final String Email_Id = "emailid";
        public static final String Password = "password";
        public static final String Confirm_Password = "cpassword";
        public static final String Database_Name = "userinfo";
        public static final String Table_Name = "registerinfo";
    }
  /*  public Cursor getinformation(SQLiteDatabase db)
    {
        Cursor cursor;


    }*/
}
