/*
 * Created by JFormDesigner on Tue Jun 20 08:34:19 CST 2017
 */

package ui.login;

import controller.LoginControl;
import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.LinearInputBox;
import ui.custom.LinearPasswordBox;
import ui.custom.PictureLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class LoginLayout extends JFrame {
    LoginControl loginControl;
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
        loginControl = new LoginControl(this);
    }

    /**
     * 为控件绑定事件
     */
    public void initEvent(){
        btnFormClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginControl.systemExit();
            }
        });
        edtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!edtUserName.getText().isEmpty()){
                    lbUser.setText("用户名");
                    lbUser.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (!edtUserName.getText().isEmpty()){
                    lbUser.setText("用户名");
                    lbUser.setForeground(Color.black);
                }
            }
        });
        edtPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!edtPassword.getText().isEmpty()){
                    lbPassword.setText("密码");
                    lbUser.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (!edtPassword.getText().isEmpty()){
                    lbPassword.setText("密码");
                    lbUser.setForeground(Color.black);
                }
            }
        });
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (loginControl.checkInfo()){
                    loginControl.login();
                }
            }
        });
        regisiterLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginControl.register();
            }
        });
        ckStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginControl.storePassword();
            }
        });
    }

    /**
     * 控件设置
     */
    private void initSetting(){

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

    /**
     * 摆放控件
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        layeredPane = new JLayeredPane();
        registerPC = new PictureLabel();
        btnFormClose = new JButton();
        infoPanel = new JPanel();
        infoBuildPanel = new JPanel();
        edtUserName = new LinearInputBox();
        edtPassword = new LinearPasswordBox();
        lbUser = new JLabel();
        lbPassword = new JLabel();
        btnLogin = new JButton();
        regisiterLabel = new LinearInputBox();
        ckStore = new JCheckBox();
        lbStatus = new JLabel();

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
                    lbUser.setBounds(50, 35, 185, lbUser.getPreferredSize().height);

                    //---- lbPassword ----
                    lbPassword.setText("\u5bc6\u7801");
                    lbPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    lbPassword.setForeground(Color.gray);
                    infoBuildPanel.add(lbPassword);
                    lbPassword.setBounds(50, 115, 185, 20);

                    //---- btnLogin ----
                    btnLogin.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_normal.png"));
                    btnLogin.setContentAreaFilled(false);
                    btnLogin.setBorderPainted(false);
                    btnLogin.setFocusPainted(false);
                    btnLogin.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_selected.png"));
                    btnLogin.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\loginBtn_hover.png"));
                    infoBuildPanel.add(btnLogin);
                    btnLogin.setBounds(95, 230, 195, 40);

                    //---- regisiterLabel ----
                    regisiterLabel.setWidth(60);
                    regisiterLabel.setHeight(30);
                    regisiterLabel.setBorder(null);
                    regisiterLabel.setMaximumSize(new Dimension(60, 30));
                    regisiterLabel.setText("    \u6ce8\u518c");
                    regisiterLabel.setEnabled(false);
                    regisiterLabel.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    infoBuildPanel.add(regisiterLabel);
                    regisiterLabel.setBounds(290, 280, 70, 30);

                    //---- ckStore ----
                    ckStore.setText("\u8bb0\u4f4f\u5bc6\u7801");
                    ckStore.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    ckStore.setContentAreaFilled(false);
                    ckStore.setFocusPainted(false);
                    ckStore.setForeground(Color.gray);
                    infoBuildPanel.add(ckStore);
                    ckStore.setBounds(new Rectangle(new Point(50, 190), ckStore.getPreferredSize()));

                    //---- lbStatus ----
                    lbStatus.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    infoBuildPanel.add(lbStatus);
                    lbStatus.setBounds(95, 285, 180, 20);

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

    public JCheckBox getCkStore() {
        return ckStore;
    }

    public LinearInputBox getRegisiterLabel() {
        return regisiterLabel;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JLabel getLbPassword() {
        return lbPassword;
    }

    public JLabel getLbUser() {
        return lbUser;
    }

    public LinearInputBox getEdtUserName() {
        return edtUserName;
    }

    public LinearPasswordBox getEdtPassword() {
        return edtPassword;
    }

    public JLabel getLbStatus() {
        return lbStatus;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainPanel;
    private JLayeredPane layeredPane;
    private PictureLabel registerPC;
    private JButton btnFormClose;
    private JPanel infoPanel;
    private JPanel infoBuildPanel;
    private LinearInputBox edtUserName;
    private LinearPasswordBox edtPassword;
    private JLabel lbUser;
    private JLabel lbPassword;
    private JButton btnLogin;
    private LinearInputBox regisiterLabel;
    private JCheckBox ckStore;
    private JLabel lbStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        LoginLayout loginLayout = new LoginLayout();
    }
}
