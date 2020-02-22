package util;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {

    public BaseFrame(){}
    public BaseFrame(String title){
        super(title);
    }

    protected void init(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    //1.设置 字体 颜色 背景 布局等等
    protected abstract void setFontAndSoOn();
    //2.将属性添加到窗体里
    protected abstract void addElement();
    //3.添加事件监听
    protected abstract void addListener();
    //4.设置窗体自身
    protected abstract void setFrameSelf();

    //设计一个方法 用来处理图片展示
    protected ImageIcon drawImage(String path,int width,int height){
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
