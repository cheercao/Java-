package src.MySQL.FirstJdbc;

import java.sql.*;

public class JdbcConnect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";
        //3.连接成功;
        Connection connection = DriverManager.getConnection(url,username,password);

        //4.执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql的对象去执行sql语句
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
