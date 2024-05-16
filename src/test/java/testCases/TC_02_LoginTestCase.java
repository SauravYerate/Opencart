package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02_LoginTestCase extends BaseClass {
	
	@Test(groups = {"sanity","master"})
	public void verify_Login()
	{
		logger.info("*****Starting Test case 02********");
		
		logger.debug("***Capturing debug logs**********");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.setAccount();
		logger.info(".......Clicked on my account tabl......");
		
		hp.clickLogin();
		
		logger.info(".....Clicked on login link on home Page under my Account....");
		
		LoginPage lp = new LoginPage(driver);
		logger.info(".........Entering valid email and password....");
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		
		lp.clickOnLogin();
		logger.info(".......Clicked on Login Button......");
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean target_page = map.isMyAccountPageExist();
		
		if(target_page==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login test failed");
			Assert.fail();
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("........Finished TC_02_Login Test.......");
		
		
		
		
		
	}

}
