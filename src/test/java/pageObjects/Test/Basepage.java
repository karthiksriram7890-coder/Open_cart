package pageObjects.Test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {

	WebDriver driver;
	 Actions act;
	 WebDriverWait wait;
	 JavascriptExecutor js;

	  
	public Basepage(WebDriver driver) {
		this.driver=driver;
		 js = (JavascriptExecutor) driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 act = new Actions(driver);  
		PageFactory.initElements(driver, this);
		
		
	}
}
