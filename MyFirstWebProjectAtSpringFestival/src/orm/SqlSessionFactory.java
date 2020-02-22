package orm;

import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlSessionFactory {
    private SqlSessionFactory(){}
    private static volatile SqlSessionFactory sqlSessionFactory;
    public static synchronized SqlSessionFactory getInstance(){
        if (sqlSessionFactory==null){
            synchronized (SqlSessionFactory.class){
                if (sqlSessionFactory==null){
                    sqlSessionFactory=new SqlSessionFactory();
                }
            }
        }
        return sqlSessionFactory;
    }
    public <T>ArrayList<T> selectList(String sql,Strategy strategy,Object...objs){
        ArrayList<T>list=new ArrayList<>();
        try {
            ConnectionPool pool= ConnectionPool.getInstance();
            Connection connection=pool.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<objs.length;i++){
                preparedStatement.setObject(i+1,objs[i]);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                T obj=strategy.strategy(resultSet);
                list.add(obj);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }
    public <T>T selectOne(String sql,Strategy strategy,Object...objs){
        T obj=null;
        try {
            Connection connection=(Connection)ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<objs.length;i++){
                preparedStatement.setObject(i+1,objs[i]);

            }
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                obj=strategy.strategy(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void update(String sql,Object...objs){
        try {
            Connection connection=(Connection)ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i<objs.length;i++){
                preparedStatement.setObject(i+1,objs[i]);
            }
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insert (String sql,Object...objs){
        this.update(sql,objs);
    }
    public void delete(String sql,Object...objs){
        this.update(sql,objs);
    }
}

