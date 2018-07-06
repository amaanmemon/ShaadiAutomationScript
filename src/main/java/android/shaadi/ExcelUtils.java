package android.shaadi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.http.util.TextUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtils
{
    static Sheet wrksheet;
    static Workbook wrkbook =null;
    static Hashtable table = null;
    public static HashMap<String, String> keysValue = null;

    public ExcelUtils(Hashtable hashtable, Workbook excelWorkBook, int sheetNo)
    {
        System.out.println("Read the excel sheet and path is : -> "+excelWorkBook + "   Sheet number :->"+ sheetNo);
        table = hashtable;
        wrkbook = excelWorkBook;
        wrksheet = excelWorkBook.getSheet(sheetNo);        
    }

    public static int rowCount()
    {
        return wrksheet.getRows();
    }

    public static String readCell(String key)
    {
        String send = null;
        try{
            send = (String) table.get(key);            
            return send;
        }catch(Exception e){
            e.printStackTrace();
            return send;
        }
    }
    
    
//    public static int getCell(String colName)
//    {        
//        try {
//            int value;
//            value = ((Integer) table.get(colName)).intValue();
//            return value;
//        } 
//        catch (NullPointerException e)
//        {
//            return (0);
//        }
//    }

    public static void rowdictionary()
    {    
        for(int row=0; row < wrksheet.getRows(); row++)
        {
            if(wrksheet.getName().equalsIgnoreCase("Execute only")){

                if(!TextUtils.isEmpty(wrksheet.getCell(1, row).getContents()) && wrksheet.getCell(1, row).getContents().equalsIgnoreCase("Y")){

                    if(keysValue == null){
                        keysValue = new HashMap<String, String>();
                    }

                    keysValue.put(wrksheet.getCell(0, row).getContents(), wrksheet.getCell(1, row).getContents());
                }
            }else{
                table.put(wrksheet.getCell(0, row).getContents(), wrksheet.getCell(1, row).getContents());    
            }
        }    
    }

    public static void valueOverWrite(String name, int col, int row, String newValue) {

        try
        {
            FileOutputStream f = new FileOutputStream("src/main/resources/testdata.xls",true);
            WritableWorkbook book= Workbook.createWorkbook(new File("src/main/resources/testdata.xls"));
            WritableSheet sheet = book.getSheet(name);
            Label l = new Label(col, row, newValue);
            sheet.addCell(l);
            book.write(); 
            book.close(); 
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    

}