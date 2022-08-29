package src.MySQL.DBCP.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import src.MySQL.UtilJdbc.util.jdbcutile;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBCPUtiles {
    private static DataSource dataSource = null;
    static {
        try {
            InputStream in = jdbcutile.class.getClassLoader().getResourceAsStream("DBCP.properties");
            Properties properties = new Properties();
            properties.load(in);
            //创建数据源 工厂模式 --> 创建
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection(); //从数据源中获取连接
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
