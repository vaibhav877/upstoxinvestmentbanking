package ddf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class login {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		//
System.setProperty("webdriver.chrome.driver", "D:\\QA\\softwares\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//open url upstox login page
driver.get("https://login-v2.upstox.com/");
//fetch login credentials from excel sheet
FileInputStream file=new FileInputStream("D:\\QA\\selenium excel\\upstoxPOMwith_pagefactory_DDF.xlsx");
Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
String UserId = sh.getRow(1).getCell(0).getStringCellValue();
String Password = sh.getRow(1).getCell(1).getStringCellValue();
String pin = sh.getRow(1).getCell(2).getStringCellValue();
//enter UserId
driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(UserId);
//Enetr Password
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
//click on sign in to upstox button
driver.findElement(By.xpath("//div[text()='Sign into Upstox']")).click();
Thread.sleep(3000);
//enter pin
driver.findElement(By.xpath("//input[@name='yob']")).sendKeys(pin);
//click on No,i am good button
Thread.sleep(3000);
driver.findElement(By.xpath("//div[text()='No, I’m good']")).click();
Thread.sleep(3000);
String ExpctName = "Ramesh T.";
String ActName = driver.findElement(By.xpath("(//span[@class='_3YI_lRyLDAFhz2WE-6yGuX'])[2]")).getText();
if(ExpctName.equalsIgnoreCase(ActName))
{System.out.println(" Login TC : pass");}
else
{System.out.println("TC : Fail");}

////ADD stock in watchlist
//Actions act=new Actions(driver);
//Thread.sleep(3000);
//WebElement watchlistDD = driver.findElement(By.xpath("//div[@id='watchlistSelect_dropdown']"));
////clickon watvchlistdd
//act.moveToElement(watchlistDD).click().build().perform();
//Thread.sleep(2000);
//WebElement favorite = driver.findElement(By.xpath("//div[@id='Favourites_title']"));
//act.moveToElement(favorite).click().perform();
//driver.findElement(By.xpath("//button[@data-id='watchlistAdd']")).click();
//driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("idea");
//Thread.sleep(2000);
//driver.findElement(By.xpath("//button[@id='NSE_EQ|14366']")).click();
////to buy idea stock
//driver.findElement(By.xpath("//div[@id='NSE_EQ-14366']")).click();
////buy idea
//driver.findElement(By.xpath("//button[@id='buyBtn']")).click();
////enter quantity
//driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("2");
////select intraday or delivery using action class
//
//WebElement product = driver.findElement(By.xpath("//div[@data-id='productDropdown']"));
//act.click(product).perform();
//WebElement delivery = driver.findElement(By.xpath("//div[text()='Delivery']"));
//act.click(delivery).perform();
//
//
////select complexity SIMPLE or AMO
//WebElement complexity = driver.findElement(By.xpath("//div[@data-id='complexityDropdown']"));
//act.moveToElement(complexity).click().perform();
////selecti order type
////WebElement order = driver.findElement(By.xpath("//div[@data-id='orderTypeDropdown']"));
////act.moveToElement(order)
//
////click on review market order button
//driver.findElement(By.xpath("//button[@data-id='ReviewBuyOrder']")).click();
//driver.findElement(By.xpath("//button[@type='submit']")).click();


//chech stocks avaibility in watchilst
System.out.println("chech stocks avaibility in watchilst");
List<WebElement> stocks = driver.findElements(By.xpath("//div[@class='F9Jx2Z1yb6NPapDPIxxhQ _127m3JFg0WYtmrQh3_-5-c']//div[@class=\"_13HnWTRDRQy8PpJTnAt9lc\"]"));

ArrayList<String> arlist=new ArrayList<String>();
for(WebElement x:stocks)
{
	String stocklist = x.getText();
	System.out.println(stocklist);
	arlist.add(stocklist);
		}

System.out.println(arlist.contains("HDFC"));



}}
