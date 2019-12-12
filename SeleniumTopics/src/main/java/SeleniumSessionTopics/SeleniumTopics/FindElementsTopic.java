package SeleniumSessionTopics.SeleniumTopics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsTopic {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.get("https://www.facebook.com/");

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page loaded before that remaining time will be ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page loaded before that remaining time will be ignored 
		//Also this timeouts() are global variable no need to assign again & again to wait until the page loads.
				
		/*
		 * Task: 1.get the total number of links in the page 2.get the text of each link
		 * name on the page
		 */
		
		List <WebElement> lr = d.findElements(By.tagName("a")); //When ever .findElements is used we should use "List <WebElement> lr"
		System.out.println(lr.size()); 
		
		for(int i=0; i<lr.size(); i++) {
			String s = lr.get(i).getText();
			System.out.println(s);
			
		}
		
		
	}

}
