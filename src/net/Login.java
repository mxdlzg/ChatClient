package net;

import entity.Config;
import util.MessageFormat;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class Login {
    public Login(String user,String password,NetConnection.onReceiveListener listener){
        String message = MessageFormat.formatMessage(Config.NET_LOGIN,user,password);
        NetConnection.getNetConnection().send(message);
        NetConnection.getNetConnection().setReceiveListener(listener);
    }
}
