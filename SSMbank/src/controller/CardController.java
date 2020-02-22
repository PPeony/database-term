package controller;

import domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.CardService;
import service.TransService;

import java.util.ArrayList;

@Controller
@SessionAttributes({"userID","userName","cardID"})
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private TransService transService;
    @RequestMapping("addCard.do")
    public String addCard(String cardID, String cardPassword, ModelMap model){
        String userID=(String)model.getAttribute("userID");
        cardService.addCard(userID,cardID,cardPassword);
        return "commonConfirmPage.jsp";
    }
    @RequestMapping("midWay.do")
    public String midway(String target,ModelMap map){
        map.addAttribute("target",target);
        return "enterCard.jsp";
    }
    @RequestMapping("judgeCardPassword.do")
    public String judgeCardPassword(String cardID, String password, String target, ModelMap map){
        //System.out.println(cardID+"--"+password+"--"+target);

            Boolean flag=cardService.judge((String)map.getAttribute("userID"),cardID,password);
            if(flag){
                map.addAttribute("cardID",cardID);
                if("findHistory.jsp".equals(target)){
                    return "findHistory.do";
                }else return target;

            }else{
                map.addAttribute("target",target);
                map.addAttribute("flag","0");
                return "enterCard.jsp";
            }
    }
    @RequestMapping("query.do")
    public String query(ModelMap map){
        String userID=(String)map.getAttribute("userID");
        ArrayList<Card>list=cardService.query(userID);
        map.addAttribute("list",list);
        return "queryMoney.jsp";
    }
    @RequestMapping("saveMoney.do")
    public String saveMoney(String cardID,String money){
        Float newMoney=Float.parseFloat(money);
        cardService.saveMoney(cardID,newMoney);
        transService.changeMoney(cardID,newMoney,"save");
        return "commonConfirmPage.jsp";
    }
    @RequestMapping("depositMoney.do")
    public String depositMoney(String cardID,String money){
        Float newMoney=Float.parseFloat(money);
        cardService.depositMoney(cardID,newMoney);
        transService.changeMoney(cardID,newMoney,"deposit");
        return "commonConfirmPage.jsp";
    }
}
