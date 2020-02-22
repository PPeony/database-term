package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JudgeAccountPasswordController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword=req.getParameter("oldPassword");
        String newPassword=req.getParameter("newPassword");
        boolean flag=false;
        HttpSession session=req.getSession();
        String name=(String)session.getAttribute("name");
        flag=service.judgeAccountPassword(name,oldPassword);
        if(flag){
            service.changeAccountPassword(name,oldPassword,newPassword);
            req.getRequestDispatcher("commonFirmPage.jsp").forward(req,resp);
        }else{
            req.setAttribute("flag","false");
            req.getRequestDispatcher("changePassword.jsp").forward(req,resp);
        }
    }
}
