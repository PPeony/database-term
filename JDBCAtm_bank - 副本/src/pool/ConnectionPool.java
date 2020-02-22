package pool;

import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionPool {
    private ConnectionPool(){}
    private static volatile ConnectionPool pool;
    public static ConnectionPool getInstance(){
        if(pool==null){
            synchronized (ConnectionPool.class){
                if(pool==null){
                    pool=new ConnectionPool();
                }
            }
        }
        return pool;
    }
    private ArrayList<Connection>list=new ArrayList<>();
    {
        int count=10;
        for(int i=1;i<=count;i++){
            list.add(new MyConnection());
        }
    }
    private synchronized Connection getMc(){
        Connection result=null;
        for(int i=0;i<list.size();i++){
            Connection conn=list.get(i);
            MyConnection mc=(MyConnection)conn;

            if(mc.isUsed()==false){
                mc.setUsed(true);
                result=mc;
                System.out.println("getMc成功get到connection");
                break;
            }
        }
        return result;
    }
    public Connection getConnection(){
        Connection result=this.getMc();
        int waitTime=100;
        int count=0;
        while(result==null&&count<waitTime*5){
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result=this.getMc();
        }
        if (result==null){
            System.out.println("系统正忙，请稍后再试");
        }
        return result;
    }
}
