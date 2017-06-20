package ui.custom;

import javax.swing.*;

/**
 * Created by 廷江 on 2017/6/20.
 */
public class CirclePictureLabel extends JLabel {
    private PictureLabel pictureLabel;
    private PictureLabel circleLabel;
    private String url;
    private ImageIcon imageIcon;
    private ImageIcon circleImage = new ImageIcon("resources/circle.png");

    private int imgWidth;
    private int imgHeight;

    public CirclePictureLabel() {
        this.setLayout(null);
    }

    public CirclePictureLabel(String url, int imgWidth, int imgHeight) {
        this.url = url;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.setLayout(null);
        refresh();
    }

    private void refresh(){
        imageIcon = new ImageIcon(url);
        pictureLabel = new PictureLabel(imageIcon,imgWidth,imgHeight);
        circleLabel = new PictureLabel(circleImage,imgWidth,imgHeight);
        this.add(circleLabel);
        this.add(pictureLabel);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        refresh();
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }
}
