package ecommerce.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Guru99.Util;

public class DemoGuruEcomm {
	
	WebDriver driver;
	
	@BeforeTest
	public void launch(){
		driver = new FirefoxDriver();
		String Url = " http://live.demoguru99.com/index.php/";
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void Test1(){
		
		boolean text = driver.getPageSource().contains("This is demo site");
		System.out.println("Given text is present on the Homepage: "+text);
		
		String Actual = driver.getTitle();
		System.out.println(Actual);
		
		if (Actual.contains("Home page")) {
			System.out.println("HomePage Title is verified");
		}
		else {
			System.out.println("HomePage Title is not verified");
		}
	}
	
	@Test
	public void Test2(){
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		String Act = driver.getTitle();
		if (Act.contains("Mobile")) {
			System.out.println(" Mobile Title is verified");
		}
		else {
			System.out.println("Mobile Title is not verified");
		}
	}
	
	@Test
	public void Test3(){
		WebElement element = driver.findElement(By.xpath("//*[@title = 'Sort By']"));
		Select s = new Select(element);
		s.selectByVisibleText("Name");
		
	}
	
	@AfterTest
	public void close(){
		driver.quit();
	}
}
