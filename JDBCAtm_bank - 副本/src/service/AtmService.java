package service;

import dao.UserDao;
import dao.cardDao;
import dao.transDao;
import domain.User;
import domain.card;
import domain.trans;
import util.MySpring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AtmService {
    //业务层只负责处理数据，比较，判断
    private UserDao dao= MySpring.getBean("dao.UserDao");
    private cardDao carddao=MySpring.getBean("dao.cardDao");
    private transDao transdao=MySpring.getBean("dao.transDao");
    public String login (String account,String apw){
        User user=dao.selectOne(account);
        if (user!=null){
            if(user.getPassword().equals(apw)){
                return "登录成功";
            }
            return "登录失败";
        }
        return "登录失败";
    }
    public boolean checkCard(String cardID,String pw){
        card newCard=carddao.selectOne(cardID);
        if(newCard!=null){
            if(newCard.getCardPw().equals(pw)){
                return true;
            }
            return false;
        }
        return false;
    }
    //设计一个方法查询人
    public boolean isExist(String name){
        if(dao.selectOne(name)!=null){
            return true;
        }
        return false;
    }
    //查询历史记录
    public ArrayList<trans>selectHistory(String cardID){
        return transdao.selectList(cardID);
    }
    //添加银行卡
    public void addBankCard(String userID,String cardID,String cardPW){
        card newCard=new card(userID,cardID,cardPW,0f);

        carddao.insert(newCard);
    }
    //注册
    public void regist(String account,String name,String id,String pw){

        User user=new User(account,name,id,pw);
        dao.insert(user);
    }
    //查询余额
    public Float queryBalance(String carID){
        return carddao.selectOne(carID).getCardMoney();

    }
    //存款
    public void  saveMoney(String cardID,Float money){//存款carddao操作
        card newCard=carddao.selectOne(cardID);
        newCard.setCardMoney(newCard.getCardMoney()+money);
        System.out.println("newCard.money="+newCard.getCardMoney());
        carddao.deposit(newCard);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dat=df.format(new Date());
        System.out.println("存款时设置时间为"+dat);
        trans tr=new trans(cardID,"deposit",money,dat);
        System.out.println("t的dat为:"+ tr.getDate());
        transdao.deposit(tr);
    }
    //取款
    public void getMoney(String cardID,Float money){
        card newCard=carddao.selectOne(cardID);
        newCard.setCardMoney(newCard.getCardMoney()-money);
        carddao.withdraw(newCard);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dat=df.format(new Date());
        trans tr=new trans(cardID,"withdraw",money,dat);
        transdao.withdraw(tr);
    }
}
