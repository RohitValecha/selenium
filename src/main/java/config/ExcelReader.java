package config;


import base.BaseClass;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader extends BaseClass{

    public static XSSFWorkbook book;
    public static XSSFSheet sheet;
    public static FileInputStream fis;
    public static XSSFRow row;

    public static int rowCount;
    public static int columnCount;

    public static String TestDataSheet = "C://Users//AMIT//Desktop//Data.xlsx";

    @DataProvider(name= "dataProvider")
    public Object[][] loadExcel() throws Exception {

        System.out.println("Loading Excel");
        File file = new File(TestDataSheet);
        fis = new FileInputStream(file);
        book = new XSSFWorkbook(fis);

        for (int i = 0; i <= book.getNumberOfSheets(); i++) {
            String sheetName = book.getSheetName(i);
            if (sheetName.equals("Sheet3")) {
                sheet = book.getSheetAt(i);
                break;
            }
        }
        fis.close();
        rowCount = sheet.getLastRowNum();
        columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[rowCount][1];
        for (int i = 0; i < rowCount; i++) {
            HashMap<String ,String> myMap = new HashMap<String ,String>();
            for (int j = 0; j < columnCount; j++) {
                myMap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
            }
            obj[i][0] = myMap;
        }
        return obj;

    }


    @DataProvider(name = "data")
    public Object[][] dataSupplier() throws IOException {
        File file = new File(TestDataSheet);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        fis.close();
        int lastRowNum = sheet.getLastRowNum() ;
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];
        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<Object, Object>();
            for (int j = 0; j < lastCellNum; j++) {
                datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
            }
            obj[i][0] = datamap;
        }
        return  obj;
    }
}

//    public static HashMap<String,HashMap<String,String >> getDatawithMap() throws Exception {
//
//        if(sheet==null){
//            loadExcel();
//        }
//        HashMap<String,HashMap<String ,String>> superMapv= new HashMap<String, HashMap<String, String>>();
//        HashMap<String ,String> myMap= new HashMap<String, String>();
//
//        for(int i=0;i<=columnCount;i++){
//            row= sheet.getRow(i);
//            String keyCell
//        }
//
//        return null;
//    }
//
//    public static Object[][] getTestData(String sheetName){
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(TestDataSheet);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            book = WorkbookFactory.create(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }
//        sheet = book.getSheet("Sheet1");
//
//        return Object[][];
//    }
//}
