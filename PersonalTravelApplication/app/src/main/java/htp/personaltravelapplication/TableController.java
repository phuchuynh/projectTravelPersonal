package htp.personaltravelapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import htp.personaltravelapplication.bean.ObjectAccount;
import htp.personaltravelapplication.bean.ObjectList;

/**
 * Created by phuchtgc60244 on 3/15/2016.
 */
//cai nay co the viet ra 1 cai helper dung cung cho cac bang lenh insert, update, delete o day, 1 file duy nhat

    //ket luan : tao them 1 bang a vua chi em se tao nhung gi ?
      //  table e tao roi  , drop e chua tao,  cái  file nay  chuyen sang file helper hả a
      //ko can
public class TableController extends  DatabaseHandler {


    private DatabaseHandler dbHandler;

    public TableController(Context context)
    {
        super(context);
    }



    public  boolean createAccount(ObjectAccount objectAccount)
    {
        ContentValues values  = new ContentValues();
        values.put("emailAcc",objectAccount.email);
        values.put("passAcc",objectAccount.pass);
        SQLiteDatabase db= this.getWritableDatabase();
        boolean createSuccessfull= db.insert("accounts",null,values)>0;
        db.close();
        return  createSuccessfull;
    }
    public boolean createListItem(ObjectList objectList){
        ContentValues values  = new ContentValues();
        values.put("title",objectList.title);
        values.put("content",objectList.content);
        values.put("lat",objectList.lat);
        values.put("lng",objectList.lng);
        values.put("zoom",objectList.zoom);
        SQLiteDatabase db= this.getWritableDatabase();
        boolean createSuccessfull= db.insert("lists",null,values)>0;
        db.close();
        return  createSuccessfull;
    }
    public ArrayList<ObjectList> getLists(){
        ArrayList<ObjectList> arrayList = new ArrayList<ObjectList>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from lists", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            ObjectList objectList = new ObjectList();
            objectList.id = res.getInt(res.getColumnIndex("id"));
            objectList.title  = res.getString(res.getColumnIndex("title"));
            objectList.content = res.getString(res.getColumnIndex("content"));
            objectList.lng = res.getString(res.getColumnIndex("lng"));
            objectList.lat = res.getString(res.getColumnIndex("lat"));
            objectList.zoom = res.getString(res.getColumnIndex("zoom"));
            arrayList.add(objectList);
            res.moveToNext();
        }
        return arrayList;
    }
    public ObjectList getListItem(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from lists where id = "+id, null );
        res.moveToFirst();
        ObjectList objectList = new ObjectList();
        while(res.isAfterLast() == false){
            objectList.id = res.getInt(res.getColumnIndex("id"));
            objectList.title  = res.getString(res.getColumnIndex("title "));
           objectList.content = res.getString(res.getColumnIndex("content"));
            objectList.lng = res.getString(res.getColumnIndex("lng"));
            objectList.lat = res.getString(res.getColumnIndex("lat"));
            objectList.zoom = res.getString(res.getColumnIndex("zoom"));
            res.moveToNext();
        }
        return objectList;
    }





}

