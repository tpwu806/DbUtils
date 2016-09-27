import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class Test {
	static Connection conn = null;
	public static void main(String[] args){
		testInsert();
	}
    //@Test  
    public static void testInsert() {  
        final String SQL = "insert into test values(?, ?)";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection2();  
            int result = new QueryRunner().update(conn, SQL, new Object[] {  
                    "JohnGao1", "123" });  
            if (0 < result)  
                System.out.println("数据插入成功...");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    }  
      
    

	//@Test  
    public void testUpdate() {  
        final String SQL = "update test_1 set password= ? where username = ?";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection();  
            int result = new QueryRunner().update(conn, SQL, new Object[] {  
                    "321", "JohnGao1" });  
            if (0 < result)  
                System.out.println("数据更新成功...");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    }  
      
    //@Test  
    public void testDelete() {  
        final String SQL = "delete from test_1 where username like ?";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection();  
            int result = new QueryRunner().update(conn, SQL, "%JohnGao%");  
            if (0 < result)  
                System.out.println("数据删除成功...");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    }  
      
    //@Test  
    public void testQuery() {  
        final String SQL = "select * from test_1";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection();  
            Test test1Bean = (Test) new QueryRunner().query(conn, SQL,  
                    new BeanHandler(Test.class));  
            if (null != test1Bean) {  
                //System.out.println(test1Bean.getUsername());  
                //System.out.println(test1Bean.getPassword());  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    } 
    
    public void testQuery4() {  
        final String SQL = "select * from test_1 where username like ?";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection2();  
            List<Map<String, Object>> values = new QueryRunner().query(conn,  
                    SQL, new Object[] { "%JohnGao%" }, new MapListHandler());  
            if (null != values) {  
                for (int i = 0; i < values.size(); i++) {  
                    Map<String, Object> map = values.get(i);  
                    System.out.println(map.get("username"));  
                    System.out.println(map.get("password"));  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    }  
    
    public void testQuery3() {  
        final String SQL = "select * from test_1 where username like ?";  
        try {  
            if (null == conn || conn.isClosed())  
                conn = ConnectionManager.getConnection();  
            List<Test_1Bean> test1Beans = (List<Test_1Bean>) new QueryRunner().query(conn, SQL,  
                    new Object[] { "%JohnGao%" }, new BeanListHandler(  
                            Test_1Bean.class));  
            if (null != test1Beans) {  
                for (Test_1Bean test1Bean : test1Beans) {  
                    //System.out.println(test1Bean.getUsername());  
                    //System.out.println(test1Bean.getPassword());  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            close(conn);  
        }  
    }  
    private static void close(Connection conn2) {
		// TODO Auto-generated method stub
		
	}
}
