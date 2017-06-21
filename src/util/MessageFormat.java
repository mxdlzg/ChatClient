package util;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class MessageFormat {

    /**
     * @param info 发送的消息内容
     * @return 格式化的消息
     */
    public static String formatMessage(String...info){
        String result = "";
        for (int i = 0;i<info.length;i++){
            result+=info[i];
            result+="&_&";
        }
        return result.substring(0,result.length()-3);
    }


}
