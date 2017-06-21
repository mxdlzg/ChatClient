package entity;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class LocalManager {


    public static void writeAccount(String user,String password){
        try {
            FileOutputStream outputStream = new FileOutputStream("account.ccs");
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            dataOutputStream.writeChars(user);
//            dataOutputStream.writeChars("\n");
//            dataOutputStream.writeChars(password);
            outputStream.write(user.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write(password.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readAccount(){
        String account = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("account.ccs"));
            account = reader.readLine();
            account += "\n";
            account += reader.readLine();
            reader.close();
            return account;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }
}
