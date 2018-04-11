package com.example.gauri.officialmentor;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText USERNAME,USERPASS;
    String username,userpass;
    Context CTX = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        USERNAME = (EditText)findViewById(R.id.TFusername);
        USERPASS = (EditText)findViewById(R.id.TFpassword);
    }

    public void buttonClick1(View view)
    {
        username = USERNAME.getText().toString();
        userpass = USERPASS.getText().toString();
        Databaseop DOP = new Databaseop(CTX);
        Cursor CR = DOP.getInformation(DOP);
        CR.moveToFirst();
        boolean loginstatus = false;
        do
        {
          if (username.equals(CR.getString(0))&&(userpass.equals(CR.getString(1))))
          {
              loginstatus = true;
          }
        }while (CR.moveToNext());

        if(loginstatus)
        {
            Intent i = new Intent(this, Display.class);
            startActivity(i);
        }

        else
        {
            Toast.makeText(getBaseContext(),"LOGIN FAILED ",Toast.LENGTH_LONG);
        }
    }

    public void buttonClick2(View view)
    {
        Intent i = new Intent(this,Register.class);
        startActivity(i);
    }


}
