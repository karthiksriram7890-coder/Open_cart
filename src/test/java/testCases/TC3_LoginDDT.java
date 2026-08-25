package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Test.Homepage;
import pageObjects.Test.Loginpage;
import pageObjects.Test.Myaccountpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC3_LoginDDT extends Baseclass {
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class,groups= {"DataDriven"})
	public void verify_loginDDT(String email,String password,String exp) throws Exception {
		
		
	logger.info("*********Starting TC3_LoginDDT**********");	
	
	try {
		Homepage hp = new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		Loginpage lp =new Loginpage(driver);
		
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		
		Myaccountpage sq= new Myaccountpage(driver);
		boolean targetpage=sq.myAccountExists();
		
if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				sq.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
else if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				sq.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
	
	}
		
		}
	} 
		catch(Exception e) {
			  
			    Assert.fail(e.getMessage());
		}
		
		logger.info("*********Ending TC3_LoginDDT**********");
		
		

	}	

}
