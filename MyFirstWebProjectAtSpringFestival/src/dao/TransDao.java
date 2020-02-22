package dao;

import domain.Trans;
import orm.SqlSessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransDao {
    private SqlSessionFactory sqlSessionFactory=SqlSessionFactory.getInstance();
    public class TransStrategy implements  orm.Strategy{

        @Override
        public <T> T strategy(ResultSet resultSet) throws SQLException {
            Trans trans=new Trans();
            trans.setCardID(resultSet.getString("cardID"));
            trans.setDate(resultSet.getString("transDate"));
            trans.setTransType(resultSet.getString("transType"));
            trans.setTransMoney(resultSet.getFloat("transMoney"));
            return (T)trans;
        }
    }
    public void insert(Trans trans){
        //每次交易的时候新增记录
        String sql="insert into trans values(?,?,?,?)";
        sqlSessionFactory.insert(sql,trans.getCardID(),trans.getTransType(),trans.getTransMoney(),trans.getDate());
    }
    public ArrayList<Trans>selectList(String name){
        //查询一张卡的交易记录
        String sql="select * from trans where cardID=?";
        return sqlSessionFactory.selectList(sql,new TransStrategy(),name);
    }
}
