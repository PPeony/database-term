package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("cardID");
        String stringMoney=req.getParameter("money");
        Float money=Float.parseFloat(stringMoney);
        service.saveMoney(id,money);
        req.getRequestDispatcher("commonConfirmPage.jsp").forward(req,resp);
    }
}
