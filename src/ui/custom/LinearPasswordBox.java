package ui.custom;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/21.
 */
public class LinearPasswordBox extends JPasswordField {
    private int width = 200;
    private int height = 20;
    private float bottomLineWidth = 2.0f;

    public LinearPasswordBox(){
        super();
        this.width = super.getWidth();
        this.height = super.getHeight();
    }

    public LinearPasswordBox(String text){
        super(text);
        this.width = super.getWidth();
        this.height = super.getHeight();
    }

    /**
     * 重绘下边界，模拟editbox下边线
     * @param g graphics
     */
    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(bottomLineWidth));
        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.drawLine(0, (int) (height-bottomLineWidth+1),width, (int) (height-bottomLineWidth+1));
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getBottomLineWidth() {
        return bottomLineWidth;
    }

    public void setBottomLineWidth(float bottomLineWidth) {
        this.bottomLineWidth = bottomLineWidth;
    }
}
