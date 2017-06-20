package ui.custom;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 廷江 on 2017/6/20.
 */
public class ChatItem extends JPanel {
    private CirclePictureLabel circlePictureLabel;
    private JTextArea textArea;
    private String imgUrl;
    private String content;
    private Color areaColor = Color.LIGHT_GRAY;
    private Color textColor = Color.DARK_GRAY;

    private int areaWidth;
    private int areaHeight;

    private int imgWidth;
    private int imgHeight;

    private int margin = 15;

    private static int maxAreaWidth = 350;
    private int lineCount;



    public ChatItem(){
        circlePictureLabel = new CirclePictureLabel();

        textArea = new JTextArea();
        Font font = new Font("微软雅黑",Font.PLAIN,16);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(5,20,5,20));

        this.setLayout(null);
        this.add(circlePictureLabel);
        this.add(textArea);
        this.setBackground(Color.white);
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
        init();
    }

    private void reCalHeight(){
        System.out.println(textArea.getText().length());
        lineCount = textArea.getText().length()/15;
        System.out.println(lineCount);
        this.areaHeight = lineCount*27;
        this.areaWidth = textArea.getText().length()*15;
        System.out.println(areaHeight);
        System.out.println(areaWidth);
    }

    private void refresh(){
//        this.setBounds(0,0,getWidth(),getHeight());
        circlePictureLabel.setImgWidth(imgWidth);
        circlePictureLabel.setImgHeight(imgHeight);
        circlePictureLabel.setUrl(imgUrl);
        circlePictureLabel.setBounds(10,10,imgWidth,imgHeight);

        textArea.setText(content);
        textArea.setBackground(areaColor);
        textArea.setForeground(textColor);
        reCalHeight();
        textArea.setBounds(imgWidth+margin,imgHeight/4,lineCount>1?maxAreaWidth:areaWidth,lineCount>1?areaHeight:30);
        this.setPreferredSize(new Dimension(lineCount>1?maxAreaWidth:areaWidth,lineCount>1?areaHeight:30));
//        textArea.setWrapStyleWord(true);
//        textArea.setBounds(imgWidth+margin,imgHeight/4,textArea.getLineCount()==1?areaWidth:maxAreaWidth,areaHeight);
    }

    private void init(){
        this.setBounds(0,0,areaWidth,areaHeight);

        circlePictureLabel = new CirclePictureLabel(imgUrl,imgWidth,imgHeight);
        circlePictureLabel.setBounds(5,5,imgWidth,imgHeight);
        this.add(circlePictureLabel);

        textArea = new JTextArea(content);
        textArea.setBackground(areaColor);
        textArea.setForeground(textColor);
        this.add(textArea);
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

}
