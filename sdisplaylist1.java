package com.example.gauri.officialmentor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Displaylist extends AppCompatActivity
{
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    Databaseop1 databaseop1;
    Cursor cursor;
    Listdataadapter listdataadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaylist);
        listView = (ListView)findViewById(R.id.listview);
        listdataadapter = new Listdataadapter(getApplicationContext(),R.layout.raw_layout);
        listView.setAdapter(listdataadapter);
        databaseop1 = new Databaseop1(getApplicationContext());
        sqLiteDatabase = databaseop1.getReadableDatabase();
        cursor = databaseop1.retreiveInformation(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do
            {
                String roll,name;
                roll = cursor.getString(0);
                name = cursor.getString(1);
                Dataprovider dataprovider = new Dataprovider(roll,name);
                listdataadapter.add(dataprovider);


            }while (cursor.moveToNext());
        }
    }
}
