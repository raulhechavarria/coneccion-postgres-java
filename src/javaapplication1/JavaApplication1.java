/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author rhp
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String  url = "jdbc:postgresql://localhost:5432/testdb";
        String  user = "raul";
        String  password = "raul";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            java.sql.Statement st = conn.createStatement();
            String query = "SELECT * from person";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String idr = rs.getString(1);
                String namer = rs.getString(2);
                System.out.println("id: " + idr +" name: "+ namer);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection Error animal" + e.getMessage());
        }
                
                
        
    }
    
}
