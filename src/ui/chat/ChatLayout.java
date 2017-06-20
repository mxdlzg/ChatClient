/*
 * Created by JFormDesigner on Tue Jun 20 13:01:40 CST 2017
 */

package ui.chat;

import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.*;
import ui.custom.PictureLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class ChatLayout extends JFrame {
    private int oldX;
    private int oldY;

    public ChatLayout() {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFee");
//            SwingUtilities.updateComponentTreeUI(this);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        this.setUndecorated(true);
        initComponents();
        initForm();
        initComponentsSetting();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

     /**
     * 调整一些控件的设置
     */
    private void initComponentsSetting(){
        mainPanel.setSize(1050,640);
        mainPanel.setBounds(0,0,1200,640);

        talkScrollPane.setViewportView(talkListPanel);
        talkScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        talkScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        talkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        chatPanel = new JPanel();
        mainTab = new JTabbedPane();
        chatItem1 = new ChatItem();
        panel1 = new JPanel();
        pictureLabel2 = new PictureLabel();
        textArea1 = new JTextArea();
        userPanel = new JPanel();
        talkScrollPane = new JScrollPane();
        talkListPanel = new JPanel();
        statusPanel = new JPanel();
        btnFormClose = new JButton();
        edtSearch = new JTextField();
        pictureLabel1 = new PictureLabel();
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
                chatPanel.setLayout(null);
                chatPanel.add(mainTab);
                mainTab.setBounds(0, -10, 790, 230);

                //---- chatItem1 ----
                chatItem1.setAreaHeight(200);
                chatItem1.setAreaWidth(300);
                chatItem1.setImgHeight(50);
                chatItem1.setImgWidth(50);
                chatItem1.setImgUrl("resources/loginBtn_normal.png");
                chatItem1.setContent("\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a\u554a");
                chatPanel.add(chatItem1);
                chatItem1.setBounds(0, 275, 790, 130);

                //======== panel1 ========
                {
                    panel1.setLayout(new BorderLayout());

                    //---- pictureLabel2 ----
                    pictureLabel2.setText("text");
                    panel1.add(pictureLabel2, BorderLayout.WEST);
                    panel1.add(textArea1, BorderLayout.CENTER);
                }
                chatPanel.add(panel1);
                panel1.setBounds(155, 450, 425, 115);

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

                    //======== talkListPanel ========
                    {
                        talkListPanel.setBorder(null);
                        talkListPanel.setLayout(null);

                        { // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < talkListPanel.getComponentCount(); i++) {
                                Rectangle bounds = talkListPanel.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = talkListPanel.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            talkListPanel.setMinimumSize(preferredSize);
                            talkListPanel.setPreferredSize(preferredSize);
                        }
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
    private ChatItem chatItem1;
    private JPanel panel1;
    private PictureLabel pictureLabel2;
    private JTextArea textArea1;
    private JPanel userPanel;
    private JScrollPane talkScrollPane;
    private JPanel talkListPanel;
    private JPanel statusPanel;
    private JButton btnFormClose;
    private JTextField edtSearch;
    private PictureLabel pictureLabel1;
    private JPanel posPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        ChatLayout chatLayout = new ChatLayout();
    }
}
