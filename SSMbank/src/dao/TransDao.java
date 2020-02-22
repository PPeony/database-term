package dao;

import domain.Trans;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransDao {
    @Insert("insert into trans values(#{cardID},#{transType},#{transMoney},#{transDate})")
    public void insert(Trans trans);
    @Select("select * from trans where cardID=#{cardID}")
    public ArrayList<Trans> selectList(Trans trans);
}
