package com.example.administrator.mycontacts;

/**
 * Created by Administrator on 2016/10/26.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDB extends SQLiteOpenHelper {

    private static String DB_NAME = "My_DB.db";
    private static int DB_VERSION = 2;
    private SQLiteDatabase db;
    ;

    //构造方法   Context 是获取数据文件存放位置
    public MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //打开数据库；
    public SQLiteDatabase openConnection(){

        if(!db.isOpen()) {
            db = getWritableDatabase();
        }
        return db;
    }
    //关闭数据库；
    public void closeConnection(){
        try{
            if(db!=null && db.isOpen()){
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //创建数据库；
    public boolean createTable(String createTableSql){
        try{
            openConnection();
            db.execSQL(createTableSql);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    //保存数据；
    public boolean save(String tableName,ContentValues values){
        try {
            openConnection();
            db.insert(tableName,null,values);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            closeConnection();
        }
        return true;
    }


    public boolean isTableExits(String tablename) {
        try{
            openConnection();
            String sql = "select count(*) from "+tablename;
            db.rawQuery(sql,null).close();
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
}
