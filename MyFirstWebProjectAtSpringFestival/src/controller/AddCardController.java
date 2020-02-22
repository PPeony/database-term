package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCardController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardID=req.getParameter("cardID");
        String password=req.getParameter("cardPassword");
        HttpSession session=req.getSession();
        String name=(String)session.getAttribute("name");
        service.addCard(name,cardID,password);
        req.getRequestDispatcher("commonConfirmPage.jsp").forward(req,resp);
    }
}
