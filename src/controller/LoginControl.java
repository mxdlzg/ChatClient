package controller;

import entity.Config;
import net.Login;
import net.NetConnection;
import ui.chat.ChatLayout;
import ui.login.LoginLayout;
import ui.register.RegisterLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class LoginControl {
    private LoginLayout loginLayout;
    private String user;
    private String password;

    private SuccessCallback successCallback;
    private FailCallback failCallback;
    private NetConnection.onReceiveListener loginReceiveListener;

    /**
     * 构造
     */
    public LoginControl(){
        init();
    }

    /**
     * 构造
     * @param loginLayout 当前操作的界面
     */
    public LoginControl(LoginLayout loginLayout) {
        this.loginLayout = loginLayout;
        init();
    }

    /**
     * 初始化配置信息，socket连接信息
     * // TODO: 2017/6/21 当服务器未响应或者无法连接的时候，处理对应情况
     */
    private void init(){
        if (Boolean.parseBoolean(Config.getProperties("storeAccount","false"))){
            loginLayout.getCkStore().setSelected(true);
            loginLayout.getEdtUserName().setText(Config.user);
            loginLayout.getEdtPassword().setText(Config.password);
        }

        NetConnection.getNetConnection().connect();
        loginReceiveListener = new NetConnection.onReceiveListener() {
            @Override
            public void onReceive(String content) {
                System.out.println("login listener:"+content);
                String[] result = content.split(Config.SEPARATOR);
                if (result[0].equals(Config.LOGIN)){
                    if (result[1].equals(String.valueOf(Config.SUCCESS_LOGIN))){
                        if (successCallback!=null){
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
        successCallback = new SuccessCallback() {
            @Override
            public void onSuccess(String token) {
                Config.token = token;
                Config.user = loginLayout.getEdtUserName().getText();
                loginLayout.setVisible(false);
                ChatLayout chatLayout = new ChatLayout();
            }
        };
        failCallback = new FailCallback() {
            @Override
            public void onFail(int errorCode) {
                JLabel label = loginLayout.getLbStatus();
                switch (errorCode){
                    case Config.ERROR_NO_SUCH_USER:
                        label.setText(Config.STRING_NO_SUCH_USER);
                        label.setForeground(Color.red);
                        break;
                    case Config.ERROR_PASSWORD_INCORRECT:
                        label.setText(Config.STRING_PASSWORD_INCORRECT);
                        label.setForeground(Color.red);
                        break;
                    case Config.ERROR_TIME_OUT:
                        label.setText(Config.STRING_TIME_OUT);
                        label.setForeground(Color.red);
                        break;
                    default:
                        break;
                }
            }
        };
    }

    /**
     * 关闭窗口，同时保存配置信息
     */
    public void systemExit(){
        Config.storeProperties();
        NetConnection.getNetConnection().close();
        System.exit(0);
    }

    /**
     * 登录按钮的功能，展示接受检查参数的任务
     */
    public void login(){
        String user = loginLayout.getEdtUserName().getText();
        char[] password = loginLayout.getEdtPassword().getPassword();
        if (user.isEmpty()){
            loginLayout.getLbUser().setText("用户名(不能为空)");
            loginLayout.getLbUser().setForeground(Color.red);
        }else if (password.length == 0){
            loginLayout.getLbPassword().setText("密码(不能为空)");
            loginLayout.getLbPassword().setForeground(Color.red);
        }else {
            new Login(user,String.valueOf(password),loginReceiveListener);
        }
    }

    /**
     * 跳转登录界面
     */
    public void register(){
        RegisterLayout registerLayout = new RegisterLayout();
    }

    /**
     * @return 检查登录信息是否完整
     */
    public boolean checkInfo(){
        return true;
    }

    /**
     * @param loginLayout 当前操作的登录界面
     */
    public void setLoginLayout(LoginLayout loginLayout) {
        this.loginLayout = loginLayout;
    }

    /**
     * 记住密码
     */
    public void storePassword(){
        JCheckBox checkBox = loginLayout.getCkStore();
        if (checkBox.isSelected()){
            Config.addProperties("storeAccount",String.valueOf(true));
            Config.addProperties("user",loginLayout.getEdtUserName().getText());
            Config.addProperties("password",loginLayout.getEdtPassword().getText());
        }else {
            System.out.println("取消保存");
            Config.addProperties("storeAccount",String.valueOf(false));
        }
    }


    /**
     * 登录成功回调
     */
    public interface SuccessCallback{
        void onSuccess(String token);
    }

    /**
     * 登录失败回调
     */
    public interface FailCallback{
        void onFail(int errorCode);
    }
}
