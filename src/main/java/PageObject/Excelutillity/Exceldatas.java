package PageObject.Excelutillity;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Exceldatas {
    
public Object[][] getdata()throws Exception{
        File file = new File("Testdatas.xlsx");
        System.out.println(file.exists());
        FileInputStream fis = new FileInputStream(file);       //reading data from any file.
        XSSFWorkbook workbook = new XSSFWorkbook(fis);       //conversion of row data into  excel workbook format.
        XSSFSheet sheet = workbook.getSheet("Sheet1");  // from the sheet we need to get the sheet.
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getLastRowNum());
        int noOfrows = sheet.getPhysicalNumberOfRows();  //getting total no.of rows.
        int noOfcolumn = sheet.getRow(0).getLastCellNum();   //gives the total no.of column are present in the Ist row.
        Object[][] data = new Object[noOfrows-1][noOfcolumn];
        for(int i=0; i<noOfrows-1; i++){
            for(int j=0; j<noOfcolumn; j++){
                DataFormatter df = new DataFormatter();
                data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));  // getting and printing row and cell values and storing in a variable array.
            }
            System.out.println( );
        }

        workbook.close();
        fis.close();
//        for (Object[] dataARR : data){
//            System.out.println(Arrays.toString(dataARR));
//        }
       return data;
    }

    
}
