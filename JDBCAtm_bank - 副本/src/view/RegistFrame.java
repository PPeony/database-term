package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("all")
public class RegistFrame extends BaseFrame {

    private RegistFrame(String title){
        super(title);
        this.init();
    }
    private static RegistFrame registFrame;
    public synchronized static RegistFrame getRegistFrame(){
        if(registFrame==null){
            registFrame = new RegistFrame("注册窗口");
        }
        return registFrame;
    }

    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("请 您 填 写 信 息");
    private JLabel accountLabel = new JLabel("请输入账号：");
    private JTextField accountField = new JTextField();
    private JLabel nameLabel=new JLabel("请输入姓名:");
    private JTextField nameField=new JTextField();
    private JLabel idLabel=new JLabel("请输入身份证号：");
    private JTextField idField=new JTextField();
    private JLabel passwordLabel = new JLabel("请输入密码：");
    private JTextField passwordField = new JTextField();
    //private JLabel balanceLabel = new JLabel("请输入金额：");
    //private JTextField balanceField = new JTextField();
    private JButton registButton = new JButton("注 册");
    private JButton resetButton = new JButton("重 置");
    private JButton backButton = new JButton("返 回");

    //一个变量 用来控制登录页面
    private LoginFrame loginFrame = LoginFrame.getLoginFrame();

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(135,40,40,40);
        logoLabel.setIcon(this.drawImage("src//img//duyi.jpg",40,40));
        titleLabel.setBounds(185,40,200,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        accountLabel.setBounds(30,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(190,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(30,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(190,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        nameLabel.setBounds(30,200,140,40);
        nameLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        nameField.setBounds(190,205,260,32);
        nameField.setFont(new Font("微软雅黑",Font.BOLD,20));
        idLabel.setBounds(30,245,150,40);
        idLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        idField.setBounds(190,250,260,32);
        idField.setFont(new Font("微软雅黑",Font.BOLD,20));
        registButton.setBounds(60,310,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        registButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setBounds(190,310,100,32);
        resetButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        resetButton.setBackground(Color.LIGHT_GRAY);
        backButton.setBounds(320,310,100,32);
        backButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        backButton.setBackground(Color.LIGHT_GRAY);
    }
    protected void addElement() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(registButton);
        mainPanel.add(resetButton);
        mainPanel.add(backButton);
        this.add(mainPanel);
    }
    protected void addListener() {
        registButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String apassword = passwordField.getText();
                String name=nameField.getText();
                String id=idField.getText();
                AtmService service = MySpring.getBean("service.AtmService");
                service.regist(account,name,id,apassword);
                JOptionPane.showMessageDialog(RegistFrame.this,"注册成功");
                accountField.setText("");//注册成功之后所有输入框清空
                passwordField.setText("");
                nameField.setText("");
                idField.setText("");
                RegistFrame.this.setVisible(false);
                loginFrame.setVisible(true);
            }
        });
    }

    //自定义方法 设置返回登录页面
    private void back(){
        this.setVisible(false);
        loginFrame.setVisible(true);
    }
    //自定义方法 设置所有组件清空
    void reset(){
        accountField.setText("");
        passwordField.setText("");
        nameField.setText("");
        idField.setText("");
    }

    protected void setFrameSelf() {
        this.setBounds(430,200,500,450);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
