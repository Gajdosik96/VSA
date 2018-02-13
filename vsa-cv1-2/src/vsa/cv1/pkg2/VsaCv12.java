/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa.cv1.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Viktor
 */
public class VsaCv12 {

    /**
     * @param args the command line arguments
     */
    private static Connection con;
    private static Statement st;
        
    public static void main(String[] args) throws SQLException {
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        st = con.createStatement();
        // TODO code application logic here
        
        System.out.println("Cena knihy podvod je "+cenaKnihy("Podvod"));
        System.out.println("Nova kniha bola pridana: "+pridajKnihu("Podvody",22.2));
        
        
        System.out.println("Cena knihy podvod pred zlavou je "+cenaKnihy("Podvod"));
        zlava("Podvod");
        System.out.println("Cena knihy podvod po zlave je "+cenaKnihy("Podvod"));
        
        
    }
    
    public static double cenaKnihy(String meno) throws SQLException
    {
        ResultSet rs = st.executeQuery("SELECT CENA FROM kniha WHERE nazov='"+meno+"'");
        if(rs.next()) {
            return rs.getDouble(1);
        } else {
            System.err.println("Kniha s menom "+meno+" neexistuje");
        }
        return 0;
    }
    
    public static boolean pridajKnihu(String meno, double cena) throws SQLException
    {
        try{
            int rs = st.executeUpdate("INSERT INTO KNIHA (NAZOV, CENA) VALUES ('"+meno+"', "+cena+")");
            if(rs == 1) {
                return true;
            }
        }catch(java.sql.SQLIntegrityConstraintViolationException e)
        {
            return false;
        }
        return false;

    }
    
    public static void zlava(String meno) throws SQLException{
        st.executeUpdate("UPDATE KNIHA SET CENA = CENA*0.8 WHERE NAZOV='"+meno+"'");
    }
    
}
