package com.example.gauri.officialmentor;

import android.provider.BaseColumns;

/**
 * Created by Gauri on 4/13/2016.
 */
public  final
class Db1
{
    public Db1()
    {

    }
    public static abstract class TableInformation implements BaseColumns
    {
        public static final String Name = "name";

        public static final String Roll_NO= "rno";
        public static final String Contact_Number = "cno";
        public static final String Parent_Number = "pno";
        public static final String Database_Name = "menteeinfo";
        public static final String Table_Name = "studentinfo";

    }
  /*  public Cursor getinformation(SQLiteDatabase db)
    {
        Cursor cursor;


    }*/

}
