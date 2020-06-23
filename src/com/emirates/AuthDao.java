package com.emirates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDao {

    // db related variables;
    String url = "jdbc:mysql://localhost:3306/aliens";
    String username = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";

    String query = "select * from auth_info where username = ? and password = ?;";

    public boolean authenticate(String username, String password){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
