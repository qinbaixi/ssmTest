import org.junit.Test;

import java.sql.*;

public class TestConnection {
    @Test
    public void testConn() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url="jdbc:oracle:thin:@192.168.147.10:1521:orcl";
        String username = "SSMUSER";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement=connection.prepareStatement("select * from product");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                System.out.println(name);
            }
            connection.close();
            statement=null;


        }
    }
}
