package entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class Config {
    public static final String SEPARATOR = "&_&";
    public static final String CHAR_SET = "utf-8";

    public static final String CLOSE_SOCKET = "close_socket";
    public static final String NET_LOGIN = "net_login";
    public static final String NET_REGISTER = "net_register";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    public static final String USER_CHANGE = "user_change";


    //string status
    public static final String USER_IN = "300";
    public static final String USER_OUT = "301";

    //action
    public static final String GET_LIST = "get_list";
    public static final String GET_MESSAGE = "get_message";
    public static final String NET_SEND = "net_send";

    //success
    public static final int SUCCESS_GET_LIST = 3;
    public static final int SUCCESS_LOGIN = 2;
    public static final int SUCCESS_REGISTER = 1;

    public static final int USER_STATUS_ONLINE = 200;
    public static final int USER_STATUS_NEW_REGISTER = 201;
    public static final int USER_STATUS_OFFLINE = 202;

    //errorcode
    public static final int ERROR_TIME_OUT = 99;
    public static final int ERROR_PASSWORD_INCORRECT = 100;
    public static final int ERROR_NO_SUCH_USER = 101;
    public static final int ERROR_INVALID_USER_NAME = 102;

    //error string
    public static final String STRING_NO_SUCH_USER = "无此用户";
    public static final String STRING_PASSWORD_INCORRECT = "密码错误";
    public static final String STRING_TIME_OUT = "连接超时";

    //properties 加载配置
    private static Properties properties;
    private static void setProperties(){
        if (properties == null){
            properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try {
                System.out.println(loader.getResourceAsStream("application.properties"));
                properties.load(loader.getResourceAsStream("application.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void addProperties(String key,String value){
        if (properties == null){
            setProperties();
        }
        properties.setProperty(key,value);
    }
    public static String getProperties(String key,String dft){
        if (properties == null){
            setProperties();
        }
        return properties.getProperty(key,dft);
    }
    public static void storeProperties(){
        try {
            File file = new File("src/application.properties");
            Writer writer = new FileWriter(file);
            properties.store(writer,"comments");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //运行期间变量
    public static String user = getProperties("user","");
    public static String password = getProperties("password","");
    public static String token;
    public static boolean storeAccount = Boolean.valueOf(getProperties("storeAccount","false"));

}
