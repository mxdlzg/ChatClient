package controller;

import entity.Config;
import net.NetConnection;
import net.Register;
import ui.register.RegisterLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/22.
 */
public class RegisterControl {
    private RegisterLayout registerLayout;
    private String user;
    private String first_password;
    private String second_password;
    private String city;
    private boolean isMale;

    private NetConnection.onReceiveListener onReceiveListener;
    private SuccessCallback successCallback;
    private FailCallback failCallback;


    public RegisterControl(){
        init();
    }

    public RegisterControl(RegisterLayout registerLayout) {
        this.registerLayout = registerLayout;
        init();
    }

    private void init(){
        successCallback = new SuccessCallback() {
            @Override
            public void onSuccess(String token) {
                Config.token = token;
                System.out.println("token:"+token);
                registerLayout.dispose();
            }
        };
        failCallback = new FailCallback() {
            @Override
            public void onFail(int errorCode) {
                switch (errorCode){
                    case Config.ERROR_INVALID_USER_NAME:
                        JLabel label = registerLayout.getLbStatus();
                        label.setText("用户名已注册");
                        break;
                    case Config.ERROR_TIME_OUT:
                        JLabel labe = registerLayout.getLbStatus();
                        labe.setText("连接超时");
                        break;
                    default:
                        break;
                }
            }
        };
        onReceiveListener = new NetConnection.onReceiveListener() {
            @Override
            public void onReceive(String content) {
                System.out.println("register listener:"+content);
                String[] result = content.split(Config.SEPARATOR);
                if (result[0].equals(Config.REGISTER)){
                    if (result[1].equals(String.valueOf(Config.SUCCESS_REGISTER))){
                        if (successCallback != null){
                            successCallback.onSuccess(result[2]);
                        }
                    }else {
                        if (failCallback != null){
                            failCallback.onFail(Integer.parseInt(result[1]));
                        }
                    }
                }
            }
        };
    }

    public void register(){
        JCheckBox male = registerLayout.getCbMale();
        JCheckBox female = registerLayout.getCbFemale();
        user = registerLayout.getEdtUserName().getText();
        first_password = registerLayout.getEdtFirstPassword().getText();
        second_password = registerLayout.getEdtSecondPassword().getText();
        city = registerLayout.getEdtCity().getText();
        isMale = male.isSelected();
        if (checkInfo()){
            System.out.println("do register");
            new Register(user,first_password,second_password,city,isMale,onReceiveListener);
        }
    }

    private boolean checkInfo(){
        JCheckBox male = registerLayout.getCbMale();
        JCheckBox female = registerLayout.getCbFemale();
        user = registerLayout.getEdtUserName().getText();
        first_password = registerLayout.getEdtFirstPassword().getText();
        second_password = registerLayout.getEdtSecondPassword().getText();
        city = registerLayout.getEdtCity().getText();
        if (user.isEmpty()){
            registerLayout.getLbUser().setText("用户名(不能为空)");
            registerLayout.getLbUser().setForeground(Color.red);
            return false;
        }
        if (first_password.isEmpty()){
            registerLayout.getLbFirstPassword().setText("密码(不能为空)");
            registerLayout.getLbFirstPassword().setForeground(Color.red);
            return false;
        }
        if (second_password.isEmpty()){
            registerLayout.getLbSecondPassword().setText("确认密码(不能为空)");
            registerLayout.getLbSecondPassword().setForeground(Color.red);
            return false;
        }
        if (!male.isSelected() && !female.isSelected()){
            registerLayout.getLbSex().setText("性别(不能为空)");
            registerLayout.getLbSex().setForeground(Color.red);
            return false;
        }
        if (!first_password.equals(second_password)){
            registerLayout.getLbSecondPassword().setText("两次密码不同");
            registerLayout.getLbSecondPassword().setForeground(Color.red);
            return false;
        }
        return true;
//        if (city)
    }

    public void setRegisterLayout(RegisterLayout registerLayout) {
        this.registerLayout = registerLayout;
    }

    /**
     * 注册成功回调
     */
    public interface SuccessCallback{
        void onSuccess(String token);
    }

    /**
     * 注册失败回调
     */
    public interface FailCallback{
        void onFail(int errorCode);
    }
}
