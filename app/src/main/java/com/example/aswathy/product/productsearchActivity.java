package com.example.aswathy.product;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class productsearchActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    String s1,s2,s3,s4,s5,s6,s7;
    String getid,getmodel,getname,getsname,getprice,getoname,getomobileno;
    Button b,b1,b2;
    dbhelper Dhelper;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productsearch);

        builder=new  AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure want to Delete");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();

                boolean status=Dhelper.DeleteData(getid);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"DELETED SUCESSFULLY",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR IN DELETION",Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"No clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        b=(Button)findViewById(R.id.srch2);
        b1=(Button)findViewById(R.id.up);
        b2=(Button)findViewById(R.id.dl);
        tv1=(TextView)findViewById(R.id.pcode);
        tv2=(TextView)findViewById(R.id.t1);
        tv3=(TextView)findViewById(R.id.t2);
        tv4=(TextView)findViewById(R.id.t3);
        tv5=(TextView)findViewById(R.id.t4);
        tv6=(TextView)findViewById(R.id.t5);
        tv7=(TextView)findViewById(R.id.t6);




        ed1=(EditText)findViewById(R.id.p1);
        ed2=(EditText)findViewById(R.id.p2);
        ed3=(EditText)findViewById(R.id.p3);
        ed4=(EditText)findViewById(R.id.p4);
        ed5=(EditText)findViewById(R.id.p5);
        ed6=(EditText)findViewById(R.id.p6);

        Dhelper=new dbhelper(this);
        Dhelper.getWritableDatabase();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                boolean status=Dhelper.DeleteData(getid);
//                if(status==true){
//                    Toast.makeText(getApplicationContext(),"DELETED SUCESSFULLY",Toast.LENGTH_LONG).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"ERROR IN DELETION",Toast.LENGTH_LONG).show();
//                }
                AlertDialog alert =builder.create();
                alert.show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getmodel=ed1.getText().toString();
                getname=ed2.getText().toString();
                getsname=ed3.getText().toString();
                getprice=ed4.getText().toString();
                getoname=ed5.getText().toString();
                getomobileno=ed6.getText().toString();

                boolean status=Dhelper.updateData(getid,getmodel,getname,getsname,getprice,getoname,getomobileno);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"UPDATED SUCESSFULLY",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR IN UPDATION",Toast.LENGTH_LONG).show();
                }



            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=tv1.getText().toString();
                Log.d("model",s1);


                Cursor cur=Dhelper.searchdata(s1);
                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no code found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {

                        b1.setVisibility(view.VISIBLE);
                        b2.setVisibility(view.VISIBLE);
                        s2=cur.getString(1);
                       // Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                        tv2.setVisibility(view.VISIBLE);

                        ed1.setVisibility(view.VISIBLE);
                       ed1.setText(s2);


                        s3=cur.getString(3);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        tv3.setVisibility(view.VISIBLE);

                        ed2.setVisibility(view.VISIBLE);
                       ed2.setText(s3);


                        s4=cur.getString(4);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        tv4.setVisibility(view.VISIBLE);

                        ed3.setVisibility(view.VISIBLE);
                        ed3.setText(s4);


                        s5=cur.getString(5);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        tv5.setVisibility(view.VISIBLE);

                        ed4.setVisibility(view.VISIBLE);
                        ed4.setText(s5);

                        s6=cur.getString(6);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        tv6.setVisibility(view.VISIBLE);

                        ed5.setVisibility(view.VISIBLE);
                        ed5.setText(s6);

                        s7=cur.getString(7);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        tv7.setVisibility(view.VISIBLE);

                        ed6.setVisibility(view.VISIBLE);
                        ed6.setText(s7);


                        getid=cur.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
                    }
                }



            }
        });
    }
}
