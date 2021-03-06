/*
 * Created by JFormDesigner on Tue Jun 20 13:01:40 CST 2017
 */

package ui.chat;

import controller.ChatControl;
import entity.Config;
import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.ChatScrollPane;
import ui.custom.PictureLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class ChatLayout extends JFrame{
    private ChatControl chatControl;
    private int oldX;
    private int oldY;

    public ChatLayout() {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFee");
//            SwingUtilities.updateComponentTreeUI(this);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        chatControl = new ChatControl(this);
        this.setUndecorated(true);
        initComponents();
        initForm();
        initComponentsSetting();
        initEvent();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        lbTitle.setText(Config.user);
        System.out.println(Thread.currentThread().getName()+"窗体");
    }

    private void initEvent(){
        btnFormClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chatControl.systemExit();
            }
        });

        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chatControl.send();
            }
        });
    }

     /**
     * 调整一些控件的设置
     */
    private void initComponentsSetting(){
        mainPanel.setSize(1050,640);
        mainPanel.setBounds(0,0,1200,640);

        ImageIcon imageIcon = new ImageIcon("resources/btn_send.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        btnSend.setIcon(imageIcon);

        talkScrollPane.setViewportView(talkListPanel);
        talkScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(1,0));
        talkScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        talkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ChatScrollPane chatScrollPane = new ChatScrollPane();
        chatScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(1,0));
        chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        chatScrollPane.setBackground(Color.WHITE);

        mainTab.setLayout(new BorderLayout());
//        mainTab.addTab("chat1",null,chatScrollPane);

//        lbTitle.setText(Config.user);
    }

    /**
     * 重绘窗体
     */
    public void initForm(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int onScreenX = e.getXOnScreen();
                int onScreenY = e.getYOnScreen();
                ChatLayout.this.setLocation(onScreenX-oldX,onScreenY-oldY);
            }
        });
        DropShadowBorder dropShadowBorder = new DropShadowBorder();
        dropShadowBorder.setShadowColor(Color.BLACK);
        dropShadowBorder.setShowLeftShadow(true);
        dropShadowBorder.setShowRightShadow(true);
        dropShadowBorder.setShowTopShadow(true);
        dropShadowBorder.setShowBottomShadow(true);
        mainPanel.setBorder(dropShadowBorder);

    }

    public JTextArea getEdtTextArea() {
        return edtTextArea;
    }

    public JTabbedPane getMainTab() {
        return mainTab;
    }

    public JPanel getTalkListPanel() {
        return talkListPanel;
    }

    public JScrollPane getTalkScrollPane() {
        return talkScrollPane;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        chatPanel = new JPanel();
        mainTab = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        edtTextArea = new JTextArea();
        btnSend = new JButton();
        userPanel = new JPanel();
        talkScrollPane = new JScrollPane();
        talkListPanel = new JPanel();
        statusPanel = new JPanel();
        btnFormClose = new JButton();
        edtSearch = new JTextField();
        pictureLabel1 = new PictureLabel();
        lbTitle = new JLabel();
        posPanel = new JPanel();

        //======== this ========
        setBackground(new Color(0, 0, 0, 0));
        setForeground(Color.black);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainPanel ========
        {
            mainPanel.setBackground(Color.white);
            mainPanel.setOpaque(false);
            mainPanel.setMaximumSize(new Dimension(1015, 640));
            mainPanel.setLayout(null);

            //======== chatPanel ========
            {
                chatPanel.setBackground(Color.white);
                chatPanel.setLayout(null);
                chatPanel.add(mainTab);
                mainTab.setBounds(0, 0, 790, 475);

                //======== scrollPane1 ========
                {
                    scrollPane1.setBorder(null);

                    //---- edtTextArea ----
                    edtTextArea.setBorder(null);
                    edtTextArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 17));
                    scrollPane1.setViewportView(edtTextArea);
                }
                chatPanel.add(scrollPane1);
                scrollPane1.setBounds(0, 475, 735, 120);

                //---- btnSend ----
                btnSend.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\btn_send.png"));
                btnSend.setBorderPainted(false);
                btnSend.setOpaque(false);
                btnSend.setContentAreaFilled(false);
                btnSend.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\btn_send_hover.png"));
                btnSend.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\btn_send_selected.png"));
                chatPanel.add(btnSend);
                btnSend.setBounds(735, 515, 50, 50);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < chatPanel.getComponentCount(); i++) {
                        Rectangle bounds = chatPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = chatPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    chatPanel.setMinimumSize(preferredSize);
                    chatPanel.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(chatPanel);
            chatPanel.setBounds(230, 45, 790, 595);

            //======== userPanel ========
            {
                userPanel.setBackground(Color.white);
                userPanel.setBorder(null);
                userPanel.setMinimumSize(new Dimension(225, 600));
                userPanel.setMaximumSize(new Dimension(32767, 600));
                userPanel.setLayout(null);

                //======== talkScrollPane ========
                {
                    talkScrollPane.setBorder(new DropShadowBorder());
                    talkScrollPane.setViewportBorder(null);
                    talkScrollPane.setPreferredSize(new Dimension(230, 1000));

                    //======== talkListPanel ========
                    {
                        talkListPanel.setBorder(null);
                        talkListPanel.setPreferredSize(new Dimension(225, 1000));
                        talkListPanel.setLayout(new BoxLayout(talkListPanel, BoxLayout.Y_AXIS));
                    }
                    talkScrollPane.setViewportView(talkListPanel);
                }
                userPanel.add(talkScrollPane);
                talkScrollPane.setBounds(0, 0, 225, 600);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < userPanel.getComponentCount(); i++) {
                        Rectangle bounds = userPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = userPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    userPanel.setMinimumSize(preferredSize);
                    userPanel.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(userPanel);
            userPanel.setBounds(5, 45, 225, 595);

            //======== statusPanel ========
            {
                statusPanel.setPreferredSize(new Dimension(300, 50));
                statusPanel.setBackground(Color.white);
                statusPanel.setLayout(null);

                //---- btnFormClose ----
                btnFormClose.setBorder(null);
                btnFormClose.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\Window\\window_close_normal.png"));
                btnFormClose.setMargin(new Insets(0, 0, 0, 0));
                btnFormClose.setFocusPainted(false);
                btnFormClose.setBorderPainted(false);
                btnFormClose.setSelectedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\Window\\window_close_hover.png"));
                btnFormClose.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\Window\\window_close_down.png"));
                btnFormClose.setRolloverEnabled(false);
                btnFormClose.setRequestFocusEnabled(false);
                btnFormClose.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\Window\\window_close_hover.png"));
                btnFormClose.setOpaque(false);
                btnFormClose.setContentAreaFilled(false);
                statusPanel.add(btnFormClose);
                btnFormClose.setBounds(960, -5, 65, 50);

                //---- edtSearch ----
                edtSearch.setBorder(null);
                edtSearch.setText("Search");
                edtSearch.setForeground(Color.gray);
                edtSearch.setBackground(new Color(249, 249, 249));
                edtSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                statusPanel.add(edtSearch);
                edtSearch.setBounds(50, 5, 180, 30);

                //---- pictureLabel1 ----
                pictureLabel1.setHeight(25);
                pictureLabel1.setWidth(25);
                pictureLabel1.setUrl("resources/ic_search_black_24dp.png");
                pictureLabel1.setLabelFor(edtSearch);
                statusPanel.add(pictureLabel1);
                pictureLabel1.setBounds(15, 10, 30, 30);

                //---- lbTitle ----
                lbTitle.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
                statusPanel.add(lbTitle);
                lbTitle.setBounds(380, 5, 555, 30);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < statusPanel.getComponentCount(); i++) {
                        Rectangle bounds = statusPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = statusPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    statusPanel.setMinimumSize(preferredSize);
                    statusPanel.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(statusPanel);
            statusPanel.setBounds(5, 5, 1015, 40);

            //======== posPanel ========
            {
                posPanel.setOpaque(false);
                posPanel.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < posPanel.getComponentCount(); i++) {
                        Rectangle bounds = posPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = posPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    posPanel.setMinimumSize(preferredSize);
                    posPanel.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(posPanel);
            posPanel.setBounds(1005, 620, 20, 25);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < mainPanel.getComponentCount(); i++) {
                    Rectangle bounds = mainPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = mainPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                mainPanel.setMinimumSize(preferredSize);
                mainPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainPanel;
    private JPanel chatPanel;
    private JTabbedPane mainTab;
    private JScrollPane scrollPane1;
    private JTextArea edtTextArea;
    private JButton btnSend;
    private JPanel userPanel;
    private JScrollPane talkScrollPane;
    private JPanel talkListPanel;
    private JPanel statusPanel;
    private JButton btnFormClose;
    private JTextField edtSearch;
    private PictureLabel pictureLabel1;
    private JLabel lbTitle;
    private JPanel posPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        ChatLayout chatLayout = new ChatLayout();
    }
}
