package pageObjects.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
	
	
	
	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailid;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pass;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginaccount;
	
	
	public void setEmail(String email) {
		emailid.sendKeys(email);
	}
	public void setPassword(String pwd) {
		pass.sendKeys(pwd);
		
	}
	public void clickLogin() {
		loginaccount.click();
	
	}
}
