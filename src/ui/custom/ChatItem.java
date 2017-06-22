package ui.custom;

import util.Util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/20.
 */
public class ChatItem extends JPanel {
    private CirclePictureLabel circlePictureLabel;
    private JTextArea textArea;
    private String imgUrl = "resources/registerBtn_normal.png";
    private String content;
    private Color areaColor = Color.LIGHT_GRAY;
    private Color textColor = Color.DARK_GRAY;

    private boolean rightToLeft = false;

    private int areaWidth;
    private int areaHeight;

    private int imgWidth = 50;
    private int imgHeight = 50;

    private int margin = 15;

    private static int maxWidth = 1600;
    private static int maxAreaWidth = 350;
    private int lineCount;



    public ChatItem(){
        init(false);
    }

    public ChatItem(String imgUrl, String content, int areaWidth, int areaHeight, int imgWidth, int imgHeight, Color areaColor, Color textColor) {
        this.imgUrl = imgUrl;
        this.content = content;
        this.areaWidth = areaWidth;
        this.areaHeight = areaHeight;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.areaColor = areaColor;
        this.textColor = textColor;
        init(true);
    }

    private void reCalHeight(){
        String content = textArea.getText();
//        System.out.println(content.length());
        int count = Util.countblank(content);
        lineCount = content.length()/15+count;
//        System.out.println("lineCount"+lineCount);
        this.areaHeight = lineCount*27;
        if (content.length()<=2){
            this.areaWidth = content.length()*50;
        }else {
            this.areaWidth = content.length()*26;
        }
//        System.out.println(areaHeight);
//        System.out.println(areaWidth);
    }

    private void init(boolean refresh){
        Font font = new Font("微软雅黑",Font.PLAIN,16);
        circlePictureLabel = new CirclePictureLabel();
        textArea = new JTextArea();
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(5,10,5,20));

        this.setPreferredSize(new Dimension(maxWidth,50));
        this.setMaximumSize(new Dimension(maxWidth,50));
        this.setLayout(null);
        this.add(circlePictureLabel);
        this.add(textArea);
        this.setBackground(Color.white);
        if (refresh){
            refresh();
        }
    }

    private void refresh(){
        circlePictureLabel.setImgWidth(imgWidth);
        circlePictureLabel.setImgHeight(imgHeight);
        circlePictureLabel.setUrl(imgUrl);

        textArea.setText(content);
        textArea.setBackground(areaColor);
        textArea.setForeground(textColor);

        reCalHeight();
//        System.out.println("area width:"+(lineCount>1?maxAreaWidth:areaWidth));
//        System.out.println("area height:"+(lineCount>1?areaHeight:60));

        if (rightToLeft){
            circlePictureLabel.setBounds(790-imgWidth-10,10,imgWidth,imgHeight);
            textArea.setBounds(790-imgWidth-textArea.getWidth()-margin,imgHeight/4,lineCount>1?maxAreaWidth:areaWidth,lineCount>1?areaHeight:30);
        }else {
            circlePictureLabel.setBounds(10,10,imgWidth,imgHeight);
            textArea.setBounds(imgWidth+margin,imgHeight/4,lineCount>1?maxAreaWidth:areaWidth,lineCount>1?areaHeight:30);
        }
        this.setMaximumSize(new Dimension(maxWidth,lineCount>1?areaHeight+30:60));
//        this.setMinimumSize(new Dimension(790,50));

//        this.setPreferredSize(new Dimension(lineCount>1?maxAreaWidth:areaWidth,lineCount>1?areaHeight:30));
//        textArea.setWrapStyleWord(true);
//        textArea.setBounds(imgWidth+margin,imgHeight/4,textArea.getLineCount()==1?areaWidth:maxAreaWidth,areaHeight);
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        refresh();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        refresh();
    }

    public Color getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public int getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(int areaWidth) {
        this.areaWidth = areaWidth;
    }

    public int getAreaHeight() {
        return areaHeight;
    }

    public void setAreaHeight(int areaHeight) {
        this.areaHeight = areaHeight;
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

    public boolean isRightToLeft() {
        return rightToLeft;
    }

    public void setRightToLeft(boolean rightToLeft) {
        this.rightToLeft = rightToLeft;
        refresh();
    }
}
