package net;

import entity.Config;
import util.MessageFormat;

/**
 * Created by 廷江 on 2017/6/22.
 */
public class Register {
    public Register(String user,String first,String second,String city,boolean isMale,NetConnection.onReceiveListener listener){
        String message = MessageFormat.formatMessage(Config.NET_REGISTER,user,first,second,city,String.valueOf(isMale));
        NetConnection.getNetConnection().send(message);
        NetConnection.getNetConnection().setReceiveListener(listener);
    }
}
