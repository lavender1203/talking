package com.example.lavender.mychat.data;

import android.content.Context;

import org.jivesoftware.smack.XMPPConnection;

/**
 * Created by lavender on 15-11-25.
 */
public class DataWareHouse {
    public static GlobalData getGlobalData(Context ctx){
        return (GlobalData)ctx.getApplicationContext();
    }

    public static XMPPConnection getXMPPConnection(Context ctx){
        return getGlobalData(ctx).xmppConnection;
    }

    public static void setXMPPConnection(Context ctx, XMPPConnection conn){
        getGlobalData(ctx).xmppConnection = conn;
    }
}
