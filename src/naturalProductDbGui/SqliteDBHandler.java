/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturalProductDbGui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozing003
 */
public class SqliteDBHandler {
    
    
    private Connection con = null;
    
    private Statement statement = null;
    
    private ResultSet results = null;
    
    
    public Connection connect(String url){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:"+ url);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(SqliteDBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet runQuery(Connection con,String query) {
        try {
            //creates a statement within the db
            statement = con.createStatement();
            //gives a query to the statment and executes it. stores the results in a variable.
            results = statement.executeQuery(query);
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(SqliteDBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void disconnect(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqliteDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getResultSet() {
        return results;
    }
    
}
