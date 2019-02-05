package com.example.aswathy.product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button b,b1;
    String s1,s2,s3,s4,s5,s6,s7;
    dbhelper databasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.pm);
        ed2=(EditText)findViewById(R.id.pc);
        ed3=(EditText)findViewById(R.id.pn);
        ed4=(EditText)findViewById(R.id.psn);
        ed5=(EditText)findViewById(R.id.price);
        ed6=(EditText)findViewById(R.id.own);
        ed7=(EditText)findViewById(R.id.mobno);
        b=(Button)findViewById(R.id.sub);
        b1=(Button)findViewById(R.id.srch);
        databasehelper=new dbhelper(this);
        databasehelper.getWritableDatabase();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                s4=ed4.getText().toString();
                s5=ed5.getText().toString();
                s6=ed6.getText().toString();
                s7=ed7.getText().toString();
                Log.d("productmodel",s1);
                Log.d("productcode",s2);
                Log.d("productname",s3);
                Log.d("productsellername",s4);
                Log.d("price",s5);
                Log.d("ownername",s6);
                Log.d("ownermobileno",s7);


                boolean status=databasehelper.insertdata(s1,s2,s3,s4,s5,s6,s7);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),productsearchActivity.class);
                startActivity(i);
            }

        });

    }
}
