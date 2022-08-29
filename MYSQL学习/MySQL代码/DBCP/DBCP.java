package src.MySQL.DBCP;

import src.MySQL.DBCP.utils.DBCPUtiles;

import java.sql.*;

public class DBCP {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBCPUtiles.getConnection();
            String sql = "select * from `student`";
             preparedStatement = connection.prepareStatement(sql);
//           statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM `student`");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id="+resultSet.getObject("id"));
                System.out.println("name="+resultSet.getObject("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
//                DBCPUtiles.release(connection,statement,resultSet);
                DBCPUtiles.release(connection,preparedStatement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
