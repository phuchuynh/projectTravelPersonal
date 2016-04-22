package htp.personaltravelapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by phuchtgc60244 on 3/14/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public  static  final  int DATABASE_VERSION =1;
    protected  static  final  String DATABASE_NAME="TravelDatabase.db";
    protected  static  final  String DATABASE_TABLE="accounts";
    protected  static  final  String DATABASE_TABLE_LIST="lists";
    protected  static  final  String LIST_ID="id";
    protected  static  final  String LIST_TITLE="title";
    protected  static  final  String LIST_CONTENT="content";
    protected  static  final  String LIST_LNG="lng";
    protected  static  final  String LIST_LAT="lat";


    SQLiteDatabase db;
    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db=getWritableDatabase();
    }
    @Override
    public  void  onCreate(SQLiteDatabase db)
    {
        String queryAcc ="CREATE TABLE  accounts"+"(emailAcc TEXT,"+"passAcc TEXT)";
        String queryList ="CREATE TABLE lists"+"(id integer primary key AUTOINCREMENT, "+"title text,"+"content text,"+"lng text,"+"lat text,"+"zoom text)";
         db.execSQL(queryAcc);
        db.execSQL(queryList);
    }


    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sqlAcc="DROP TABLE IF EXISTS accounts";
        String sqlList="DROP TABLE IF EXISTS lists";
        db.execSQL(sqlAcc);
        db.execSQL(sqlList);
        onCreate(db);
    }





}


