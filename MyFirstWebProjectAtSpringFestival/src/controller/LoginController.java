package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String ID=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println("输入的"+ID+" "+password);
        boolean flag=service.login(ID,password);
            RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
            HttpSession session=req.getSession();
            session.setAttribute("name",ID);
            rd.forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
