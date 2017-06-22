/*
 * Created by JFormDesigner on Mon Jun 19 16:44:41 CST 2017
 */

package ui.register;

import controller.RegisterControl;
import org.jdesktop.swingx.border.DropShadowBorder;
import ui.custom.*;
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
public class RegisterLayout extends JDialog {
    private static final long serialVersionUID = 1L;
    private RegisterControl registerControl;
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
        registerControl = new RegisterControl(this);
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
        btnRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerControl.register();
            }
        });
        edtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                resetColor(edtUserName,lbUser,"用户名");
            }

            @Override
            public void focusLost(FocusEvent e) {
                resetColor(edtUserName,lbUser,"用户名");
            }
        });
        edtFirstPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                resetColor(edtFirstPassword,lbFirstPassword,"密码");
            }

            @Override
            public void focusLost(FocusEvent e) {
                resetColor(edtFirstPassword,lbFirstPassword,"密码");
            }
        });
        edtSecondPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                resetColor(edtSecondPassword,lbSecondPassword,"确认密码");
            }

            @Override
            public void focusLost(FocusEvent e) {
                resetColor(edtSecondPassword,lbSecondPassword,"确认密码");
            }
        });
        edtCity.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                resetColor(edtCity,lbCity,"城市");
            }

            @Override
            public void focusLost(FocusEvent e) {
                resetColor(edtCity,lbCity,"城市");
            }
        });
        cbMale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cbMale.isSelected()){
                    if (cbFemale.isSelected()){
                        cbFemale.setSelected(false);
                    }
                    lbSex.setText("性别");
                    lbSex.setForeground(Color.GRAY);
                }
            }
        });
        cbFemale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cbFemale.isSelected()){
                    if (cbMale.isSelected()){
                        cbMale.setSelected(false);
                    }
                    lbSex.setText("性别");
                    lbSex.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void resetColor(JTextField edt,JLabel lb,String info){
        if (!edt.getText().isEmpty()){
            lb.setText(info);
            lb.setForeground(Color.black);
        }
    }

    public JLabel getLbUser() {
        return lbUser;
    }

    public JLabel getLbFirstPassword() {
        return lbFirstPassword;
    }

    public JLabel getLbSex() {
        return lbSex;
    }

    public JLabel getLbSecondPassword() {
        return lbSecondPassword;
    }

    public JCheckBox getCbFemale() {
        return cbFemale;
    }

    public JCheckBox getCbMale() {
        return cbMale;
    }

    public JLabel getLbCity() {
        return lbCity;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public LinearPasswordBox getEdtFirstPassword() {
        return edtFirstPassword;
    }

    public LinearInputBox getEdtUserName() {
        return edtUserName;
    }

    public LinearPasswordBox getEdtSecondPassword() {
        return edtSecondPassword;
    }

    public LinearInputBox getEdtCity() {
        return edtCity;
    }

    public JLabel getLbStatus() {
        return lbStatus;
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
        lbFirstPassword = new JLabel();
        lbSecondPassword = new JLabel();
        lbSex = new JLabel();
        cbFemale = new JCheckBox();
        cbMale = new JCheckBox();
        lbCity = new JLabel();
        btnRegister = new JButton();
        edtFirstPassword = new LinearPasswordBox();
        edtUserName = new LinearInputBox();
        edtSecondPassword = new LinearPasswordBox();
        edtCity = new LinearInputBox();
        lbStatus = new JLabel();

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
                    lbUser.setHorizontalAlignment(SwingConstants.LEFT);
                    lbUser.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbUser.setBackground(Color.white);
                    lbUser.setOpaque(true);
                    lbUser.setAlignmentX(200.0F);
                    lbUser.setForeground(Color.gray);
                    infoBuildPanel.add(lbUser);
                    lbUser.setBounds(35, 15, 200, lbUser.getPreferredSize().height);

                    //---- lbFirstPassword ----
                    lbFirstPassword.setText("\u5bc6\u7801");
                    lbFirstPassword.setPreferredSize(new Dimension(40, 20));
                    lbFirstPassword.setHorizontalAlignment(SwingConstants.LEFT);
                    lbFirstPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbFirstPassword.setBackground(Color.white);
                    lbFirstPassword.setOpaque(true);
                    lbFirstPassword.setAlignmentX(200.0F);
                    lbFirstPassword.setForeground(Color.gray);
                    infoBuildPanel.add(lbFirstPassword);
                    lbFirstPassword.setBounds(35, 85, 170, 20);

                    //---- lbSecondPassword ----
                    lbSecondPassword.setText("\u786e\u8ba4\u5bc6\u7801");
                    lbSecondPassword.setPreferredSize(new Dimension(40, 20));
                    lbSecondPassword.setHorizontalAlignment(SwingConstants.LEFT);
                    lbSecondPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbSecondPassword.setBackground(Color.white);
                    lbSecondPassword.setOpaque(true);
                    lbSecondPassword.setAlignmentX(200.0F);
                    lbSecondPassword.setForeground(Color.gray);
                    infoBuildPanel.add(lbSecondPassword);
                    lbSecondPassword.setBounds(35, 155, 175, 20);

                    //---- lbSex ----
                    lbSex.setText("\u6027\u522b");
                    lbSex.setPreferredSize(new Dimension(40, 20));
                    lbSex.setHorizontalAlignment(SwingConstants.LEFT);
                    lbSex.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbSex.setBackground(Color.white);
                    lbSex.setOpaque(true);
                    lbSex.setAlignmentX(200.0F);
                    lbSex.setForeground(Color.gray);
                    infoBuildPanel.add(lbSex);
                    lbSex.setBounds(35, 325, 95, 20);

                    //---- cbFemale ----
                    cbFemale.setText("\u5973");
                    cbFemale.setOpaque(false);
                    cbFemale.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    cbFemale.setFocusPainted(false);
                    cbFemale.setFocusable(false);
                    cbFemale.setContentAreaFilled(false);
                    infoBuildPanel.add(cbFemale);
                    cbFemale.setBounds(235, 320, 64, 31);

                    //---- cbMale ----
                    cbMale.setText("\u7537");
                    cbMale.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                    cbMale.setContentAreaFilled(false);
                    cbMale.setFocusable(false);
                    cbMale.setFocusPainted(false);
                    cbMale.setOpaque(false);
                    infoBuildPanel.add(cbMale);
                    cbMale.setBounds(135, 320, 64, 31);

                    //---- lbCity ----
                    lbCity.setText("\u57ce\u5e02");
                    lbCity.setPreferredSize(new Dimension(40, 20));
                    lbCity.setHorizontalAlignment(SwingConstants.LEFT);
                    lbCity.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    lbCity.setBackground(Color.white);
                    lbCity.setOpaque(true);
                    lbCity.setAlignmentX(200.0F);
                    lbCity.setForeground(Color.gray);
                    infoBuildPanel.add(lbCity);
                    lbCity.setBounds(35, 225, 165, 20);

                    //---- btnRegister ----
                    btnRegister.setIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_first_normal.png"));
                    btnRegister.setContentAreaFilled(false);
                    btnRegister.setBorderPainted(false);
                    btnRegister.setFocusPainted(false);
                    btnRegister.setPressedIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_selected.png"));
                    btnRegister.setRolloverIcon(new ImageIcon("E:\\JetBrains\\IDEA projects\\ChatClient\\resources\\registerBtn_normal.png"));
                    infoBuildPanel.add(btnRegister);
                    btnRegister.setBounds(100, 375, 195, 50);

                    //---- edtFirstPassword ----
                    edtFirstPassword.setWidth(300);
                    edtFirstPassword.setHeight(30);
                    edtFirstPassword.setBorder(null);
                    infoBuildPanel.add(edtFirstPassword);
                    edtFirstPassword.setBounds(40, 110, 300, 30);

                    //---- edtUserName ----
                    edtUserName.setHeight(30);
                    edtUserName.setWidth(300);
                    edtUserName.setBorder(null);
                    edtUserName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
                    infoBuildPanel.add(edtUserName);
                    edtUserName.setBounds(40, 35, 300, 30);

                    //---- edtSecondPassword ----
                    edtSecondPassword.setBorder(null);
                    edtSecondPassword.setWidth(300);
                    edtSecondPassword.setHeight(30);
                    infoBuildPanel.add(edtSecondPassword);
                    edtSecondPassword.setBounds(40, 185, 300, 30);

                    //---- edtCity ----
                    edtCity.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
                    edtCity.setBorder(null);
                    edtCity.setWidth(300);
                    edtCity.setHeight(30);
                    infoBuildPanel.add(edtCity);
                    edtCity.setBounds(40, 260, 300, 30);

                    //---- lbStatus ----
                    lbStatus.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));
                    lbStatus.setForeground(Color.red);
                    infoBuildPanel.add(lbStatus);
                    lbStatus.setBounds(75, 445, 235, 25);

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
    private JLabel lbFirstPassword;
    private JLabel lbSecondPassword;
    private JLabel lbSex;
    private JCheckBox cbFemale;
    private JCheckBox cbMale;
    private JLabel lbCity;
    private JButton btnRegister;
    private LinearPasswordBox edtFirstPassword;
    private LinearInputBox edtUserName;
    private LinearPasswordBox edtSecondPassword;
    private LinearInputBox edtCity;
    private JLabel lbStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        RegisterLayout registerLayout = new RegisterLayout();

    }
}
