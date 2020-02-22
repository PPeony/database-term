package controller;

import domain.Trans;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindHistoryController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("执行了service");
        String id=(String)req.getAttribute("cardID");
        req.setAttribute("cardID",id);
        ArrayList<Trans>list=new ArrayList<>();
        list=service.findHistory(id);
        req.setAttribute("list",list);
        req.getRequestDispatcher("findHistory.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了post");
        this.service(req, resp);
    }
}
