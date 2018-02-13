/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Viktor
 */
public class Cv1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        //Implementovať pomocou JDBC connect na DB
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement st = con.createStatement();
        
        // Implmentovať select *, otestovať
        ResultSet rs = st.executeQuery("SELECT * FROM KNIHA");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
       // Implmentovať select count, otestovať 
        rs = st.executeQuery("SELECT count(*) FROM kniha");
        while (rs.next()) {
            System.out.println("" + rs.getInt(1));
        }
    }
    
}
