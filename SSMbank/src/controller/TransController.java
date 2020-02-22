package controller;

import dao.TransDao;
import domain.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.TransService;

import java.util.ArrayList;

@Controller
@SessionAttributes({"userID","userName","cardID"})
public class TransController {
    @Autowired
    private TransService transService;
    @RequestMapping("findHistory.do")
    public String findHistory(ModelMap map){
        String cardID=(String)map.getAttribute("cardID");
        //System.out.println("cardID= "+cardID+"$$$$$$$$$$$$$");
        map.addAttribute("cardID",cardID);
        ArrayList<Trans>list=transService.findHistory(cardID);
        //System.out.println(list.get(0).getDate()+"$$$$$$$$$$$$$$$");
        map.addAttribute("list",list);
        map.remove("cardID");

        return "findHistory.jsp";
    }
}
