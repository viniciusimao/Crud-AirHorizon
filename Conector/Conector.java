package Conector;

import java.sql.*;

public class Conector {
   
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ViniGamer21@";
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/crud";

    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);


        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();

        if(con != null){
            System.out.println("Servidor ligado");
            con.close();
        }
        

    }
}
