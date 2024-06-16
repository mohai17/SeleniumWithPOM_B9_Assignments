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
        Workbook workbook = null;
        Sheet sheet = null;
        FileInputStream inputStream = null;
        try {
            String filepath = System.getProperty("user.dir")+"/src/test/resources/Book2.xlsx";
            inputStream = new FileInputStream(filepath);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum()+1;
        int cellCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][cellCount];

//        System.out.println("RowNum:"+sheet.getLastRowNum());
//        System.out.println("CellNum:"+sheet.getRow(0).getLastCellNum());

        for(int i=0;i<rowCount;i++){
            for (int j=0;j<cellCount;j++){

                data[i][j] = sheet.getRow(i).getCell(j).toString();

                System.out.println(data[i][j]);
            }
        }

        return data;
    }

//    public static void main(String[] args){
//        General.getData("MySheet01");
//    }

}


