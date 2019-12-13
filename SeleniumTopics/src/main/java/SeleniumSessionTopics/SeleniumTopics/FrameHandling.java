package SeleniumSessionTopics.SeleniumTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.get("****************"); //To know where Frames are used. Right click on the element "This frames" will be visible. If it is visible then frames are present 

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page loaded before that remaining time will be ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page loaded before that remaining time will be ignored 
		//Also this timeouts() are global variable no need to assign again & again to wait until the page loads.
			
		//Frames 
		d.switchTo().frame(1); //1 is the index can be used value/String also
		//switch() = switches the focus from web to frames element
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//@id='value'")).click();
	}

}
