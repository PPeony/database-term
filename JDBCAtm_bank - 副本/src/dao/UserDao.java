package dao;

import MyORM.SqlSession;
import domain.User;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("all")
public class UserDao {
    //持久层
   private SqlSession sqlSession=SqlSession.getSqlSession();
   public class UserFuZhi implements MyORM.FuZhi{
       //提供赋值策略
       public <T>T fuzhi(ResultSet resultSet) throws SQLException {
           User user=new User();
           user.setID(resultSet.getString("userID"));
           user.setIDcard(resultSet.getString("userIDCard"));
           user.setName(resultSet.getString("userName"));
           user.setPassword(resultSet.getString("userPw"));
            return (T)user;
       }
   }
   public User selectOne(String account){
       String sql="select * from user where userID=?";
       return sqlSession.selectOne(sql,new UserFuZhi(),account);
   }
   public <T>ArrayList<T>selectList(){
       return sqlSession.selectList("select * from Atm",new UserFuZhi());
   }
    public void insert(User user){
        String sql = "insert into user(userID,userName,userIDCard,userPw) values(?,?,?,?)";
        sqlSession.insert(sql,user.getID(),user.getName(),user.getIDcard(),user.getPassword());
    }
   public void update(User user){
       String sql="update user set userPw=? where userName=?";
       sqlSession.update(sql,user.getPassword(),user.getName());
   }

   public void delete(String name){
       //太复杂，不提供销户功能
   }
}
