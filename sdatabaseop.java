package com.example.gauri.officialmentor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gauri on 4/13/2016.
 */
public class Databaseop extends SQLiteOpenHelper
{
    public static final int database_version=1;
    public static final String Create_Query = "CREATE TABLE "+ Db.TableInfo.Table_Name+"("+ Db.TableInfo.Name+" VARCHAR NOT NULL,"+ Db.TableInfo.User_Name+" VARCHAR NOT NULL,"+ Db.TableInfo.Contact_Number+" VARCHAR NOT NULL,"+ Db.TableInfo.Email_Id+" VARCHAR NOT NULL,"+ Db.TableInfo.Password+" VARCHAR NOT NULL,"+ Db.TableInfo.Confirm_Password+" VARCHAR NOT NULL );";

    public Databaseop(Context context)
    {
        super(context, Db.TableInfo.Database_Name, null, database_version);
        Log.d("Database Operations", "Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(Create_Query);
        Log.d("Database Operations","table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void putInformation(Databaseop dop,String name,String username,String cno,String emailid,String password,String cpassword)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Db.TableInfo.Name,name);
        cv.put(Db.TableInfo.User_Name,username);
        cv.put(Db.TableInfo.Contact_Number,cno);
        cv.put(Db.TableInfo.Email_Id,emailid);
        cv.put(Db.TableInfo.Password,password);
        cv.put(Db.TableInfo.Confirm_Password, cpassword);
        long k = SQ.insert(Db.TableInfo.Table_Name,null,cv);
        Log.d("Database Operations","One Row Inserted ");

    }

    public Cursor getInformation(Databaseop dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {Db.TableInfo.User_Name, Db.TableInfo.Password};
        Cursor CR = SQ.query(Db.TableInfo.Table_Name, columns, null, null, null, null, null);
        return CR;
    }

}
