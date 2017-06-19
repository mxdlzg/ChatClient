package ui.custom;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/19.
 */
public class PictureLabel extends JLabel {
    private ImageIcon imageIcon;
    private int width;
    private int height;
    private String url;

    public PictureLabel(){

    }

    public PictureLabel(String url,int width,int height){
        super();
        this.url = url;
        this.width = width;
        this.height = height;
        this.imageIcon = new ImageIcon(this.url);
        init();
    }

    public PictureLabel(ImageIcon image,int width,int height) {
        super();
        this.imageIcon = image;
        this.width = width;
        this.height = height;
        init();
    }

    private void init(){
        this.imageIcon.setImage(this.imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        Icon icon = imageIcon;
        super.setIcon(icon);
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        this.imageIcon = new ImageIcon(this.url);
        this.imageIcon.setImage(this.imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        init();
    }
}
