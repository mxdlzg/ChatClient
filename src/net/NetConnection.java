package net;

import entity.Config;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class NetConnection {
    private Socket socket;
    private SocketAddress socketAddress;
    private BufferedReader reader;
    private PrintWriter writer;

    private onReceiveListener receiveListener;

    public static String localIP = "127.0.0.1";
    public static String serverIP = "139.129.50.179";
    public static int port = 12345;

    private NetConnection(){}
    private static final NetConnection instance = new NetConnection();
    public static NetConnection getNetConnection(){
        return instance;
    }

    /**
     * 开启socket连接，连接到服务器
     */
    public void connect(){
        new Thread(){
            @Override
            public void run() {
                try {
                    socket = new Socket(localIP,port);
                    System.out.println("socket connect");
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                    String line;
                    System.out.println(Thread.currentThread().getName()+"net层");
                    while ((line = reader.readLine()) != null){
                        if (receiveListener != null){
                            receiveListener.onReceive(line);
                        }
                    }
                    System.out.println("socket close");
                    writer.close();
                    reader.close();
                    writer = null;
                    reader = null;
                } catch (IOException e) {
                    // TODO: 2017/6/21 提示连接失败
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 关闭当前的socket连接
     */
    public void close(){
        try {
            send(Config.CLOSE_SOCKET);
            if (socket != null){
                socket.close();
                writer.close();
                reader.close();
            }
            System.out.println("socket close");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param content 格式化的消息
     */
    public void send(String content){
        if (socket != null){
            try {
                socket.getOutputStream().write((content+"\n").getBytes("gbk"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param content 接收到的消息信息
     */
    public void receive(String content){
        if (receiveListener != null){
            receiveListener.onReceive(content);
        }
    }

    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public onReceiveListener getReceiveListener() {
        return receiveListener;
    }

    public void setReceiveListener(onReceiveListener receiveListener) {
        this.receiveListener = receiveListener;
    }

    /**
     * 接受接收到消息回调
     */
    public interface onReceiveListener{
        void onReceive(String content);
    }
}
