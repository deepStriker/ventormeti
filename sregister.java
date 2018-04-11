package com.example.gauri.officialmentor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity
{
    SQLiteDatabase db1;
    Button b1;
    EditText e1,e2,e3,e4,e5,e6;
    String fn,un,eid,pd,cpd,cn;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        b1 = (Button) findViewById(R.id.Breg);
        e1=(EditText)findViewById(R.id.TFname);
        e2=(EditText)findViewById(R.id.TFuname);
        e3=(EditText)findViewById(R.id.TFcnumber);
        e4=(EditText)findViewById(R.id.TFeid);
        e5=(EditText)findViewById(R.id.TFpswd);
        e6=(EditText)findViewById(R.id.TFcpswd);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn = e1.getText().toString();
                un = e2.getText().toString();
                cn = (e3.getText().toString());
                eid = e4.getText().toString();
                pd = e5.getText().toString();
                cpd = e6.getText().toString();

                if (e1.getText().length() != 0 && e2.getText().length() != 0 && e3.getText().length() != 0 && e4.getText().length() != 0 && e5.getText().length() != 0 && e6.getText().length() != 0) {

                    if (!(pd.equals(cpd))) {
                        Toast.makeText(getBaseContext(), "Passwords are not matching", Toast.LENGTH_LONG).show();
                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        e6.setText("");

                    } else {
                        Databaseop DB = new Databaseop(ctx);
                        DB.putInformation(DB, fn, un, cn, eid, pd, cpd);
                        Toast.makeText(getBaseContext(), "Registration has been done successfully", Toast.LENGTH_LONG).show();
                        finish();

                    }

                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please fill all the fields properly",Toast.LENGTH_LONG).show();
                }


            }
        });

    }

}
