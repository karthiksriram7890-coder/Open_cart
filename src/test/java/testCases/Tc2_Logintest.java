package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Test.Homepage;
import pageObjects.Test.Loginpage;
import pageObjects.Test.Myaccountpage;
import testBase.Baseclass;

public class Tc2_Logintest extends Baseclass {
	
	@Test(groups= {"sanity","Master"})
	public void verify_login() {
		logger.info("verify login test");
		try
		{
	
		Homepage hp = new Homepage(driver);
		
	   logger.info("Clicking My Account");
		hp.clickmyaccount();
		
		
		
		  logger.info("Clicking Login");
		hp.clicklogin();
		
		Loginpage lp =new Loginpage(driver);
		logger.info("Entering email");
		lp.setEmail(p.getProperty("email"));
		
		logger.info("Entering password");
		lp.setPassword(p.getProperty("password"));
		logger.info("Clicking Login button");
		lp.clickLogin();
		
		
		Myaccountpage sq= new Myaccountpage(driver);
		logger.info("Verifying My Account page");
		
		boolean targetpage=sq.myAccountExists();
		
		 logger.info("My Account verification result: " + targetpage);
		Assert.assertTrue(targetpage);
		
		   logger.info("Logging out");
		sq. clickLogout();
	
		
		}
		
		
		
		catch (Exception e) {
		    throw e;
		}
		
		logger.info("finish login test");
	}
	
	
	
}


