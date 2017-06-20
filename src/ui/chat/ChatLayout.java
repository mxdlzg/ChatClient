/*
 * Created by JFormDesigner on Tue Jun 20 13:01:40 CST 2017
 */

package ui.chat;

import org.jdesktop.swingx.border.DropShadowBorder;
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        chatPanel = new JPanel();
        btnFormClose = new JButton();
        userPanel = new JPanel();
        edtSearch = new JTextField();
        pclbSearch = new PictureLabel();
        talkScrollPane = new JScrollPane();
        talkListPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainPanel ========
        {
            mainPanel.setBackground(Color.white);
            mainPanel.setLayout(null);

            //======== chatPanel ========
            {
                chatPanel.setLayout(null);

                //---- btnFormClose ----
                btnFormClose.setBorder(null);
                btnFormClose.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\Window\\window_close_normal_white.png"));
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
                chatPanel.add(btnFormClose);
                btnFormClose.setBounds(750, 0, 50, 50);

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
            chatPanel.setBounds(225, 0, 800, 648);

            //======== userPanel ========
            {
                userPanel.setBackground(Color.white);
                userPanel.setBorder(null);
                userPanel.setLayout(null);

                //---- edtSearch ----
                edtSearch.setBorder(null);
                edtSearch.setText("Search");
                edtSearch.setForeground(Color.gray);
                edtSearch.setBackground(new Color(249, 249, 249));
                edtSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                userPanel.add(edtSearch);
                edtSearch.setBounds(45, 0, 180, 40);

                //---- pclbSearch ----
                pclbSearch.setText("text");
                userPanel.add(pclbSearch);
                pclbSearch.setBounds(0, 0, 40, 40);

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
                talkScrollPane.setBounds(0, 40, 225, 610);

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
            userPanel.setBounds(0, 0, 225, 648);

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
    private JButton btnFormClose;
    private JPanel userPanel;
    private JTextField edtSearch;
    private PictureLabel pclbSearch;
    private JScrollPane talkScrollPane;
    private JPanel talkListPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        ChatLayout chatLayout = new ChatLayout();
    }
}
