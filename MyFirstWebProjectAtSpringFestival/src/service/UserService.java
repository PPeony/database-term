package service;

import dao.CardDao;
import dao.TransDao;
import dao.UserDao;
import domain.Card;
import domain.Trans;
import domain.User;
import util.MySpring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserService {
    private UserDao userDao= MySpring.getBean("dao.UserDao");
    private CardDao cardDao=MySpring.getBean("dao.CardDao");
    private TransDao transDao=MySpring.getBean("dao.TransDao");
    public boolean login(String name,String password){
        User user=userDao.selectOne(name);
        System.out.println("输入的"+name+" "+password);
        //System.out.println("查找的"+user.getID()+" "+user.getPassword());
        if(user==null)return false;
        if(name.equals(user.getID())&&password.equals(user.getPassword())){
            return true;
        }else return false;
    }
    public void register(String account,String name,String ID,String password){
        User user=new User(name,password,account,ID);
        userDao.insert(user);
    }
    public boolean  judge(String account,String cardID,String password){
        ArrayList<Card>list=new ArrayList<Card>();
        list=cardDao.selectList(account);
        for( Card card: list){
            if(card.getCardID().equals(cardID)){
                if(card.getCardPw().equals(password))
                    return true;
                else return false;
            }
        }
        return false;
    }
    public void saveMoney(String cardID,Float money){
        Float prevMoney=cardDao.selectOne(cardID).getCardMoney();
        System.out.println("prevMoney= "+prevMoney);
        Float newMoney=prevMoney+money;
        cardDao.update(cardID,newMoney);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dat=df.format(new Date());
        //System.out.println("存款时设置时间为"+dat);
        Trans tr=new Trans(cardID,"deposit",money,dat);
        //System.out.println("t的dat为:"+ tr.getDate());
        transDao.insert(tr);
    }
    public void depositMoney(String cardID,Float money){
        Float prevMoney=cardDao.selectOne(cardID).getCardMoney();
        Float newMoney=prevMoney-money;
        cardDao.update(cardID,newMoney);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dat=df.format(new Date());
        //System.out.println("存款时设置时间为"+dat);
        Trans tr=new Trans(cardID,"deposit",money,dat);
        //System.out.println("t的dat为:"+ tr.getDate());
        transDao.insert(tr);
    }
    public ArrayList<Card> query(String name){
        ArrayList<Card>list=new ArrayList<>();
        list=cardDao.selectList(name);
        return list;
    }
    public boolean judgeAccountPassword(String name,String oldPassword){
        User u=userDao.selectOne(name);
        if (u.getPassword().equals(oldPassword))return true;
        else return false;
    }
    public void changeAccountPassword(String name,String oldPassword,String newPassword){
        User u=userDao.selectOne(name);
        if(judgeAccountPassword(name, oldPassword)){
            u.setPassword(newPassword);
            userDao.update(u);
        }
    }
    public void addCard(String name,String cardID,String password){
        cardDao.insert(name,cardID,password);
    }
    public ArrayList<Trans> findHistory(String name){
        return transDao.selectList(name);
    }
}
