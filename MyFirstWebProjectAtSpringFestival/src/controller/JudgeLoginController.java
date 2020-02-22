package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JudgeLoginController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag=true;
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        //if(name!=null&&password!=null)
        flag=service.login(name,password);
//        else{
//            req.setAttribute("flag",false);
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
//        }
        if (flag){
            req.getRequestDispatcher("login").forward(req,resp);
        }else{
            req.setAttribute("flag","error");
            System.out.println("回到主页");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
