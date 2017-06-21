/*
 * Created by JFormDesigner on Mon Jun 19 16:44:41 CST 2017
 */

package ui.register;

import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.PictureLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class RegisterLayout extends JDialog {
    private static final long serialVersionUID = 1L;
    private int oldX;
    private int oldY;

    /**
     * 调整top部分的图片宽度
     */
    private void resetPictureSize(){
//        registerPC.setBounds(0,0,390,300);
//        btnFormClose.setBounds(350,100,50,50);
    }

    /**
     * 添加阴影
     */
    private void rebuildShadow(){
        DropShadowBorder dropShadowBorder = new DropShadowBorder();
        dropShadowBorder.setShadowColor(Color.BLACK);
        dropShadowBorder.setShowLeftShadow(true);
        dropShadowBorder.setShowRightShadow(true);
        dropShadowBorder.setShowTopShadow(true);
        dropShadowBorder.setShowBottomShadow(true);
        mainPanel.setBorder(dropShadowBorder);
    }

    /**
     * 处理拖动
     */
    private void rebuildDragged(){
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
                RegisterLayout.this.setLocation(onScreenX-oldX,onScreenY-oldY);
            }
        });
    }


    public RegisterLayout() {
        this.setUndecorated(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setBounds(0,0,100,500);
        initComponents();
        resetPictureSize();
        rebuildShadow();
        rebuildDragged();
        initEvent();
        this.setModal(true);
        this.setSize(400,800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void initEvent(){
        btnFormClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterLayout.this.dispose();
            }
        });
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        layeredPane = new JLayeredPane();
        registerPC = new PictureLabel();
        btnFormClose = new JButton();
        infoPanel = new JPanel();
        infoBuildPanel = new JPanel();
        lbUser = new JLabel();
        lbLine1 = new JLabel();
        inputUserName = new JTextField();
        lbUser2 = new JLabel();
        lbLine2 = new JLabel();
        inputUserName2 = new JTextField();
        lbUser3 = new JLabel();
        lbLine3 = new JLabel();
        inputUserName3 = new JTextField();
        lbUser4 = new JLabel();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        lbUser5 = new JLabel();
        inputUserName4 = new JTextField();
        lbLine4 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setBackground(Color.white);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainPanel ========
        {
            mainPanel.setBackground(Color.white);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            //======== layeredPane ========
            {
                layeredPane.setMinimumSize(new Dimension(400, 300));
                layeredPane.setMaximumSize(new Dimension(400, 300));

                //---- registerPC ----
                registerPC.setText("text");
                registerPC.setHeight(300);
                registerPC.setWidth(500);
                registerPC.setImageIcon(null);
                registerPC.setUrl("resources/registerPC.jpg");
                registerPC.setBackground(Color.white);
                layeredPane.add(registerPC, JLayeredPane.DEFAULT_LAYER);
                registerPC.setBounds(new Rectangle(new Point(0, 0), registerPC.getPreferredSize()));

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
                layeredPane.add(btnFormClose, JLayeredPane.POPUP_LAYER);
                btnFormClose.setBounds(350, -10, 50, 50);
            }
            mainPanel.add(layeredPane);

            //======== infoPanel ========
            {
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

                //======== infoBuildPanel ========
                {
                    infoBuildPanel.setMaximumSize(new Dimension(400, 500));
                    infoBuildPanel.setBackground(Color.white);
                    infoBuildPanel.setBorder(null);
                    infoBuildPanel.setLayout(null);

                    //---- lbUser ----
                    lbUser.setText("\u7528\u6237\u540d");
                    lbUser.setPreferredSize(new Dimension(40, 20));
                    lbUser.setHorizontalAlignment(SwingConstants.CENTER);
                    lbUser.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser.setBackground(Color.white);
                    lbUser.setOpaque(true);
                    lbUser.setAlignmentX(200.0F);
                    lbUser.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser);
                    lbUser.setBounds(5, 15, 110, lbUser.getPreferredSize().height);

                    //---- lbLine1 ----
                    lbLine1.setText("__________________________________________");
                    lbLine1.setForeground(Color.gray);
                    infoBuildPanel.add(lbLine1);
                    lbLine1.setBounds(40, 55, 320, lbLine1.getPreferredSize().height);

                    //---- inputUserName ----
                    inputUserName.setBorder(null);
                    inputUserName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
                    infoBuildPanel.add(inputUserName);
                    inputUserName.setBounds(40, 40, 295, 25);

                    //---- lbUser2 ----
                    lbUser2.setText("\u5bc6\u7801");
                    lbUser2.setPreferredSize(new Dimension(40, 20));
                    lbUser2.setHorizontalAlignment(SwingConstants.CENTER);
                    lbUser2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser2.setBackground(Color.white);
                    lbUser2.setOpaque(true);
                    lbUser2.setAlignmentX(200.0F);
                    lbUser2.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser2);
                    lbUser2.setBounds(0, 90, 110, 20);

                    //---- lbLine2 ----
                    lbLine2.setText("__________________________________________");
                    lbLine2.setForeground(Color.gray);
                    infoBuildPanel.add(lbLine2);
                    lbLine2.setBounds(40, 130, 320, 20);

                    //---- inputUserName2 ----
                    inputUserName2.setBorder(null);
                    inputUserName2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
                    infoBuildPanel.add(inputUserName2);
                    inputUserName2.setBounds(40, 115, 295, 25);

                    //---- lbUser3 ----
                    lbUser3.setText("\u786e\u8ba4\u5bc6\u7801");
                    lbUser3.setPreferredSize(new Dimension(40, 20));
                    lbUser3.setHorizontalAlignment(SwingConstants.CENTER);
                    lbUser3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser3.setBackground(Color.white);
                    lbUser3.setOpaque(true);
                    lbUser3.setAlignmentX(200.0F);
                    lbUser3.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser3);
                    lbUser3.setBounds(15, 165, 110, 20);

                    //---- lbLine3 ----
                    lbLine3.setText("__________________________________________");
                    lbLine3.setForeground(Color.gray);
                    infoBuildPanel.add(lbLine3);
                    lbLine3.setBounds(40, 205, 320, 20);

                    //---- inputUserName3 ----
                    inputUserName3.setBorder(null);
                    inputUserName3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
                    infoBuildPanel.add(inputUserName3);
                    inputUserName3.setBounds(40, 190, 295, 25);

                    //---- lbUser4 ----
                    lbUser4.setText("\u6027\u522b");
                    lbUser4.setPreferredSize(new Dimension(40, 20));
                    lbUser4.setHorizontalAlignment(SwingConstants.CENTER);
                    lbUser4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser4.setBackground(Color.white);
                    lbUser4.setOpaque(true);
                    lbUser4.setAlignmentX(200.0F);
                    lbUser4.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser4);
                    lbUser4.setBounds(0, 325, 110, 20);

                    //---- checkBox2 ----
                    checkBox2.setText("\u5973");
                    checkBox2.setOpaque(false);
                    checkBox2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    checkBox2.setFocusPainted(false);
                    checkBox2.setFocusable(false);
                    checkBox2.setContentAreaFilled(false);
                    infoBuildPanel.add(checkBox2);
                    checkBox2.setBounds(235, 320, 64, 31);

                    //---- checkBox3 ----
                    checkBox3.setText("\u7537");
                    checkBox3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    checkBox3.setContentAreaFilled(false);
                    checkBox3.setFocusable(false);
                    checkBox3.setFocusPainted(false);
                    checkBox3.setOpaque(false);
                    infoBuildPanel.add(checkBox3);
                    checkBox3.setBounds(135, 320, 64, 31);

                    //---- lbUser5 ----
                    lbUser5.setText("\u57ce\u5e02");
                    lbUser5.setPreferredSize(new Dimension(40, 20));
                    lbUser5.setHorizontalAlignment(SwingConstants.CENTER);
                    lbUser5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser5.setBackground(Color.white);
                    lbUser5.setOpaque(true);
                    lbUser5.setAlignmentX(200.0F);
                    lbUser5.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser5);
                    lbUser5.setBounds(0, 235, 110, 20);

                    //---- inputUserName4 ----
                    inputUserName4.setBorder(null);
                    inputUserName4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
                    infoBuildPanel.add(inputUserName4);
                    inputUserName4.setBounds(40, 260, 295, 25);

                    //---- lbLine4 ----
                    lbLine4.setText("__________________________________________");
                    lbLine4.setForeground(Color.gray);
                    infoBuildPanel.add(lbLine4);
                    lbLine4.setBounds(40, 275, 320, 20);

                    //---- button1 ----
                    button1.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_first_normal.png"));
                    button1.setContentAreaFilled(false);
                    button1.setBorderPainted(false);
                    button1.setFocusPainted(false);
                    button1.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_selected.png"));
                    button1.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_normal.png"));
                    infoBuildPanel.add(button1);
                    button1.setBounds(95, 395, 195, 50);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < infoBuildPanel.getComponentCount(); i++) {
                            Rectangle bounds = infoBuildPanel.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = infoBuildPanel.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        infoBuildPanel.setMinimumSize(preferredSize);
                        infoBuildPanel.setPreferredSize(preferredSize);
                    }
                }
                infoPanel.add(infoBuildPanel);
            }
            mainPanel.add(infoPanel);
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainPanel;
    private JLayeredPane layeredPane;
    private PictureLabel registerPC;
    private JButton btnFormClose;
    private JPanel infoPanel;
    private JPanel infoBuildPanel;
    private JLabel lbUser;
    private JLabel lbLine1;
    private JTextField inputUserName;
    private JLabel lbUser2;
    private JLabel lbLine2;
    private JTextField inputUserName2;
    private JLabel lbUser3;
    private JLabel lbLine3;
    private JTextField inputUserName3;
    private JLabel lbUser4;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JLabel lbUser5;
    private JTextField inputUserName4;
    private JLabel lbLine4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        RegisterLayout registerLayout = new RegisterLayout();

    }
}
