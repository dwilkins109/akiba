package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class DB {     
    
        public static Set<Map<String, Object>> select(Connection conn, String tableName) throws Exception {
        Set<Map<String, Object>> allRows = new HashSet<Map<String, Object>>();
        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM " + tableName);
        ResultSet queryResults = prepStmt.executeQuery();
        ResultSetMetaData rsMetaData = queryResults.getMetaData();
        
        while(queryResults.next()) {
            Map<String, Object> row = new HashMap<String, Object>();
            
            for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                String colName = rsMetaData.getColumnName(i);
                
                String colClassName = rsMetaData.getColumnClassName(i);
                Class colClass = Class.forName(colClassName);
                Object colValue = colClass.cast(queryResults.getObject(i));
                
                row.put(colName, colValue);
            }
            allRows.add(row);
        }
        return allRows;
    }
    
    
    
}
