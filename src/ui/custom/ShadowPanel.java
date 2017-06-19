package ui.custom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/19.
 */
public class ShadowPanel extends JPanel {

    public ShadowPanel(){
        setLayout(new BorderLayout());
        setOpaque(false);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0,0,5,5));
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(mgr);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        graphics2D.fillRect(5,5,getWidth(),getHeight());
        graphics2D.dispose();
    }
}
