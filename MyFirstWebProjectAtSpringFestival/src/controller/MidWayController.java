package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MidWayController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target=req.getParameter("target");

        req.setAttribute("target",target);
        System.out.println("midway的target"+target);
        req.getRequestDispatcher("enterCard.jsp").forward(req,resp);
    }
}
