package dao;

import domain.Card;
import domain.Trans;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardDao {
    @Select("select * from card where userID=#{userID}")
    public ArrayList<Card> selectList(Card card);
    @Update("update card set cardMoney=#{cardMoney} where cardID=#{cardID}")
    public void update(Card card);
    @Select("select * from card where cardID=#{cardID}")
    public Card selectOne(Card card);
    @Insert("insert into card values(#{userID},#{cardID},#{cardPw},#{cardMoney})")
    public void insert(Card card);
}
