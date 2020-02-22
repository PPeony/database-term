package controller;

import domain.Card;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class QueryController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String name=(String)session.getAttribute("name");
        ArrayList<Card> list=service.query(name);
        req.setAttribute("list",list);
        req.getRequestDispatcher("queryMoney.jsp").forward(req,resp);
    }
}
