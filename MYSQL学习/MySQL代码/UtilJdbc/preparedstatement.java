package src.MySQL.UtilJdbc;

import src.MySQL.UtilJdbc.util.jdbcutile;

import java.sql.*;
import java.util.Date;

public class preparedstatement {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 使用?来占位 之后通过setInt等函数来将具体的内容填入，这种会有效打的防止SQL注入，建议使用
            String sql = "INSERT INTO `student` VALUE(?,?,?,?,?,?,?);";
            connection = jdbcutile.getConnection();
            statement = connection.prepareStatement(sql);
            //11,'cheer','123','男',CURTIME(),'湖南科技大学','269764632@qq.com'
            statement.setInt(1,11);
            statement.setString(2,"cheer");
            statement.setString(3,"123");
            statement.setString(4,"男");
            statement.setString(5, String.valueOf(new java.sql.Date(new Date().getTime())));
            statement.setString(6,"湖南科技大学");
            statement.setString(7,"269764632@qq.com");
            int i = statement.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcutile.release(connection,statement,resultSet);
        }
    }
}
