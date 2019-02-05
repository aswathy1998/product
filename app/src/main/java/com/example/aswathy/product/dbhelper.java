package com.example.aswathy.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class dbhelper extends SQLiteOpenHelper {

    public static final String dbname="Mydb.db";
    public static final String Tablename="productdetails";
    public static final String col1="id";
    public static final String col2="productmodel";
    public static final String col3="productcode";
    public static final String col4="productname";
    public static final String col5="productsellername";
    public static final String col6="price";
    public static final String col7="ownername";
    public static final String col8="ownermobilenumber";


    public dbhelper(Context context) {
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text,"+col8+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exit"+Tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertdata(String productmodel,String productcode,String productname,String productsellername,String price,String ownername,String ownermobilenumber){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,productmodel);
        contentValues.put(col3,productcode);
        contentValues.put(col4,productname);
        contentValues.put(col5,productsellername);
        contentValues.put(col6,price);
        contentValues.put(col7,ownername);
        contentValues.put(col8,ownermobilenumber);

        long status=sqLiteDatabase.insert(Tablename,null,contentValues);
        if(status==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor searchdata(String productcode)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename+" WHERE "+col3+"='"+productcode+"'",null);
        return cur;

    }
    //update
    public boolean updateData(String id,String productmodel, String productname,String productsellername,String price,String ownername,String ownermobilenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,productmodel );
        contentValues.put(col4, productname);
        contentValues.put(col5, productsellername);
        contentValues.put(col6, price);
        contentValues.put(col7, ownername);
        contentValues.put(col8, ownermobilenumber);

        long status = db.update(Tablename,contentValues,col1 +"=" +id,null);
        if (status == -1) {
            return false;
        }
        else{
            return true;
        }
    }
    //delete
public boolean DeleteData(String id)
{
    SQLiteDatabase db=this.getWritableDatabase();
    long status = db.delete(Tablename,col1 +"=" +id,null);
    if (status == -1) {
        return false;
    }
    else{
        return true;
    }
}

}
