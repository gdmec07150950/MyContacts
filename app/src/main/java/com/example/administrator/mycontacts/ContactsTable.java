package com.example.administrator.mycontacts;

/**
 * Created by Administrator on 2016/10/26.
 */
import android.content.ContentValues;
import android.content.Context;



public class ContactsTable {

    //数据表名常量；
    private final static String TABLENAME = "contactsTable";

    //声明数据库对象；
    private MyDB db;

    //构造方法；
    public ContactsTable(Context context){

        //创建 MyDB 对象；
        db = new MyDB(context);
        if(!db.isTableExits(TABLENAME)){
            String createTableSql = "CREATE TABLE IF NOT EXISTS "+ TABLENAME +
                    "( id_DB integer"+
                    User.DANWEI + "VARCHAR" +
                    User.MOBILE + "VARCHAR" +
                    User.QQ + "VARCHAR" +
                    User.ADDRESS + "VARCHAR )";
            db.createTable(createTableSql);
        }
    }
    //添加数据；
    public boolean addData(User user){

        //创建 ContentValues 对象用于保存数据；
        ContentValues values = new ContentValues();
        // contentvalue 赋值；
        values.put(User.NAME,user.getName());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.MOBILE,user.getModile());
        values.put(User.ADDRESS,user.getAddress());

        //保存数据；
        return db.save(TABLENAME,values);
    }

}

