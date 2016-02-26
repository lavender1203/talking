package com.example.lavender.mychat.data;

import android.app.Application;

import org.jivesoftware.smack.XMPPConnection;

/**
 * Created by lavender on 15-11-25.
 */
public class GlobalData extends Application{
    public XMPPConnection xmppConnection;
    public LoginData loginData = new LoginData();
}
