package pageObjects.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Account;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginaccount;
	
	public void clickmyaccount() {
		
		Account.click();
		
	}
	
	public void registeraccount() {
		
		Register.click();
		
	}
	
public void clicklogin() {
		
	loginaccount.click();
		
	
	
}	

}
