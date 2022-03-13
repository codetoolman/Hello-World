package demo1;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
public class demo1 {
    public static void main(String[] args) throws SQLException {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=jxgl_1;";
        Connection connection = null;// 连接数据库
        String Name="sa";
        String Pwd="yangfuyang";
        try{

            Class.forName(driverName);
            System.out.println("驱动加载成功！");
            connection=DriverManager.getConnection(url,Name,Pwd);
            System.out.println("连接数据库成功");
            PreparedStatement statement=connection.prepareStatement("SELECT sname from Students Where class='03物流1'");
            ResultSet resultSet=null;
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                String tile =resultSet.getString("sname");
                System.out.println(tile);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
