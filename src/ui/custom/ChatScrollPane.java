package ui.custom;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/20.
 */
public class ChatScrollPane extends JScrollPane {
    private JPanel chatPanel;
    private int scrollHeight = 475;

    public ChatScrollPane(){
        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel,BoxLayout.Y_AXIS));
        chatPanel.setPreferredSize(new Dimension(790,scrollHeight));
        chatPanel.setBackground(Color.WHITE);
        this.add(chatPanel);
        this.setViewportView(chatPanel);
        this.getVerticalScrollBar().setUnitIncrement(10);
    }

    /**
     * 向列表添加一条对话信息
     * @param item ChatItem 一条对话信息
     */
    public void addItem(ChatItem item){
        chatPanel.add(item);
        Dimension dimension = new Dimension(790, (int) (scrollHeight+item.getMaximumSize().getHeight()));
        chatPanel.setPreferredSize(dimension);
        System.out.println("chatlayout"+chatPanel.getPreferredSize());
    }

    public JPanel getChatPanel() {
        return chatPanel;
    }

    public void setChatPanel(JPanel chatPanel) {
        this.chatPanel = chatPanel;
    }


}
