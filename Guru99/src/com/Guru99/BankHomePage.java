package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import bsh.util.Util;

public class BankHomePage {
	static WebDriver driver;
	private static String BaseUrl;
	
	public static void setup(){
		driver = new FirefoxDriver();
		BaseUrl = com.Guru99.Util.Base_Url;
		
		driver.manage().timeouts().implicitlyWait(com.Guru99.Util.Wait_Time, TimeUnit.SECONDS);
		driver.get(BaseUrl+ "/V4/");
		//driver.get(com.Guru99.Util.Base_Url);
		
	}
	
	public static void main(String[] args) {
		setup();
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(com.Guru99.Util.UserName);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(com.Guru99.Util.PassWord);	
		
		driver.findElement(By.name("btnLogin")).click();
		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle  );
		
		if (ActualTitle.equals(com.Guru99.Util.ExpectedTitile)) {
			System.out.println("Test case passed");
		}
		else{
			System.out.println("Testcase Failed");
		}
		driver.close();
		  	
	}
		
}

