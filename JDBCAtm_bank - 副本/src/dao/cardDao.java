package dao;

import MyORM.SqlSession;
import domain.card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class cardDao {
    private SqlSession sqlSession=SqlSession.getSqlSession();
    public class cardFuZhi implements MyORM.FuZhi{
        //提供赋值策略
        public <T>T fuzhi(ResultSet resultSet) throws SQLException {
            card newCard=new card();
            newCard.setUserID(resultSet.getString("userID"));
            newCard.setCardID(resultSet.getString("cardID"));
            newCard.setCardPw(resultSet.getString("cardPw"));
            newCard.setCardMoney(resultSet.getFloat("cardMoney"));
            return (T)newCard;
        }
    }
    //添加银行卡
    public void insert(card newCard){
        String sql = "insert into card(userID,cardID,cardPw,cardMoney) values(?,?,?,?)";
        sqlSession.insert(sql,newCard.getUserID(),newCard.getCardID(),newCard.getCardPw(),newCard.getCardMoney());
    }
    //存款
    public void deposit(card newCard){
        String sql="update card set cardMoney=? where cardID=?;";
        System.out.println("dao:cardID="+newCard.getCardID()+" cardMoney="+newCard.getCardMoney());
        sqlSession.update(sql,newCard.getCardMoney(),newCard.getCardID());
    }
    //取款
    public void withdraw(card newCard){
        String sql="update card set cardMoney=? where cardID=?;";
        sqlSession.update(sql,newCard.getCardMoney(),newCard.getCardID());
    }
    public card selectOne(String cardID){
        String sql="select * from card where cardID=?";
        return sqlSession.selectOne(sql,new cardFuZhi(),cardID);
    }
}
