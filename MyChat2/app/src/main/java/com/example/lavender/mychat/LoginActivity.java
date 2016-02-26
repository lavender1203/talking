package com.example.lavender.mychat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lavender.mychat.common.Const;
import com.example.lavender.mychat.common.Storage;
import com.example.lavender.mychat.common.XMPPUtil;
import com.example.lavender.mychat.data.DataWareHouse;
import com.example.lavender.mychat.data.LoginData;

import org.jivesoftware.smack.XMPPConnection;


public class LoginActivity extends Activity implements Const{
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private EditText mEditTextServer;

    private CheckBox mCheckBoxSavePassword;
    private CheckBox mCheckBoxAutoLogin;
    private LoginData mLoginData;
    private Button btn_login;

    //登陆服务器的方法
    private boolean login(){
        try{
//            XMPPConnection connection = XMPPUtil.getXMPPConnection("192.168.1.221");
            XMPPConnection connection = XMPPUtil.getXMPPConnection(mLoginData.loginServer);
            if(connection == null){
                throw new Exception("连接聊天服务器失败.");
            }
//            connection.login("lavender", "19931203");
            connection.login(mLoginData.username, mLoginData.password);
//            connection.login(mLoginData.username, mLoginData.password);
            DataWareHouse.setXMPPConnection(this, connection);

            //get friends

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.button);
        mEditTextUsername = (EditText) findViewById(R.id.edittext_user);
        mEditTextPassword = (EditText) findViewById(R.id.edittext_password);
        mEditTextServer = (EditText) findViewById(R.id.edittext_server);
        mCheckBoxSavePassword = (CheckBox) findViewById(R.id.checkbox_save_password);
        mCheckBoxAutoLogin = (CheckBox) findViewById(R.id.checkbox_auto_login);
        mLoginData = DataWareHouse.getGlobalData(this).loginData;

        mLoginData.username = Storage.getString(this, KEY_USERNAME);
        mLoginData.password = Storage.getString(this, KEY_PASSWORD);
        mLoginData.loginServer = Storage.getString(this, KEY_LOGIN_SERVER);
        mLoginData.isAutoLogin = Storage.getBoolean(this, KEY_AUTO_LOGIN);
        mLoginData.isSavePassword = Storage.getBoolean(this, KEY_SAVE_PASSWORD);

        mEditTextUsername.setText(mLoginData.username);
        mEditTextServer.setText(mLoginData.loginServer);
        mCheckBoxAutoLogin.setChecked(mLoginData.isAutoLogin);
        mCheckBoxSavePassword.setChecked(mLoginData.isSavePassword);

        if (mLoginData.isSavePassword) {
            mEditTextServer.setText(mLoginData.password);
        }

        if (mLoginData.isAutoLogin) {
            onClick_Login(null);
        }
    }
    private Handler mHandler = new Handler();

    public void onClick_Login(View view) {
                //

                mLoginData.username = mEditTextUsername.getText().toString();
                mLoginData.password = mEditTextPassword.getText().toString();
                mLoginData.loginServer = mEditTextServer.getText().toString();
                mLoginData.isSavePassword = mCheckBoxSavePassword.isChecked();
                mLoginData.isAutoLogin = mCheckBoxAutoLogin.isChecked();


                //存储登陆信息
                Storage.putString(this, KEY_USERNAME, mLoginData.username);
                Storage.putString(this, KEY_LOGIN_SERVER, mLoginData.loginServer);
                Storage.putBoolean(this, KEY_AUTO_LOGIN, mLoginData.isAutoLogin);
                Storage.putBoolean(this, KEY_SAVE_PASSWORD, mLoginData.isSavePassword);
                if(mLoginData.isSavePassword){
                    Storage.putString(this, KEY_SAVE_PASSWORD, mLoginData.password);
                }
                //获取文本框输入的用户名和密码信息
//                EditText user = ((EditText) findViewById(R.id.user));
//                String user_str = user.getText().toString();
//                EditText password = (EditText) findViewById(R.id.password);
//                String password_str = password.getText().toString();
                //默认用户名和密码为 lavender 19931203
//                if (user_str.equals("疯雨")) {
//                    if (password_str.equals("19931203")) {
//                        //登陆成功
//                        Toast.makeText(LoginActivity.this, "登陆成功!", Toast.LENGTH_SHORT).show();
//                        //这个是直接跳转到MainActivity

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                //登陆成功
                                if(login()){
//                                  if(true){
//                                    Toast.makeText(LoginActivity.this, "用户正确", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    mHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(LoginActivity.this,"登陆失败，请检查输入信息", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        }).start();

//                    } else {
//                        //密码不正确
//                        Toast.makeText(LoginActivity.this, "密码不正确！", Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    //用户名不存在
//                    Toast.makeText(LoginActivity.this, "用户名不存在!", Toast.LENGTH_LONG).show();
//                }

            }

    }
