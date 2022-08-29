package src.MySQL.UtilJdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcutile {
    private static String driver = null;
    private static String url = null;
    private static String password = null;
    private static String username = null;
    static {
        try {
            InputStream in = jdbcutile.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = (String) properties.get("driver");
            url = (String) properties.get("url");
            username = (String) properties.get("username");
            password = (String) properties.get("password");
            //1.驱动只要加载一次
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(driver);
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }

    }
}
