package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class LoginFrame extends BaseFrame {

    private LoginFrame(String title){
        super(title);
        this.init();
    }
    private static LoginFrame loginFrame;
    public synchronized static LoginFrame getLoginFrame(){
        if(loginFrame==null){
            loginFrame = new LoginFrame("登录窗口");
        }
        return loginFrame;
    }

    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();
    private JLabel titleLabel = new JLabel("请 您 登 录 系 统");
    private JLabel accountLabel = new JLabel("请输入账号:");
    private JTextField accountField = new JTextField();
    private JLabel passwordLabel = new JLabel("请输入密码:");
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton( "登 录");
    private JButton registButton = new JButton("注 册");

    //一个变量用来控制注册页面
    private RegistFrame registFrame = null;

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(135,40,40,40);
        logoLabel.setIcon(this.drawImage("src//img//duyi.jpg",40,40));
        titleLabel.setBounds(185,40,200,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        accountLabel.setBounds(40,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(170,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(40,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(170,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        loginButton.setBounds(120,210,100,32);
        loginButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        loginButton.setBackground(Color.LIGHT_GRAY);
        registButton.setBounds(260,210,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        registButton.setBackground(Color.LIGHT_GRAY);
    }
    protected void addElement() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(registButton);
        this.add(mainPanel);
    }

    protected void addListener() {
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String apassword = new String(passwordField.getPassword());
                AtmService service = MySpring.getBean("service.AtmService");
                String result = service.login(account,apassword);
                if(result.equals("登录成功")){
                    LoginFrame.this.setVisible(false);
                    AtmFrame.getAtmFrame(account);//登录成功以后 新的操作窗口中需要登录时的账号名
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                }
            }
        });
        registButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.setVisible(false);
                RegistFrame.getRegistFrame();
            }
        });
    }

    //设计一个单独的方法 用来还原账号和密码框
    void reset(){
        accountField.setText("");
        passwordField.setText("");
    }
    protected void setFrameSelf() {
        this.setBounds(400,200,500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

}
