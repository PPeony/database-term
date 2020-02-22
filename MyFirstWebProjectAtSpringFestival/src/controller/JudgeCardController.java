package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JudgeCardController extends HttpServlet {
    private UserService service= MySpring.getBean("service.UserService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardID=req.getParameter("cardID");
        String password=req.getParameter("password");
        String target=req.getParameter("target");
        HttpSession session=req.getSession();
        String account=(String)session.getAttribute("name");
        boolean flag=true;
        flag=service.judge(account,cardID,password);
        if(flag){
            //String target=req.getParameter("target");
            req.setAttribute("cardID",cardID);
            if ("findHistory.jsp".equals(target)){
                //当转到查询历史记录的页面时候,转到另一个controller
                req.getRequestDispatcher("findHistory").forward(req,resp);
            }
            //req.setAttribute("judgePassword",true);
            else req.getRequestDispatcher(target).forward(req,resp);
        }else{
            req.setAttribute("target",target);
            req.setAttribute("flag","false");
            req.setAttribute("judgePassword",false);
            req.getRequestDispatcher("enterCard.jsp").forward(req,resp);
        }
    }
}
