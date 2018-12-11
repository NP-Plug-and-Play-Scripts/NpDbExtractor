/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturalProductDbGui;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * creates the search queries for the NP-DB. uses the user input in the class select.
 * @author ozing003
 */
public class NPQueryMaker {
    private final ArrayList<String> subClasses = new ArrayList();
    private final ArrayList<String> classes = new ArrayList();
    private final ArrayList<String> superClasses = new ArrayList();
    
    /**
     * main method of this class.
     * input should contain the selected classes from the gui and runs queries on them to get a 
     * output that contains the NP-ID, SMILES, SUperClass, class and subClass.
     * @param selectedNpClasses a object list containing the selected Classes from the GUI
     * @param url
     * @param dbInfo
     * @return an ArrayList containing the NP-ID, SMILES, SUperClass, class and subClass 
     */
    public ArrayList<String> NPQueryMaker(Object[] selectedNpClasses, String url, ArrayList<String> dbInfo){
        ArrayList<String> queryOutput = new ArrayList();
        String[] selectedClasses = Arrays.asList(selectedNpClasses).toArray(new String[selectedNpClasses.length]);
        inputSplitter(selectedClasses);
        //creates a query list with the given dbInfo( 0 = tbl name, 1 = idColumn,2 = superclass column, 3 = class column, 4 = subclass column).
        ArrayList<String> queryList = queryListMaker(dbInfo.get(0),dbInfo.get(1),dbInfo.get(2),dbInfo.get(3),dbInfo.get(4));
        ArrayList<String> idList = runQueryList(queryList, url);
        String classQuery = createQueryNameList(idList);
        SqliteDBHandler finalDbHandler = new SqliteDBHandler();
        String query = "select structure_id, smile, superclass, class, subclass from structure where structure_id in (" + classQuery + ");";
        System.out.println(query);
        Connection con = finalDbHandler.connect(url);
        ResultSet queryRS = finalDbHandler.runQuery(con, query);
        try {
                while (queryRS.next()) {
                    //saves the entire db output line in the queryOutput
                    queryOutput.add(queryRS.getString(1) + "|" + queryRS.getString(2) + 
                            "|" + queryRS.getString(3) + "|" + queryRS.getString(4) + "|" + queryRS.getString(5));
                }
            } catch (SQLException ex) {
            Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        finalDbHandler.disconnect(con);
        return queryOutput;
    };
    /**
     * creates a string of names that were given in a list for example [jon,bob,harry]
     * and turns it in to a string like "'jon','bob','harry'" and returns it.
     * @param npClassSelection selected npClasses.
     * @return a string containing the list of string as a single string with every entry in quotations.
     */
    private String createQueryNameList(ArrayList<String> nameList){
        String queryPart = "";
        for(String name: nameList){
            if ( "".equals(queryPart)){
                queryPart = queryPart + "'" + name + "'";
            } else {
                queryPart = queryPart + ", '" + name + "'";
            }
        }
        return queryPart;
    };
    
    
    /**
     * creats a list of queries based on the classes entered in the GUI
     * @return the List of queries.
     */
    private ArrayList<String> queryListMaker(String tblName,String idCol,String superCol,String classCol,String subCol){
        ArrayList<String> queryList = new ArrayList();
        for(String NPClass:subClasses){
            String subQuery = String.format("select %1$s from %2$s where %3$s = '", idCol,tblName,subCol);
            queryList.add(subQuery + NPClass + "';");
        }
        for(String NPClass:classes){
            String classQuery = String.format("select %1$s from %2$s where %3$s = '", idCol,tblName,classCol);
            queryList.add(classQuery + NPClass + "';");
        }
        for(String NPClass:superClasses){
            String superQuery = String.format("select %1$s from %2$s where %3$s = '", idCol,tblName,superCol);
            queryList.add(superQuery + NPClass + "';");
        }
        System.out.println(queryList);
        return queryList;
    };
    /**
     * Runs the list of querys and stores the resulting ID's in a list and returns it
     * @param queryList List of  all queries.
     * @return 
     */
    private ArrayList<String> runQueryList(ArrayList<String> queryList, String url){
        ArrayList<String> npIdList = new ArrayList();
        SqliteDBHandler dbHandler = new SqliteDBHandler();
        for(String query:queryList){
            System.out.println(query);
            Connection con = dbHandler.connect(url);
            ResultSet results =  dbHandler.runQuery(con, query);
            try {
                while (results.next()) {
                    npIdList.add(results.getString(1));
                }
            } catch (SQLException ex) {
            Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbHandler.disconnect(con);
        }
        // Create HashSet from ArrayList.
        HashSet<String> uniqueNpIds = new HashSet<>(npIdList);

        // Create ArrayList from the set.
        ArrayList<String> result = new ArrayList<>(uniqueNpIds);
        return result;
    };
    /**
     * takes the input of the class select in the GUI and adds these to the coresponding classes.
     * uses switch to sort them.
     * @param NPSelection the String[] containing the selected Classes
     */
    public void inputSplitter(String[] NPSelection){
        for (String NPClass:NPSelection){
            String[] splittedNPClass = NPClass.split("\\|");
            switch(splittedNPClass[0]){
                case "super": superClasses.add(splittedNPClass[1]);
                        break;
                case "class": classes.add(splittedNPClass[1]);
                        break;
                case "sub": subClasses.add(splittedNPClass[1]);
                        break;
                default: System.out.println("Not a valid classType");
            }
        }
    };
    
    
    public ArrayList<String> getNpSuperClass(){
        return superClasses;
    }
    
    public ArrayList<String> getNpClass(){
        return classes;
    }
    
    public ArrayList<String> getNpSubClass(){
        return subClasses;
    }
        
}
