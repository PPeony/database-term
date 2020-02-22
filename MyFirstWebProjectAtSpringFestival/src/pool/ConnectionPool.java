package pool;

import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionPool {
    private ConnectionPool(){

    }
    private  static volatile ConnectionPool pool;
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
    private ArrayList<MyConnection>list=new ArrayList<>();
    {
        int minCount=10;
        for(int i=0;i<minCount;i++){
            list.add(new MyConnection());
        }
    }
    public synchronized Connection getMc(){
        Connection result=null;
        for(int i=0;i<list.size();i++){
            MyConnection mc=(MyConnection) list.get(i);
            if(!mc.isUsed()){
                result=mc;
                mc.setUsed(true);
                System.out.println("成功get到mc");
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
        if(result==null){
            System.out.println("系统正忙，请稍后再试");
        }
            return result;

    }
}
