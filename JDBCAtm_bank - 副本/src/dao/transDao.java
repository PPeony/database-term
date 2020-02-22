package dao;

import MyORM.SqlSession;
import domain.trans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class transDao {
    private SqlSession sqlSession=SqlSession.getSqlSession();
    public class transFuZhi implements MyORM.FuZhi{

        @Override
        public <T> T fuzhi(ResultSet resultSet) throws SQLException {

            trans t = new trans();
            t.setCardID(resultSet.getString("cardID"));
            t.setTransType(resultSet.getString("transType"));
            t.setTransMoney(resultSet.getFloat("transMoney"));
            t.setDate(resultSet.getString("transDate"));
            return (T) t;
        }
    }
    public ArrayList<trans> selectList(String cardID){
        String sql="select cardID,transType,transMoney,transDate from trans where cardID=?";
        return sqlSession.selectList(sql,new transFuZhi(),cardID);
    }
    public void deposit(trans tr){
        String sql="insert into trans values (?,?,?,?)";
        sqlSession.insert(sql,tr.getCardID(),tr.getTransType(),tr.getTransMoney(),tr.getDate());
    }
    public void withdraw(trans tr){
        String sql="insert into trans values(?,?,?,?)";
        sqlSession.insert(sql,tr.getCardID(),tr.getTransType(),tr.getTransMoney(),tr.getDate());
    }
}
