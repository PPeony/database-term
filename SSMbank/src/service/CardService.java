package service;

import dao.CardDao;
import dao.TransDao;
import domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CardService {
    @Autowired
    private CardDao cardDao;
    public void addCard(String userID,String cardID,String cardPassword){
        cardDao.insert(new Card(userID,cardID,cardPassword,0f));
    }
    public void saveMoney(String cardID,Float money){
        Float prevMoney=cardDao.selectOne(new Card("",cardID,"",0f)).getCardMoney();
        Float newMoney=prevMoney+money;
        cardDao.update(new Card("",cardID,"",newMoney));
    }
    public void depositMoney(String cardID,Float money){
        Float prevMoney=cardDao.selectOne(new Card("",cardID,"",0f)).getCardMoney();
        Float newMoney=prevMoney-money;
        cardDao.update(new Card("",cardID,"",newMoney));
    }
    public ArrayList<Card> query(String userID){
        return cardDao.selectList(new Card(userID,"","",0f));
    }
    public boolean judge(String userID,String cardID,String password){
        ArrayList<Card> list=cardDao.selectList(new Card(userID,cardID,password,0f));
        for( Card card: list){
            if(card.getCardID().equals(cardID)){
                if(card.getCardPw().equals(password))
                    return true;
                else return false;
            }
        }
        return false;
    }
}
