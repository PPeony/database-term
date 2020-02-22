package service;

import dao.UserDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    public void register(String userID,String userName,String userIDCard,String userPw){
        User user=new User(userName,userPw,userID,userIDCard);
        userDao.insert(user);
    }
    public User login(String userID,String userPw){
        User user=new User();
        user.setUserID(userID);
        user.setUserPw(userPw);
        return userDao.selectOne(user);
    }
    public User judgeAccountPassword(String userID,String oldPassword){
        User user=userDao.selectOne(new User("",oldPassword,userID,""));
        System.out.println("我到达servicereturn之前了");
        return user;
    }
    public void changeAccountPassword(User user,String newPassword){
        user.setUserPw(newPassword);
        userDao.update(user);
    }
}
