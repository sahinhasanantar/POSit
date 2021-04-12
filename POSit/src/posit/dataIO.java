package posit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;  
import java.io.FileReader;  
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class dataIO {
    public static void writeData (){
        System.out.println("found writeData");
    }
    
    public static String collectData (String fileName) throws FileNotFoundException, IOException{
        FileReader FRObj = new FileReader(fileName);
        BufferedReader FRBObj = new BufferedReader(FRObj);
        
        System.out.println("found collectData");
        
        String foundData = "";
        String newLine = "\n";
        
        String testLine = FRBObj.readLine();
        while(testLine != null){
            foundData = foundData + testLine ;
            testLine = FRBObj.readLine();
            
            if (testLine != null) {
                foundData += newLine;
            }
        }
        
        return foundData;
    }
    
    public static void addData(String code, String productName, String unitPrice, String quantity, String fileName) throws FileNotFoundException, IOException{
        FileWriter FWobj = new FileWriter(fileName, true);
        FileReader FRObj = new FileReader(fileName);
        try (BufferedWriter FWBobj = new BufferedWriter(FWobj)) {
            BufferedReader FRBObj = new BufferedReader(FRObj);
            
            String newLine = "\n";
            System.out.println(FRBObj.readLine());
            if (FRBObj.readLine() != null){
                System.out.println("Data found");
                FWBobj.append(newLine);
            }
            
            System.out.println("found collectData");
            FWBobj.append(code + "@" + productName + "@" + unitPrice + "@" + quantity + "\n");
        }
        
        
        
        
    }
    
    public static void clearLine(String fileName, String lineNumber) throws IOException{
        int lineNum = Integer.parseInt(lineNumber);
        String newLine = "\n";
        String newFile = "";
        
        FileWriter FWobj = new FileWriter(fileName, true);
        FileReader FRObj = new FileReader(fileName);
        try (BufferedWriter FWBobj = new BufferedWriter(FWobj)) {
            BufferedReader FRBObj = new BufferedReader(FRObj);
            
            for(int i = 0; i < lineNum - 1; i++){
                newFile += FRBObj.readLine() + newLine;
            }
            FRBObj.readLine();
            
            String keepAddings = FRBObj.readLine();
            
            
            while(keepAddings != null){
                newFile += keepAddings;
                keepAddings = FRBObj.readLine();
                
                if (keepAddings != null){
                    newFile += newLine;
                }
            }
            
            clearData(fileName);
            FWBobj.append(newFile);
        }
    }
    
    public static void clearData(String fileName) throws IOException{
        FileWriter FWobj = new FileWriter(fileName);
    }
    
}
