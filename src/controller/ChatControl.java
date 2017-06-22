package controller;

import entity.Config;
import entity.Person;
import net.NetConnection;
import ui.chat.ChatLayout;
import ui.custom.ChatItem;
import ui.custom.ChatScrollPane;
import ui.custom.UserPanel;
import util.MessageFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 廷江 on 2017/6/22.
 */
public class ChatControl {
    private ChatLayout chatLayout;
    private NetConnection.onReceiveListener onReceiveListener;
    private RefreshSuccessCallback refreshSuccessCallback;
    private MessageReceiveCallback messageReceiveCallback;
    private UserChangeCallback userChangeCallback;

    private JTextArea sendContentArea;
    private JTabbedPane mainTab;
    private JPanel talkListPanel;
    private JScrollPane talkScrollPane;

    private String currentUser;

    private int tabIndex;
    private int selectedIndex = 0;

    private List<Person> personList = new ArrayList<>();

    public ChatControl(ChatLayout chatLayout) {
        this.chatLayout = chatLayout;
        initComponents();
        init();
        NetConnection.getNetConnection().setReceiveListener(onReceiveListener);
    }

    /**
     * 初始化
     */
    private void init(){
        userChangeCallback = new UserChangeCallback() {
            @Override
            public void onChange(String list) {
                String[] result = list.split(Config.SEPARATOR);
                switch (result[1]){
                    case Config.USER_IN:
                        talkListPanel = chatLayout.getTalkListPanel();
                        talkListPanel.setPreferredSize(new Dimension((int) talkListPanel.getPreferredSize().getWidth(),(int) talkListPanel.getPreferredSize().getHeight()+75));
                        UserPanel user = new UserPanel();
                        user.setIndex(personList.size());
                        user.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                selectPerson(user.getIndex());
                            }
                        });
                        user.setText(result[2]);
                        talkListPanel.add(user);
                        personList.add(new Person(result[2], personList.size()));
                        selectPerson(personList.size()-1);
                        break;
                    case Config.USER_OUT:
                        for (Person person : personList){
                            if (person.getUser().equals(result[2])){
                                removePerson(person.getIndex());
                                break;
                            }
                        }
                        break;
                    default:break;
                }
            }
        };
        refreshSuccessCallback = new RefreshSuccessCallback() {
            @Override
            public void onRefresh(String list) {
                // TODO: 2017/6/22 解析完整的返回信息
                String[] result = list.split("&");
                personList.clear();
                talkListPanel = chatLayout.getTalkListPanel();
                talkListPanel.removeAll();
                talkListPanel.setPreferredSize(new Dimension((int) talkListPanel.getPreferredSize().getWidth(),75*result.length));
                for (String aResult : result) {
                    UserPanel user = new UserPanel();
                    user.setIndex(personList.size());
                    user.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            selectPerson(user.getIndex());
                        }
                    });
                    user.setText(aResult);
                    talkListPanel.add(user);
                    personList.add(new Person(aResult, personList.size()));
                    selectPerson(personList.get(0).getIndex());
                }
            }
        };
        messageReceiveCallback = new MessageReceiveCallback() {
            @Override
            public void onReceive(String list) {
                String[] result = list.split(Config.SEPARATOR);
                for (Person person:personList){
                    if (person.getUser().equals(result[1])){
                        selectPerson(person.getIndex());
                        updateUI(result[3],false,person.getIndex());
                        break;
                    }
                }
                // TODO: 2017/6/22 将收到的消息分发给对应的tab
            }
        };
        onReceiveListener = new NetConnection.onReceiveListener() {
            @Override
            public void onReceive(String content) {
                //result[0] 是消息flag
                //result[1] 是消息状态
                //result[2] 是消息主体（可以并需要继续解析）
                String[] result = content.split(Config.SEPARATOR);
                switch (result[0]){
                    case Config.GET_LIST:
                        if (refreshSuccessCallback!=null){
                            refreshSuccessCallback.onRefresh(result[2]);    //传递消息内容
                        }
                        break;
                    case Config.GET_MESSAGE:
                        if (messageReceiveCallback != null){
                            messageReceiveCallback.onReceive(content);  //消息分发需要from和to ，所以这里传递整体消息
                        }
                        break;
                    case Config.USER_CHANGE:
                        if (userChangeCallback != null){
                            userChangeCallback.onChange(content);
                        }
                    default:break;
                }
                // TODO: 2017/6/22 消息对象分发，同时多个对象向本机发送的情况下， 分发不同来源的消息到对应的tab中
            }
        };
        // TODO: 2017/6/22 启动的时候刷新在线列表
        refreshChatList();
    }

    /**
     * 初始化一些控件引用
     */
    private void initComponents(){
        talkListPanel = chatLayout.getTalkListPanel();
        sendContentArea = chatLayout.getEdtTextArea();
        mainTab = chatLayout.getMainTab();
    }

    /**
     * 发送信息
     */
    public void send(){
        //需要 当前user
        try {
            if (mainTab.getSelectedIndex() == selectedIndex){
                chatTo();
                chatLayout.getLbTitle().setText(Config.user+"");
            }else {
                chatLayout.getLbTitle().setText(Config.user+"---不能发送空消息");
            }
        } catch (Exception e) {
            chatLayout.getLbTitle().setText(Config.user+"---不能发送空消息");
            e.printStackTrace();
        }
    }

    /**
     * 是否已经有此tab
     * @param index tab标识
     * @return 是否已经加载此tab
     */
    public boolean hasTab(int index){
        return mainTab.indexOfTab(String.valueOf(index)) >= 0;
    }

    /**
     * 选择对话者之后，如果没有被添加tab，需要添加tab
     */
    public void addCurrentTab(int index){
//        System.out.println("add");
        ChatScrollPane chatScrollPane = new ChatScrollPane();
        chatScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(3,0));
        chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ChatItem chatItem = new ChatItem();
        chatItem.setContent(String.valueOf("测试测试"+index));
        chatScrollPane.addItem(chatItem);
        mainTab.addTab(String.valueOf(index),chatScrollPane);
    }

    /**
     * 打开user对应的tab页
     * @param index tab页的标识
     */
    public void openCurrentTab(int index){
        System.out.println("open");
        mainTab.setSelectedIndex(index);
    }

    /**
     * 选择当前对话的对象
     * @param index 在list中的位置
     */
    public void selectPerson(int index){
        talkListPanel.getComponent(selectedIndex).setBackground(Color.WHITE);
        talkListPanel.getComponent(index).setBackground(Color.gray);
        selectedIndex = index;
        System.out.println("select:"+index);
        mainTab = chatLayout.getMainTab();
        if (!hasTab(index)){
            addCurrentTab(index);
            openCurrentTab(index);
        }else {
            openCurrentTab(index);
        }
    }

    /**
     * 移除一个对话者
     * @param index 在list中的位置
     */
    public void removePerson(int index){
        int count = talkListPanel.getComponentCount();
        for (int i= 0; i < count; i++){
            if (((UserPanel)talkListPanel.getComponent(i)).getIndex() == index){
                talkListPanel.remove(i);
                personList.remove(i);
                break;
            }
        }
//        System.out.println("index:"+index);
        talkListPanel.revalidate();
        talkListPanel.repaint();
//        System.out.println(personList.size());
    }

    /**
     * 添加一个对话者
     */
    public void addPerson(){

    }

    /**
     * 向单一人对话
     */
    public void chatTo(){
        if (!chatLayout.getEdtTextArea().getText().isEmpty()){
            String content = chatLayout.getEdtTextArea().getText();
            System.out.println("chat send:"+content);
            for (Person person:personList){
                if (person.getIndex() == selectedIndex){
                    String message = MessageFormat.formatMessage(Config.NET_SEND,Config.user,person.getUser(),content);
                    NetConnection.getNetConnection().send(message);
                    updateUI(content,true,person.getIndex());
                    break;
                }
            }
        }
    }

    /**
     * 向一组人说话
     */
    public void chatToAll(){

    }

    /**
     * 更新对话框中的对话信息
     * @param content message内容
     * @param isSend 是否是发送
     * @param index 对话者标识
     */
    private void updateUI(String content,boolean isSend,int index){
        mainTab.setSelectedIndex(index);
        ChatItem chatItem = new ChatItem();
        chatItem.setContent(content);
        if (isSend){
            chatItem.setRightToLeft(true);
        }
        ChatScrollPane csp = (ChatScrollPane) mainTab.getComponent(index);
        csp.getVerticalScrollBar().setValue((int) csp.getVerticalScrollBar().getMaximumSize().getHeight());
        csp.addItem(chatItem);
        csp.revalidate();
        csp.repaint();
    }

    /**
     * 从服务器获取当前登录的用户列表并显示
     */
    public void refreshChatList(){
        NetConnection.getNetConnection().send("get_list&_&"+Config.user);
    }

    /**
     * 关闭窗口，同时保存配置信息
     */
    public void systemExit(){
        Config.storeProperties();
        NetConnection.getNetConnection().close();
        System.exit(0);
    }

    public void setChatLayout(ChatLayout chatLayout) {
        this.chatLayout = chatLayout;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    public String getCurrentUser() {
        return currentUser;
    }

    public interface RefreshSuccessCallback{
        void onRefresh(String list);
    }
    public interface MessageReceiveCallback{
        void onReceive(String list);
    }
    public interface UserChangeCallback{
        void onChange(String list);
    }
}
