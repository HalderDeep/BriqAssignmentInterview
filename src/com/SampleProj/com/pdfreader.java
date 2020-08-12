package com.SampleProj.com;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class pdfreader {
 static WebDriver driver;
 
 // below is the method to read the pdf file
	public void MyReadPDFContent(String path) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		// initializing  the driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// opening the pdf file link
		driver.get(path);
		
		driver.manage().window().maximize();
		String Currentlink=driver.getCurrentUrl();
		URL url=new URL(Currentlink);
		//opening the pdf file
		InputStream is=url.openStream();
		BufferedInputStream fp=new BufferedInputStream(is);
		PDDocument document=null;
		//loading the file
		document=PDDocument.load(fp);
//		reading the text
		String pdfContent= new PDFTextStripper().getText(document);
		// printing the pdf content
		System.out.println("Printing the PDF content");
		System.out.println(pdfContent);
		driver.close();
		driver.quit();
		driver=null;
		
		System.out.println("End");
		
		
	}
	
	public static void main(String[] args) throws Exception {
		//calling the reader method
		pdfreader pf= new pdfreader();
		pf.MyReadPDFContent("http://africau.edu/images/default/sample.pdf");
		
	}
}
