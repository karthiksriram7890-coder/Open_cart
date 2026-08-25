package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Test.AccountRegistrationpage;
import pageObjects.Test.Homepage;
import testBase.Baseclass;

public class TC1_Accountregistrationpage extends Baseclass {

	@Test(groups= {"sanity","regression","Master"})
	 public void verifyAccountRegistration() {
		logger.info("Starting TC1 Account registration");
		
		try {
		Homepage HP=new Homepage(driver);
		
		HP.clickmyaccount();
		logger.info("click on Accountlink");
		
		HP.registeraccount();
		logger.info("click on Registeraccountink");
		
		AccountRegistrationpage ARP = new AccountRegistrationpage(driver);
		
		logger.info("Providing customer details");
		ARP.setFirstName(randomeString().toUpperCase());
		ARP.setLastName(randomeString().toUpperCase());
		ARP.setEmail(randomeString()+"@gmail.com");
		
		String Password=randomAlphaNumberic();
			ARP.setPassword(Password);
		
		     ARP.newsClick();
	         ARP.agreeClick();
		     ARP.continueClick();
		
  logger.info("validating expected message");	
  String confmsg= ARP.getConfirmationMsg();
  if (confmsg.equals( "Your Account Has Been Created!")) {
	  Assert.assertTrue(true);
  }else {
	  
		logger.error("Test failed");
		logger.debug("debuglogs");
	  Assert.assertTrue(false);
	  
		}
 
				
	}catch(Exception e) {
		
		Assert.fail();
	}
		
		logger.info("finished TC1 Account registration");
		
		
	}


	

}
