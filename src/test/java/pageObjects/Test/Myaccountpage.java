package pageObjects.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Myaccountpage extends Basepage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[text()='My Account']")
	WebElement msgheadings;
	@FindBy(linkText="Logout")
	WebElement lnklogout;
		
	public boolean myAccountExists() {
		
		try
		{
			return (msgheadings.isDisplayed()) ;	
		}catch(Exception e) {
		// TODO Auto-generated method stub
		return false;
	}
	}
		
		public void clickLogout() {
			
			
			 js.executeScript("arguments[0].scrollIntoView(true);", lnklogout);
			 System.out.println("Displayed : " + lnklogout.isDisplayed());
			    System.out.println("Enabled   : " + lnklogout.isEnabled());
			 
			    wait.until(ExpectedConditions.visibilityOf(lnklogout));
			    
			   lnklogout.click();

			       
			  
			
		}

	}

