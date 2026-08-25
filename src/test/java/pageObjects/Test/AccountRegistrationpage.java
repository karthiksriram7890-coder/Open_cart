package pageObjects.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountRegistrationpage extends Basepage {

	public AccountRegistrationpage(WebDriver driver) {
		super(driver);
		
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailid;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pass;
	
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement newsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agrre;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accountcreated;
	
	public void setFirstName(String fname) {
		txt_firstname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		emailid.sendKeys(email);
	}
	public void setPassword(String pwd) {
		pass.sendKeys(pwd);
		
	}
	public void newsClick() {
		
		    act.moveToElement(newsletter).click().perform();
	}

	

public void agreeClick() {
	
	  act.moveToElement(agrre).click().perform();

}


public void continueClick() {
	act.moveToElement(btn).click().perform();
}

public String getConfirmationMsg() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(accountcreated));

	    return accountcreated.getText();
}
}

