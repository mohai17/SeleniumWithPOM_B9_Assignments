package com.parabank.parasoft.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class General {

    public static final int WAIT_TIME = 30;

    public static void waitToSee(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object[][] getData(String sheetName){
        Workbook workbook;
        Sheet sheet;

        try {
            String filepath = System.getProperty("user.dir")+"/src/test/resources/Book2.xlsx";
            FileInputStream inputStream = new FileInputStream(filepath);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=1;i<sheet.getLastRowNum();i++){
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){

                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

                System.out.println(data[i][j]);
            }
        }

        return data;
    }

//    public static void main(String[] args)
//    {
//        getData("Sheet1");
//    }

}
