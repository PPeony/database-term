package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.UserService;

@Controller("userController")
@SessionAttributes({"userID","userName","cardID"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register.do")
    public String register(String userID,String userName,String userIDCard,String password){
        System.out.println(userID+"--"+userName+"--"+userIDCard+"--"+password);
        userService.register(userID,userName,userIDCard,password);
        return "index.jsp";
    }

    @RequestMapping("login.do")
    public String login(String userID, String password, ModelMap map){
        System.out.println("执行了login");
        User user=userService.login(userID,password);
        if (user!=null){
            map.addAttribute("userID",userID);
            map.addAttribute("userName",user.getUserName());
            return "welcome.jsp";
        }else{
            map.addAttribute("flag","1");
            return "index.jsp";
        }
    }
    @RequestMapping("judgeAccountPassword.do")
    public String judgeAccountPassword(String oldPassword,String newPassword,ModelMap map){
        String userID=(String)map.getAttribute("userID");
        System.out.println("我执行了吗？？？？？？？？？？？？？？");
        User user=userService.judgeAccountPassword(userID,oldPassword);
        System.out.println("执行if之前uuuuuuuuuuuuuuuuuuu");
        if(user==null){
            System.out.println("user是空的uuuuuuuuuuuuuuuuuuuuuuu");
            map.addAttribute("flag","原始密码错误");
            return "changePassword.jsp";
        }else{
            System.out.println("user不是空的uuuuuuuuuuuuuuu");
            userService.changeAccountPassword(user,newPassword);
            return "commonConfirmPage.jsp";
        }
    }
}
