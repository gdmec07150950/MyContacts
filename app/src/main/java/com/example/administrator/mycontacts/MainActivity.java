package com.example.administrator.mycontacts;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //声明界面控件属性；
    private EditText nameEditText;
    private EditText danweiEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("添加联系人");

        //获取界面控件实例；
        nameEditText = (EditText) findViewById(R.id.name);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        qqEditText = (EditText) findViewById(R.id.qq);
        addressEditText = (EditText) findViewById(R.id.address);
    }

    //创建选项菜单；
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");

        return super.onCreateOptionsMenu(menu);
    }

    // 选项菜单点击事件；
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case 1:
                if(!nameEditText.getText().toString().equals("")){

                    //创建 User 对象；
                    User user = new User();
                    //user 对象赋值；
                    user.setName(nameEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setModile(mobileEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());

                    //创建数据对象；
                    ContactsTable ct = new ContactsTable(MainActivity.this);
                    //数据表添加数据；
                    if(ct.addData(user)){
                        Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"请输入数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}








