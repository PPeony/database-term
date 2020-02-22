package MyORM;

import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@SuppressWarnings("all")
public class SqlSession {
    private SqlSession(){}
    private static volatile SqlSession sqlSession;
    public static SqlSession getSqlSession(){
        if(sqlSession==null){
            synchronized (SqlSession.class){
                if(sqlSession==null){
                    sqlSession=new SqlSession();
                }
            }
        }
        return sqlSession;
    }
    public <T>ArrayList<T> selectList(String sql,FuZhi fz,Object...values){
        ArrayList<T>list=new ArrayList<>();
        try {
            ConnectionPool pool= ConnectionPool.getInstance();
            Connection conn=pool.getConnection();
            PreparedStatement statement=conn.prepareStatement(sql);
            for(int i=0;i<values.length;i++){
                statement.setObject(i+1,values[i]);
            }
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                T obj=fz.fuzhi(resultSet);
                list.add(obj);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public <T>T selectOne(String sql,FuZhi fz,Object...values){
        T obj=null;

        try {
            ConnectionPool pool=ConnectionPool.getInstance();
            Connection conn=pool.getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            for(int i=0;i<values.length;i++){
                preparedStatement.setObject(i+1,values[i]);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                obj=fz.fuzhi(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;

    }
    public void update(String sql,Object...values){
        try {
            ConnectionPool pool=ConnectionPool.getInstance();
            Connection conn=pool.getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            for(int i=0;i<values.length;i++){
                preparedStatement.setObject(i+1,values[i]);
            }
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            //System.out.println("x="+x);
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insert(String sql,Object...values){
        this.update(sql,values);
    }
    public void delete (String sql,Object...values){
        this.update(sql,values);
    }
}
