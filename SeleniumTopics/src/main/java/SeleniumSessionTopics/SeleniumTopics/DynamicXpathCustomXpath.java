package SeleniumSessionTopics.SeleniumTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathCustomXpath {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.get("https://www.ebay.com/");

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page loaded before that remaining time will be ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page loaded before that remaining time will be ignored Also this timeouts() are global variable no need to assign again & again to wait until the page loads.
		d.get("https://www.ebay.com/");
		
		//Absolute Xpath: not recommended 
		d.findElement(By.xpath("//li[2]//a[1]//div[1]")); 
		//1. Performance issue
		//2. Not reliable
		//3. Can be changed @ any time in future 
		
		//Relative Xpath: Recommended 
		d.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Mobiles");
		//Custom xpath:
		// 1. Should start with //
		//2. input-is HTML tag name
		d.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Laptop");
		
		d.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input')]")).sendKeys("Mobiles");
		//1.= is not used instead , is used
		
		//Dynamic id: inputs
		//id=test_123
		//By.id("test_123")
		
		//Starts with:
		//id= test_569
		//id=test_789
		//id=test_789_test_523
		
		//Ends with:
		//id =125_test_t
		//id=89533_test_t
		//id=8955465_test_t
		
		d.findElement(By.xpath("//input[contains(@id, 'test_')]")).sendKeys("Laptop");
		d.findElement(By.xpath("//input[starts-with(@id, 'test_')]")).sendKeys("Laptop");
		d.findElement(By.xpath("//input[starts-with(@id, 'test_t')]")).sendKeys("Laptop");
		
		//for Links custom XPath:
		//All the links are represented by <a> in Selenium when you inspect ie, HTML tag name 
		d.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		//here My Account is the text taken for example 
		



		
		
		
		
		

	}

}
