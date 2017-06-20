package ui.custom;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/20.
 */
public class UserPanel extends JLayeredPane {
    private PictureLabel pictureLabel;
    private PictureLabel circleBlock;
    private JLabel label;
    private String pcUrl;
    private String text;

    public UserPanel(){
        setOpaque(true);
        setBackground(Color.white);
        setBounds(0,0,210,75);
        setMaximumSize(new Dimension(450,75));
        init();
        this.add(circleBlock);
        this.add(pictureLabel);
        this.add(label);
    }

    public void init(){
        circleBlock = new PictureLabel("resources/circle.png",66,66);
        circleBlock.setBounds(25,4,66,66);
        pictureLabel = new PictureLabel("resources/loginBtn_hover.png",65,65);
        pictureLabel.setBounds(25,5,65,65);
        label = new JLabel("用户名");
        Font font = new Font("微软雅黑",Font.BOLD,16);
        label.setFont(font);
        label.setBounds(100,30,210,20);
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(Color.lightGray);
        graphics2D.drawLine(0,74,230,74);
    }

    public void refresh(){
        pictureLabel.setUrl(pcUrl);
        label.setText(text);
    }

    public String getPcUrl() {
        return pcUrl;
    }

    public void setPcUrl(String pcUrl) {
        this.pcUrl = pcUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
