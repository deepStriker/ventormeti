package com.example.gauri.officialmentor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Searchlist extends ActionBarActivity
{
    TextView Display_roll,Display_name,Display_contact,Display_parent;
    EditText Search_name;
    Databaseop1 databaseop1;
    SQLiteDatabase sqLiteDatabase;
    String search_name;
    Button Delete;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist);
        Search_name = (EditText) findViewById(R.id.enter_name);
        Display_roll = (TextView) findViewById(R.id.display_roll);
        Display_name = (TextView) findViewById(R.id.display_name);
        Display_contact = (TextView)findViewById(R.id.display_contact);
        Display_parent = (TextView)findViewById(R.id.display_parent);
        Delete = (Button) findViewById(R.id.Bdeletename);
        Display_roll.setVisibility(View.GONE);
        Display_name.setVisibility(View.GONE);
        Display_contact.setVisibility(View.GONE);
        Display_parent.setVisibility(View.GONE);
        Delete.setVisibility(View.GONE);
    }

    public void searchcontact (View view)
    {
      search_name = Search_name.getText().toString();
        databaseop1 = new Databaseop1(getApplicationContext());
        sqLiteDatabase = databaseop1.getReadableDatabase();
        Cursor cursor = databaseop1.getContact(search_name,sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            String ROLL = cursor.getString(0);
            String NAME = cursor.getString(1);
            String CONTACT = cursor.getString(2);
            String PARENT = cursor.getString(3);
            Display_roll.setText(ROLL);
            Display_name.setText(NAME);
            Display_contact.setText(CONTACT);
            Display_parent.setText(PARENT);
            Display_roll.setVisibility(View.VISIBLE);
            Display_name.setVisibility(View.VISIBLE);
            Display_contact.setVisibility(View.VISIBLE);
            Display_parent.setVisibility(View.VISIBLE);
            Delete.setVisibility(View.VISIBLE);
        }
    }

    public void deletename(View view)
    {
        databaseop1 = new Databaseop1(getApplicationContext());
        sqLiteDatabase = databaseop1.getReadableDatabase();
        databaseop1.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Entry Deleted",Toast.LENGTH_LONG).show();
    }

}
