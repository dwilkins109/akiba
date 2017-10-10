package espeon;

import utilities.IO;


import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utilities.DB;



public class Espeon {

 
    
    public static void main(String[] args) {
        System.out.println("working on the IO branch. v2");
        
        fooDB();
        
        
    }
    
    
    
    
    static void fooDB() {
        String dbName = "zeta";
        String tblName = "kanjis";
        
        try {            
            Connection dbConn = IO.getDbConn(dbName);
            
            Set<Map<String, Object>> tblContent = DB.select(dbConn, tblName);
            for(Map<String, Object> row : tblContent) {
                for(Map.Entry col : row.entrySet()) {
                    String key = col.getKey().toString();
                    String val = col.getValue().toString();
                    System.out.println(key + " ---> " + val);
                }
                System.out.println("=====");
            }
      
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    static void fooFile() {
        try {
            List<String> fileContent = IO.readTextFile("/tmp/aaa.txt");
            for(String s : fileContent) {
                System.out.println(s);
            }            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
