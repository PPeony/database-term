package dao;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into user values (#{userID},#{userName},#{userIDCard},#{userPw}) ")
    public void insert(User user);
    @Select("select * from user where userID=#{userID} and userPw=#{userPw}")
    public User selectOne(User user);
    @Update("update user set userPw=#{userPw} where userID=#{userID}")
    public void update(User user);
}
