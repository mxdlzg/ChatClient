/*
 * Created by JFormDesigner on Tue Jun 20 08:34:19 CST 2017
 */

package ui.login;

import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.LinearInputBox;
import ui.custom.PictureLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class LoginLayout extends JFrame {
    private int oldX;
    private int oldY;

    /**
     * 构造登录界面，设置控件，绑定事件，重绘窗体
     */
    public LoginLayout() {
        this.setUndecorated(true);
        initComponents();
        initEvent();
        initForm();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * 为控件绑定事件
     */
    public void initEvent(){
        btnFormClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
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
                LoginLayout.this.setLocation(onScreenX-oldX,onScreenY-oldY);
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
        layeredPane = new JLayeredPane();
        registerPC = new PictureLabel();
        btnFormClose = new JButton();
        infoPanel = new JPanel();
        infoBuildPanel = new JPanel();
        edtUserName = new LinearInputBox();
        edtPassword = new LinearInputBox();
        lbUser = new JLabel();
        lbPassword = new JLabel();
        btnLogin = new JButton();
        linearInputBox1 = new LinearInputBox();
        checkBox1 = new JCheckBox();

        //======== this ========
        setMinimumSize(new Dimension(400, 500));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainPanel ========
        {
            mainPanel.setMinimumSize(new Dimension(400, 500));
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            //======== layeredPane ========
            {
                layeredPane.setMinimumSize(new Dimension(400, 300));
                layeredPane.setMaximumSize(new Dimension(400, 150));

                //---- registerPC ----
                registerPC.setText("text");
                registerPC.setHeight(150);
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
                    infoBuildPanel.setMaximumSize(new Dimension(400, 350));
                    infoBuildPanel.setBackground(Color.white);
                    infoBuildPanel.setMinimumSize(new Dimension(400, 350));
                    infoBuildPanel.setPreferredSize(new Dimension(360, 280));
                    infoBuildPanel.setInheritsPopupMenu(true);
                    infoBuildPanel.setLayout(null);

                    //---- edtUserName ----
                    edtUserName.setMaximumSize(new Dimension(300, 30));
                    edtUserName.setWidth(300);
                    edtUserName.setHeight(30);
                    edtUserName.setBorder(null);
                    edtUserName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
                    infoBuildPanel.add(edtUserName);
                    edtUserName.setBounds(50, 60, 300, 30);

                    //---- edtPassword ----
                    edtPassword.setMaximumSize(new Dimension(300, 30));
                    edtPassword.setWidth(300);
                    edtPassword.setHeight(30);
                    edtPassword.setBorder(null);
                    edtPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
                    infoBuildPanel.add(edtPassword);
                    edtPassword.setBounds(50, 135, 300, 30);

                    //---- lbUser ----
                    lbUser.setText("\u7528\u6237\u540d");
                    lbUser.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    lbUser.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser);
                    lbUser.setBounds(new Rectangle(new Point(50, 35), lbUser.getPreferredSize()));

                    //---- lbPassword ----
                    lbPassword.setText("\u5bc6\u7801");
                    lbPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    lbPassword.setForeground(Color.gray);
                    infoBuildPanel.add(lbPassword);
                    lbPassword.setBounds(50, 115, 45, 20);

                    //---- btnLogin ----
                    btnLogin.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_normal.png"));
                    btnLogin.setContentAreaFilled(false);
                    btnLogin.setBorderPainted(false);
                    btnLogin.setFocusPainted(false);
                    btnLogin.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_selected.png"));
                    btnLogin.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_hover.png"));
                    infoBuildPanel.add(btnLogin);
                    btnLogin.setBounds(95, 230, 195, 40);

                    //---- linearInputBox1 ----
                    linearInputBox1.setWidth(60);
                    linearInputBox1.setHeight(30);
                    linearInputBox1.setBorder(null);
                    linearInputBox1.setMaximumSize(new Dimension(60, 30));
                    linearInputBox1.setText("    \u6ce8\u518c");
                    linearInputBox1.setEnabled(false);
                    linearInputBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    infoBuildPanel.add(linearInputBox1);
                    linearInputBox1.setBounds(290, 280, 70, 30);

                    //---- checkBox1 ----
                    checkBox1.setText("\u8bb0\u4f4f\u5bc6\u7801");
                    checkBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    checkBox1.setContentAreaFilled(false);
                    checkBox1.setFocusPainted(false);
                    checkBox1.setForeground(Color.gray);
                    infoBuildPanel.add(checkBox1);
                    checkBox1.setBounds(new Rectangle(new Point(50, 190), checkBox1.getPreferredSize()));

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
    private LinearInputBox edtUserName;
    private LinearInputBox edtPassword;
    private JLabel lbUser;
    private JLabel lbPassword;
    private JButton btnLogin;
    private LinearInputBox linearInputBox1;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        LoginLayout loginLayout = new LoginLayout();
    }
}
