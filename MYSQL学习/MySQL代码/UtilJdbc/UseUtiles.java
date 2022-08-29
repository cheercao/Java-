package src.MySQL.UtilJdbc;

import src.MySQL.UtilJdbc.util.jdbcutile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseUtiles {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = jdbcutile.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM `student`");
        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
        }
        jdbcutile.release(connection,statement,resultSet);
    }
}
