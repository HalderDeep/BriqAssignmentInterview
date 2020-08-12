package com.SampleProj.com;


import java.io.File;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelwriter {
	
	
	
	@SuppressWarnings("deprecation")
	public void Myexcelwriter(String path, int rwno, int cellno, String Data) throws Exception{
	
	//define the file path where excel sheet will be generated
	String filepath= (path);
	File file= new File(filepath);
	
	FileOutputStream fos=new FileOutputStream(file);
    // creating a blank workbook    
	Workbook wb= new XSSFWorkbook();
        //creating a blank excel sheet
	Sheet sh= wb.createSheet("TestSheet");
//	we are defining where we need to print the data
        Row rw= sh.createRow(rwno);
        
	Cell cl=rw.createCell(cellno);
        //defining the  input type
	cl.setCellType(CellType.STRING);
        //define the data value
	cl.setCellValue(Data);
	System.out.println("test data Sucessfully entered into excel");
        // writing in the workbook
	wb.write(fos);
	wb.close();
	}
	public static void main(String[] args) throws Exception {
		//Calling the method
		excelwriter ex= new excelwriter();
		ex.Myexcelwriter(".\\excelsheet\\test.xlsx", 5,5,"This is Sampledata- Deep");
	
	}	
}

