package ecommerce.Guru99;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GuruLogin {
	static WebDriver driver;
	File f;
	FileInputStream fi;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	@Test
	public void LoginTest() throws IOException, InterruptedException{
		
		File f = new File("D:\\GitHub_Samples\\Guru99\\GuruBankLogin.xlsx");
		FileInputStream fi =new FileInputStream(f);
		wb =new XSSFWorkbook(fi);
		sh = wb.getSheetAt(0);
		int rc = sh.getLastRowNum();
		
		for (int i = 1; i <= rc; i++) {
			
			driver = new FirefoxDriver();
			driver.get("http://www.demo.guru99.com/V4/");
			
			driver.findElement(By.name("uid")).clear();
			driver.findElement(By.name("uid")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
			
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());	
			
			driver.findElement(By.name("btnLogin")).click();
			
		try{
			Alert al = driver.switchTo().alert();
			String altext = al.getText();
			al.accept();
			System.out.println("Alert message :" +altext);
			
			if (altext.contains("User or Password is not valid")) {
				System.out.println("Test case at " + i +" passed");
			}
			else {
				System.out.println("Test case at " + i +"failed");
			}
		}
		catch(NoAlertPresentException ex){
			
			String ActualTitle = driver.getTitle();
			System.out.println(ActualTitle  );
			
			if (ActualTitle.equals(com.Guru99.Util.ExpectedTitile)) {
				System.out.println("Test case passed");
			
			}
			else{
				System.out.println("Testcase Failed");
			
			}
			
		}
		
		driver.quit();
		Thread.sleep(3000);
		}
	}
}
