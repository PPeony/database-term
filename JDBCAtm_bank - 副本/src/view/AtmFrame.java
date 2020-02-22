package view;

import domain.trans;
import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AtmFrame extends BaseFrame {

    private String aname;
    private AtmService service = MySpring.getBean("service.AtmService");

    private AtmFrame(String aname,String title){
        super(title);
        this.aname = aname;
        this.init();
    }
    private static AtmFrame atmFrame;
    public synchronized static AtmFrame getAtmFrame(String aname){//aname是账户编号
        if(atmFrame==null){
            atmFrame = new AtmFrame(aname,"操作窗口");
        }
        return atmFrame;
    }

    //各种组件属性
    private JPanel mainPanel = new JPanel();
    private JLabel selectServerLabelCN = new JLabel("您好!请选择所需服务");
    private JLabel selectServerLabelEN = new JLabel("Please Select Service");
    private JLabel balenceLabelCN = new JLabel();
    private JLabel balenceLabelEN = new JLabel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("宝可梦银行");//title
    private JButton messageButton = new JButton("查询余额");//原本是销户，现改成查询余额
    private JButton exitButton = new JButton("退出");
    private JButton depositButton = new JButton("存款");
    private JButton withdrawalButton = new JButton("取款");
    private JButton addBankCardButton = new JButton("添加银行卡");
    private JButton queryHisButton=new JButton("查询交易记录");

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);

        logoLabel.setBounds(150,80,500,300);
        logoLabel.setIcon(this.drawImage("src//img//皮卡.png",500,300));
        titleLabel.setBounds(120,10,160,60);
        titleLabel.setFont(new Font("微软雅黑",Font.ITALIC,32));

        balenceLabelCN.setBounds(250,200,300,40);
        balenceLabelCN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balenceLabelCN.setHorizontalAlignment(JTextField.CENTER);
        balenceLabelEN.setBounds(240,240,320,40);
        balenceLabelEN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balenceLabelEN.setHorizontalAlignment(JTextField.CENTER);


        selectServerLabelCN.setBounds(250,370,300,40);
        selectServerLabelCN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelCN.setHorizontalAlignment(JTextField.CENTER);
        selectServerLabelEN.setBounds(250,400,300,40);
        selectServerLabelEN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelEN.setHorizontalAlignment(JTextField.CENTER);

        messageButton.setBounds(10,150,120,40);
        messageButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        messageButton.setBackground(Color.LIGHT_GRAY);
        messageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        queryHisButton.setBounds(10,270,120,40);
        queryHisButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        queryHisButton.setBackground(Color.LIGHT_GRAY);
        queryHisButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        exitButton.setBounds(10,390,120,40);
        exitButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        depositButton.setBounds(670,150,120,40);
        depositButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        depositButton.setBackground(Color.LIGHT_GRAY);
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        withdrawalButton.setBounds(670,270,120,40);
        withdrawalButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        withdrawalButton.setBackground(Color.LIGHT_GRAY);
        withdrawalButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addBankCardButton.setBounds(670,390,120,40);
        addBankCardButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        addBankCardButton.setBackground(Color.LIGHT_GRAY);
        addBankCardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    protected void addElement() {
        mainPanel.add(balenceLabelCN);
        mainPanel.add(balenceLabelEN);
        mainPanel.add(selectServerLabelCN);
        mainPanel.add(selectServerLabelEN);
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(messageButton);
        mainPanel.add(exitButton);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawalButton);
        mainPanel.add(addBankCardButton);
        mainPanel.add(queryHisButton);
        this.add(mainPanel);
    }
    protected void addListener() {
        //查询历史
        queryHisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("cardID:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("cardPw:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "请输入银行卡号和密码", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("x value: " + xField.getText());
                    System.out.println("y value: " + yField.getText());
                }
                String cardID=xField.getText();
                String cardPw=yField.getText();
                boolean checkCard=service.checkCard(cardID,cardPw);
                if(checkCard){
                    trans tr=new trans();
                    ArrayList<trans>transList=new ArrayList<>();
                    transList=service.selectHistory(cardID);
                    StringBuffer ans=new StringBuffer();
                    for(trans t:transList){
                        ans.append("卡号：");
                        ans.append(t.getCardID());
                        ans.append(" 类型:");
                        ans.append(t.getTransType());
                        ans.append(" 数额：");
                        ans.append(t.getTransMoney());
                        ans.append(" 日期：");
                        ans.append(t.getDate());
                        ans.append("\n");
                    }
                    JOptionPane.showMessageDialog(AtmFrame.this,ans);
                }else{
                    JOptionPane.showMessageDialog(AtmFrame.this,"账号或者密码错误");
                }
            }
        });

        //查询余额
        messageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("cardID:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("cardPw:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "请输入银行卡号和密码", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("x value: " + xField.getText());
                    System.out.println("y value: " + yField.getText());
                }
                String cardID=xField.getText();
                String cardPw=yField.getText();
                boolean checkCard=service.checkCard(cardID,cardPw);
                if(checkCard){
                    Float balance=service.queryBalance(cardID);
                    JOptionPane.showMessageDialog(AtmFrame.this,balance);
                }else{
                    JOptionPane.showMessageDialog(AtmFrame.this,"账号或者密码错误");
                }
            }
        });
        //添加存款功能
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("cardID:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("cardPw:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "请输入银行卡号和密码", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("x value: " + xField.getText());
                    System.out.println("y value: " + yField.getText());
                }
                String cardID=xField.getText();
                String cardPw=yField.getText();
                boolean checkCard=service.checkCard(cardID,cardPw);
                if(checkCard){
                    String saveBalance = JOptionPane.showInputDialog(AtmFrame.this,"请您输入存款金额");
                    service.saveMoney(cardID,Float.parseFloat(saveBalance));
                }else{
                    JOptionPane.showMessageDialog(AtmFrame.this,"账号或者密码错误");
                }
            }
        });
        //取款
        withdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("cardID:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("cardPw:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "请输入银行卡号和密码", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("x value: " + xField.getText());
                    System.out.println("y value: " + yField.getText());
                }
                String cardID=xField.getText();
                String cardPw=yField.getText();
                boolean checkCard=service.checkCard(cardID,cardPw);
                if(checkCard){
                    String saveBalance = JOptionPane.showInputDialog(AtmFrame.this,"请您输入取款金额");
                    service.getMoney(cardID,Float.parseFloat(saveBalance));
                }else{
                    JOptionPane.showMessageDialog(AtmFrame.this,"账号或者密码错误");
                }
            }
        });
        //添加银行卡
        addBankCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("cardID:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("cardPw:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "请输入银行卡号和密码", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("x value: " + xField.getText());
                    System.out.println("y value: " + yField.getText());
                }
                String cardID=xField.getText();
                String cardPw=yField.getText();

                service.addBankCard(aname,cardID,cardPw);
            }
        });
    }
    protected void setFrameSelf() {
        this.setBounds(300,200,800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

}
