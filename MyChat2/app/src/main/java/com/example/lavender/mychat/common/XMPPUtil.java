package com.example.lavender.mychat.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

import javax.net.SocketFactory;

/**
 * Created by lavender on 15-11-25.
 */
public class XMPPUtil {
    public static XMPPConnection getXMPPConnection(String server, int port){
        try{
            ConnectionConfiguration config = new ConnectionConfiguration(server,port);
            config.setReconnectionAllowed(true);
            config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            config.setSendPresence(true);
//            config.setDebuggerEnabled(true);
            SASLAuthentication.supportSASLMechanism("PLAIN", 0);
//            config.setSocketFactory(new DummySocketFactory());
            XMPPConnection connection = new XMPPTCPConnection(config,null);
            connection.connect();
            return connection;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static XMPPConnection getXMPPConnection(String server){
        return getXMPPConnection(server, 5222);
    }
}
