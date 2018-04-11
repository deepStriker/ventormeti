package com.example.gauri.officialmentor;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addmentee extends AppCompatActivity
{
    SQLiteDatabase db2;
    Button button1,button2;
    EditText et1,et2,et3,et4;
    String rn,n,cno,pn;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmentee);
        button1 = (Button) findViewById(R.id.Badd);
        button2=(Button)findViewById(R.id.Bback);
        et1=(EditText)findViewById(R.id.TFrno);
        et2=(EditText)findViewById(R.id.TFn);
        et3=(EditText)findViewById(R.id.TFcn);
        et4=(EditText)findViewById(R.id.TFpcn);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rn = et1.getText().toString();
                n = et2.getText().toString();
                cno = (et3.getText().toString());
                pn = et4.getText().toString();

                if (et1.getText().length() != 0 && et2.getText().length() != 0 && et3.getText().length() != 0 && et4.getText().length() != 0) {


                    if (v.getId() == R.id.Badd) {
                        Databaseop1 DB1 = new Databaseop1(ctx);
                        DB1.putInformation(DB1, rn, n, cno, pn);
                        Toast.makeText(getBaseContext(), "One row added successfully", Toast.LENGTH_LONG).show();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");


                    } else {


                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please Fill All The Fields Properly",Toast.LENGTH_LONG).show();
                }




            }
        });

    }
    public void buttonClick4(View view)
    {
        Intent i = new Intent(this,Display.class);
        startActivity(i);
    }

}
