package service;

import dao.TransDao;
import domain.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class TransService {
    @Autowired
    private TransDao transDao;
    public void changeMoney(String cardID,Float money,String transType){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dat=df.format(new Date());
        transDao.insert(new Trans(cardID,transType,money,dat));
    }
    public ArrayList<Trans>findHistory(String cardID){
        Trans trans=new Trans();
        trans.setCardID(cardID);
        ArrayList<Trans>list=transDao.selectList(trans);
        //System.out.println(list.get(0).getDate()+"这是service的findHistory");
        return list;
    }

}
