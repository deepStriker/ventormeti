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
public class Databaseop1 extends SQLiteOpenHelper
{
    String[] projections;
    public static final int database_version=1;
    public static final String Create_Query1 = "CREATE TABLE "+ Db1.TableInformation.Table_Name+"("+ Db1.TableInformation.Roll_NO+" VARCHAR NOT NULL,"+ Db1.TableInformation.Name+" VARCHAR NOT NULL,"+ Db1.TableInformation.Contact_Number+" VARCHAR NOT NULL,"+ Db1.TableInformation.Parent_Number+" VARCHAR NOT NULL );";

    public Databaseop1(Context context)
    {
        super(context, Db1.TableInformation.Database_Name, null, database_version);
        Log.d("Database Operations", "Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(Create_Query1);
        Log.d("Database Operations","table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion)
    {

    }

    public void putInformation(Databaseop1 dop1, String rno, String name, String cno, String pno)
    {
        SQLiteDatabase SQ1 = dop1.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(Db1.TableInformation.Roll_NO,rno);
        cv1.put(Db1.TableInformation.Name,name);
        cv1.put(Db1.TableInformation.Contact_Number,cno);
        cv1.put(Db1.TableInformation.Parent_Number,pno);
        long k = SQ1.insert(Db1.TableInformation.Table_Name,null,cv1);
        Log.d("Database Operations","One Row Inserted ");


    }

    public Cursor retreiveInformation (SQLiteDatabase sqdb)
    {
        Cursor cursor;
        String[] projections = new String[2];
        projections[0]= Db1.TableInformation.Roll_NO;
        projections[1]= Db1.TableInformation.Name;
        cursor = sqdb.query(Db1.TableInformation.Table_Name,projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getContact (String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String[] projections = new String[4];
        projections[0] = Db1.TableInformation.Roll_NO;
        projections[1] = Db1.TableInformation.Name;
        projections[2] = Db1.TableInformation.Contact_Number;
        projections[3] = Db1.TableInformation.Parent_Number;
        String selection = Db1.TableInformation.Name+" LIKE ?";
        String[] selection_args = {user_name};
        Cursor cursor = sqLiteDatabase.query(Db1.TableInformation.Table_Name,projections,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deleteInformation(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String selection = Db1.TableInformation.Name+" LIKE ?";
        String[] selection_args = {user_name};
        sqLiteDatabase.delete(Db1.TableInformation.Table_Name,selection,selection_args);

    }

    public int updateInformation(String old_name,String new_name,String new_roll,String new_contact,String new_parent,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db1.TableInformation.Name,new_name);
        contentValues.put(Db1.TableInformation.Roll_NO,new_roll);
        contentValues.put(Db1.TableInformation.Contact_Number,new_contact);
        contentValues.put(Db1.TableInformation.Parent_Number,new_parent);
        String selection = Db1.TableInformation.Name+" LIKE ?";
        String[] selection_args = {old_name};
        int count =sqLiteDatabase.update(Db1.TableInformation.Table_Name,contentValues,selection,selection_args);
        return count;
    }


}
