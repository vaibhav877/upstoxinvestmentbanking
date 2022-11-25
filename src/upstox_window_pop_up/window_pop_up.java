package upstox_window_pop_up;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_pop_up {

	public static void main(String[] args) throws InterruptedException {
		//
		System.setProperty("webdriver.chrome.driver", "D:\\QA\\softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://upstox.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Sign In'])[3]")).click();
		Thread.sleep(3000);
		//get both widow ids
		Set<String> ids = driver.getWindowHandles();
		ArrayList<String>a=new ArrayList<String>(ids);
		String parrentid = a.get(0);
		String childid = a.get(1);
		
		//switch focus of selenium from man page to child window
		driver.switchTo().window(childid);
		Thread.sleep(3000);
		
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7028414553");
	}

}
