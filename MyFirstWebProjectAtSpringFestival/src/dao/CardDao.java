package dao;

import domain.Card;
import orm.SqlSessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardDao {
    private SqlSessionFactory sqlSessionFactory=SqlSessionFactory.getInstance();
    private class CardStrategy implements orm.Strategy{

        @Override
        public <T> T strategy(ResultSet resultSet) throws SQLException {
            Card card=new Card();
            card.setUserID(resultSet.getString("userID"));
            card.setCardID(resultSet.getString("cardID"));
            card.setCardPw(resultSet.getString("cardPw"));
            card.setCardMoney(resultSet.getFloat("cardMoney"));
            return (T)card;
        }
    }
    public ArrayList<Card> selectList(String userID){
        String sql="select * from card where userID=?";
        return sqlSessionFactory.selectList(sql,new CardStrategy(),userID);
    }
    public void update(String cardID,Float money){
        String sql="update card set cardMoney=? where cardID=?";
        sqlSessionFactory.update(sql,money,cardID);
    }
    public Card selectOne(String cardID){
        String sql="select * from card where cardID=?";
        return sqlSessionFactory.selectOne(sql,new CardStrategy(),cardID);
    }
    public void insert(String name,String cardID,String cardPassword){
        String sql="insert into card values(?,?,?,?)";
        sqlSessionFactory.insert(sql,name,cardID,cardPassword,0);
    }
}
