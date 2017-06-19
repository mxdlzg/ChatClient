/*
 * Created by JFormDesigner on Mon Jun 19 16:44:41 CST 2017
 */

package ui.register;

import ui.custom.PictureLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author mxdlzg
 */
public class RegisterLayout extends JFrame {
    private static final long serialVersionUID = 1L;
    private int oldX;
    private int oldY;

    /**
     * 添加阴影
     */
    public void rebuildShadow(){
        registerBasePanel.setBorder(new LineBorder(Color.BLACK));
    }

    /**
     * 处理拖动
     */
    public void rebuildDragged(){
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
        rebuildShadow();
        rebuildDragged();
        this.setSize(400,800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }










    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        registerBasePanel = new JPanel();
        registerPC = new PictureLabel();

        //======== this ========
        setBackground(Color.white);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== registerBasePanel ========
        {
            registerBasePanel.setBackground(Color.white);
            registerBasePanel.setLayout(new FlowLayout());

            //---- registerPC ----
            registerPC.setText("text");
            registerPC.setHeight(300);
            registerPC.setWidth(500);
            registerPC.setImageIcon(null);
            registerPC.setUrl("resources/registerPC.jpg");
            registerBasePanel.add(registerPC);
        }
        contentPane.add(registerBasePanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel registerBasePanel;
    private PictureLabel registerPC;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        RegisterLayout registerLayout = new RegisterLayout();

    }
}
