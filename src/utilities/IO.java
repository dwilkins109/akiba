package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class IO {
    
    
    
     
    public static List<String> readFromTextFile(File f) throws Exception {
        List<String> fileContent = new ArrayList();

        InputStream inStrm = new FileInputStream(f);
        Reader rdr = new InputStreamReader(inStrm);
        BufferedReader bufRdr = new BufferedReader(rdr);

        while (true) {
            String line = bufRdr.readLine();
            if (line == null) break;
            line = line.replace(String.valueOf((char) 0xFEFF), "");
            fileContent.add(line);
        }

        return fileContent;
    }
    
     public static List<String> readTextFile(String fileName) throws Exception {
         File f = new File(fileName);
         List<String> fileContent = readFromTextFile(f);
         return fileContent;
     }
    
    
}
