package dao;

import domain.User;
import orm.SqlSessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private SqlSessionFactory sqlSessionFactory=SqlSessionFactory.getInstance();
    private class UserStrategy implements orm.Strategy{
        @Override
        public <T> T strategy(ResultSet resultSet) throws SQLException {
            User user=new User();
            user.setName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("userPw"));
            user.setID(resultSet.getString("userID"));
            user.setIDCard(resultSet.getString("userIDCard"));
            return (T) user;
        }
    }
    public User selectOne(String name){
        String sql="select * from user where userID=?";
        return sqlSessionFactory.selectOne(sql,new UserStrategy(),name);
    }
    public void insert(User user){
        String sql="insert into user (userID,userName,userIDCard,userPw) values(?,?,?,?)";
        sqlSessionFactory.insert(sql,user.getID(),user.getName(),user.getIDCard(),user.getPassword());
    }
    public void update(User user){
        String sql="update user set userPw=? where userID=?";
        sqlSessionFactory.update(sql,user.getPassword(),user.getID());
    }

}
