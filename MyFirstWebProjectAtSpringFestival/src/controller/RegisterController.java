package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID=req.getParameter("账号");
        String name=req.getParameter("名字");
        String password=req.getParameter("密码");
        String IDCard=req.getParameter("身份证号");
        System.out.println(userID+" "+name+" "+IDCard+" "+password);
        service.register(userID,name,IDCard,password);
        String newUrl="confirmPage.jsp";
        req.getRequestDispatcher(newUrl).forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
