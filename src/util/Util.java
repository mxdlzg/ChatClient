package util;

/**
 * Created by 廷江 on 2017/6/22.
 */
public class Util {
    public static int countblank(String s){
        int i = 0 ;
        int count = 0;
        while(i < s.length()){
            if(s.charAt(i) == '\n')
                count++;
            i++;
        }
        return count+1;
    }
}
